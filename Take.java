package game;

import java.util.List;

public class Take extends Command{

	public Take(World world, Hero hero) {
		super(world, hero);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean argOk(List<String> argument) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void launchCommand(Hero hero, List<String> argument) {
		// TODO Auto-generated method stub
		
	}

}
