package game;

import java.util.List;

public class Help extends Command{
	
	private static final int NB_ARG = 0;

	public Help(World world, Hero hero, Game game) {
		super(world, hero, game);
	}

	@Override
	public boolean argOk(List<String> argument) {
		return (argument.size() != Help.NB_ARG);
	}


	@Override
	public void launchCommand(List<String> argument) {
		// TODO Auto-generated method stub
		
	}

}
