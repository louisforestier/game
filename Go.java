package game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Go extends Command{
	
	private static final int NB_ARG = 1;
	private static Map<String, Place> args = new HashMap<String, Place>();
	private static Hero hero = null;
	
	public Go(World world, Hero hero) {
		super(world, hero);
		Go.args = this.getWorld().getPlaces();
		Go.hero = this.getHero();
	}
	

	@Override
	public boolean argOk(List<String> argument) {
		boolean result;
		if(argument.size() != Go.NB_ARG) {
			result = false;
		}
		else {
			result = Go.args.containsKey(argument.get(0)); 
		}
		return result;
	}
	
	public Door convertStringToDoor(String name) {
		Place p = this.args.get(name);
		return p.getInteractions().get(name);
	}

	@Override
	public void launchCommand(List<String> argument) {
		//hero.go();	
	}

	
	
}
