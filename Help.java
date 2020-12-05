package game;

import java.util.List;

public class Help extends Command{
	
	private static final int NB_ARG = 0;

	public Help(World world, Hero hero, Game game) {
		super(world, hero, game);
	}

	@Override
	public void launchCommand(List<String> argument) throws InvalidArgumentNumberException {
		if (argument.size() == Help.NB_ARG)
			this.getGame().help();
		else throw new InvalidArgumentNumberException();
	}

	@Override
	public void help() {
		// TODO Auto-generated method stub
		
	}

}
