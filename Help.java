package game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Help extends Command{
	
	private static final int NB_ARG_MIN = 0;
	private static final int NB_ARG_MAX = 1;
	
	private static Map<String, Command> commands = new HashMap<>(); 

	public Help(Hero hero, Game game, Map<String, Command> commands) {
		super(hero, game);
		Help.commands = commands;
	}

	@Override
	public void launchCommand(List<String> argument) throws InvalidArgumentNumberException, ClassCastException {
		if (argument.size() == NB_ARG_MIN) {
			this.getGame().help();
		} else if(argument.size() == NB_ARG_MAX) {
			Command c = this.stringToCommand(argument.get(0));
			c.help();
		} else throw new InvalidArgumentNumberException();
	}

	@Override
	public void help() {
		System.out.println("help");
		System.out.println("help command");
	}

	public Command stringToCommand(String name) throws ClassCastException{
		return (Command) commands.get(name);
	}
}
