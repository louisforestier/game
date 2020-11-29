package game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Go extends Command{
	
	private static final int NB_ARG = 1;
	private static Map<String, Place> args = new HashMap<String, Place>();
	
	public Go(World world, Hero hero) {
		super(world, hero);
		Go.args = this.getWorld().getPlaces();
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

	@Override
	public void launchCommand(Hero hero, List<String> argument) {
		//hero.go(argument.get(0));	
	}

	
	
}
