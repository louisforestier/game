package game;

import java.util.List;

public class Quit extends Command{

	private static final int NB_ARG = 0;

	public Quit(World world, Hero hero, Game game) {
		super(world, hero, game);
	}

	@Override
	public boolean argOk(List<String> argument) {
		return (argument.size() == Quit.NB_ARG);
	}

	@Override
	public void launchCommand(List<String> argument) {
		this.getGame().quit();
	}

	

}
