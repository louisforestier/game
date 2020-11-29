package game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Use extends Command {
	
	private static final int NB_ARG_MAX = 2;
	private static final int NB_ARG_MIN = 1;

	public Use(World world, Hero hero) {
		super(world, hero);
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
	public void launchCommand(Hero hero, List<String> argument) {
		if(argument.size() == Use.NB_ARG_MAX) {
			//hero.use(arg1, arg2);
		}
		else {
			//hero.use(argument.get(0));
		}
		
	}
	
	//public static Item getItem(String nom) {
		
	//}

}
