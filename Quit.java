package game;

import java.util.List;

public class Quit extends Command{

	private static final int NB_ARG = 0;

	public Quit(Hero hero, Game game) {
		super(hero, game);
	}

	@Override
	public void launchCommand(List<String> argument) throws InvalidArgumentNumberException {
		if (argument.size() == Quit.NB_ARG)
			this.getGame().quit();
		else throw new InvalidArgumentNumberException();
	}

	@Override
	public void help() {
		System.out.println("quit");
	}

	

}
