package game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Go extends Command{
	
	private static final int NB_ARG = 1;
	private static Map<String, Place> places = new HashMap<String, Place>();
	
	
	public Go(World world, Hero hero, Game game) {
		super(world, hero, game);
		Go.places = this.getWorld().getPlaces();
	}
	

	@Override
	public boolean argOk(List<String> argument) {
		boolean result;
		String param;
		if(argument.size() != Go.NB_ARG) {
			result = false;
		}
		else {
			param = argument.get(0);
			if(Go.places.containsKey(param)) {
				result = this.getHero().getPlace().getInteractions().containsKey(param);
			}
			else result = false;
		}
		return result;
	}
	
	public static Door convertStringToDoor(String name) {
		Place p = Go.places.get(name);
		return (Door)p.getInteractions().get(name);
	}

	@Override
	public void launchCommand(List<String> argument) {
		Door door = Go.convertStringToDoor(argument.get(0));
		this.getHero().go(door);	
	}

	
	
}
