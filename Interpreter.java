package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interpreter {
	
	private String command;
	private List<String> arguments = new ArrayList<>();
	private Map<String, Command> commands = new HashMap<String, Command>();
	
	public Interpreter(List<String> scanner, World world, Hero hero) {
		this.command = scanner.get(0);
		this.arguments = scanner;
		this.arguments.remove(0);
		Command go = new Go(world, hero);
		this.commands.put("go", go);
	}
	
	public void interprete(Hero hero) {
		if(commands.containsKey(this.command)) {
			if(commands.get(this.command).argOk(this.arguments)) {
				commands.get(this.command).launchCommand(hero, this.arguments);
			}
		}
	}
}
