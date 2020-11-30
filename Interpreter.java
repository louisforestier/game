package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interpreter {
	
	private Map<String, Command> commands = new HashMap<String, Command>();
	
	public Interpreter(World world, Hero hero, Game game) {
		Command go = new Go(world, hero, game);
		Command use = new Use(world, hero, game);
		this.commands.put("go", go);
		this.commands.put("use", use);
	}
	
	public void interprete(List<String> scanner) {
		String command =scanner.get(0);
		List<String> arguments = new ArrayList<>();
		arguments = scanner;
		arguments.remove(0);
		if(commands.containsKey(command)) {
			if(commands.get(command).argOk(arguments)) {
				commands.get(command).launchCommand(arguments);
			}
		}
	}
}
