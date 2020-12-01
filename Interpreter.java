package game;

import java.util.*;

public class Interpreter {
	
	private Map<String, Command> commands = new HashMap<>();

	public Interpreter(World world, Hero hero, Game game) {
		Command go = new Go(world, hero, game);
		this.commands.put("go", go);
		Command use = new Use(world, hero, game);
		this.commands.put("use", use);
		Command look = new Look(world, hero, game);
		this.commands.put("look", look);
		Command take = new Take(world, hero, game);
		this.commands.put("take", take);
		Command help = new Help(world, hero, game);
		this.commands.put("help", help);
		Command quit = new Quit(world, hero, game);
		this.commands.put("quit", quit);
	}
	
	public void interprete(String input) {
		String[] parsedInput = input.split(" ");
		List<String> arguments = Arrays.asList(parsedInput.clone());
		String command = arguments.get(0);
		arguments.remove(0);
		if(commands.containsKey(command)) {
			if(commands.get(command).argOk(arguments)) {
				commands.get(command).launchCommand(arguments);
			}
		}
	}
}
