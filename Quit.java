package game;

import java.util.List;

public class Quit extends Command{

	public Quit(World world, Hero hero, Game game) {
		super(world, hero, game);
	}

	@Override
	public boolean argOk(List<String> argument) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void launchCommand(List<String> argument) {
		// TODO Auto-generated method stub
		
	}

	

}
