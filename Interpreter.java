package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interpreter {
	
	private Map<String, Command> commands = new HashMap<String, Command>();
	
	public Interpreter(World world, Hero hero) {
		Command go = new Go(world, hero);
		Command use = new Use(world, hero);
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
