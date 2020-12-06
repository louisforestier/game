package game;

import java.util.List;

public class Quit extends Command{

	private static final int NB_ARG = 0;
	
	private static Game game;

	public Quit(Game game) {
		super();
		Quit.game = game;
	}

	@Override
	public void launchCommand(List<String> argument) throws InvalidArgumentNumberException {
		if (argument.size() == Quit.NB_ARG)
			game.quit();
		else throw new InvalidArgumentNumberException();
	}

	@Override
	public void help() {
		System.out.println("quit");
	}

	

}
