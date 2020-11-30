package game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Use extends Command {
	
	private static final int NB_ARG_MAX = 2;
	private static final int NB_ARG_MIN = 1;
	private static Map<String, Lookable> objecsInPlace = new HashMap<String, Lookable>();
	

	public Use(World world, Hero hero, Game game) {
		super(world, hero, game);
		Use.objecsInPlace = this.getHero().getPlace().getInteractions();
	}

	@Override
	public boolean argOk(List<String> argument) {
		boolean result;
		if((argument.size() != Use.NB_ARG_MAX) || (argument.size() != Use.NB_ARG_MIN)) {
			result = false;
		}
		else {
			if(argument.size() == Use.NB_ARG_MIN) {
				if(Use.isInPlace(argument.get(0))) {  
					result = Use.objecsInPlace.get(argument.get(0)) instanceof Usable;
				}
				else if (this.isInInventory(argument.get(0))) {
					result = this.getHero().getInventory().get(argument.get(0)) instanceof Usable;
				}
				else result = false;
			}
			else {
				if(Use.isInPlace(argument.get(0)) && Use.isInPlace(argument.get(1))) {  
					result = Use.objecsInPlace.get(argument.get(0)) instanceof Usable && Use.objecsInPlace.get(argument.get(1)) instanceof Receiver;
				}
				else if (Use.isInPlace(argument.get(0)) && this.isInInventory(argument.get(1))) {
					result = Use.objecsInPlace.get(argument.get(0)) instanceof Usable && this.getHero().getInventory().get(argument.get(1)) instanceof Receiver;
				}
				else if (this.isInInventory(argument.get(0)) && Use.isInPlace(argument.get(1))) {
					result = this.getHero().getInventory().get(argument.get(0)) instanceof Usable && Use.objecsInPlace.get(argument.get(1)) instanceof Receiver;
				}
				else if(this.isInInventory(argument.get(0)) && this.isInInventory(argument.get(1))) {
					result = this.getHero().getInventory().get(argument.get(0)) instanceof Usable && this.getHero().getInventory().get(argument.get(1)) instanceof Receiver;
				}
				else result = false;
				
			}
		}
		return result;
	}


	@Override
	public void launchCommand(List<String> argument) {
		if(argument.size() == Use.NB_ARG_MIN)
			this.getHero().use(this.convertStringToUsable(argument.get(0)));
		else {
			this.getHero().use(this.convertStringToUsable(argument.get(0)), this.convertStringToReceiver(argument.get(1)));
		}
	}
	
	public Usable convertStringToUsable(String name) {
		Usable u;
		if(Use.isInPlace(name)) {
			u = (Usable)Use.objecsInPlace.get(name);
		}
		else {
			u = (Usable)this.getHero().getInventory().get(name);
		}
		return u;
	}
	
	public Receiver convertStringToReceiver(String name) {
		Receiver r;
		if(Use.isInPlace(name)) {
			r = (Receiver)Use.objecsInPlace.get(name);
		}
		else {
			r = (Receiver)this.getHero().getInventory().get(name);
		}
		return r;
	}

	public static boolean isInPlace(String name) {
		return Use.objecsInPlace.containsKey(name);
	}
	
	public boolean isInInventory(String name) {
		return this.getHero().getInventory().containsKey(name);
	}
}
