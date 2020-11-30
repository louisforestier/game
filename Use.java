package game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Use extends Command {
	
	private static final int NB_ARG_MAX = 2;
	private static final int NB_ARG_MIN = 1;
	private static Hero hero = null;
	private static Map<String, Place> args = new HashMap<String, Place>();

	public Use(World world, Hero hero, Game game) {
		super(world, hero, game);
		Use.args = this.getWorld().getPlaces();
		Use.hero = this.getHero();
	}

	@Override
	public boolean argOk(List<String> argument) {
		boolean result;
		if((argument.size() != Use.NB_ARG_MAX) || (argument.size() != Use.NB_ARG_MIN)) {
			result = false;
		}
		else {
			if(argument.size() == Use.NB_ARG_MAX) {
				//if()
				result = true;
			}
			else {
				result = false;
			}
		}
		return result;
	}


	@Override
	public void launchCommand(List<String> argument) {
		// TODO Auto-generated method stub
		
	}
	
	//public static Item getItem(String nom) {
		
	//}

}
