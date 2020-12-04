package game;

import java.util.List;
import java.util.Map;

public class Use extends Command {
	
	private static final int NB_ARG_MAX = 2;
	private static final int NB_ARG_MIN = 1;
	

	public Use(World world, Hero hero, Game game) {
		super(world, hero, game);
	}
	
	public Map<String, Interaction> objectsInPlaceOfHero(){
		return this.getHero().getPlace().getInteractions();
	}
	
	public Place getPlaceOfHero() {
		return this.getHero().getPlace();
	}

	@Override
	public boolean argOk(List<String> argument) {
		return this.oneArg(argument) || this.twoArg(argument);
	}

	
	public boolean oneArg(List<String> args) {
		boolean res = args.size() == Use.NB_ARG_MIN ;
		if(res) {
			res = this.testArgIsUsable(args.get(0));
		}
		return	res;
	}
	
	public boolean testArgIsUsable(String arg) {
		boolean result = false;
		if(this.getPlaceOfHero().isInPlace(arg)) {
			result = this.objectsInPlaceOfHero().get(arg) instanceof Usable;
		} else if (this.getHero().isInInventory(arg)) {
			result = this.getHero().getInventory().get(arg) instanceof Usable;
		}
		return result;
	}
	
	public boolean twoArg(List<String> args) {
		boolean res = args.size() == Use.NB_ARG_MAX;
		if(res) {
			res = this.testArgIsUsable(args.get(0)) && this.testArgIsReceiver(args.get(1));
		}
		return res;
	}
	
	public boolean testArgIsReceiver(String arg) {
		boolean result = false;
		if(this.getPlaceOfHero().isInPlace(arg)) {
			result = this.objectsInPlaceOfHero().get(arg) instanceof Receiver;
		} else if (this.getHero().isInInventory(arg)) {
			result = this.getHero().getInventory().get(arg) instanceof Receiver;
		}
		return result;
	}

	@Override
	public void launchCommand(List<String> argument) throws ClassCastException {
		if(argument.size() == Use.NB_ARG_MIN)
			this.getHero().use(this.convertStringToUsable(argument.get(0)));
		else {
			this.getHero().use(this.convertStringToUsable(argument.get(0)), this.convertStringToReceiver(argument.get(1)));
		}
	}



	public Usable convertStringToUsable(String name) {
		Usable u;
		if(this.getPlaceOfHero().isInPlace(name)) {
			u = (Usable)this.objectsInPlaceOfHero().get(name);
		} else {
			u = (Usable)this.getHero().getInventory().get(name);
		}
		return u;
	}



	public Receiver convertStringToReceiver(String name) {
		Receiver r;
		if(this.getPlaceOfHero().isInPlace(name)) {
			r = (Receiver)this.objectsInPlaceOfHero().get(name);
		} else {
			r = (Receiver)this.getHero().getInventory().get(name);
		}
		return r;
	}

}
