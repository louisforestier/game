package game;

import java.util.*;

public class Interpreter {

    private Map<String, Command> commands = new HashMap<>();

    public Interpreter(Hero hero, Game game) {
        Command go = new Go(hero, game);
        this.commands.put("go", go);
        Command use = new Use(hero, game);
        this.commands.put("use", use);
        Command look = new Look(hero, game);
        this.commands.put("look", look);
        Command take = new Take(hero, game);
        this.commands.put("take", take);
        Command quit = new Quit(hero, game);
        this.commands.put("quit", quit);
        Command inventory = new Inventory(hero, game);
        this.commands.put("inventory", inventory);
        Command help = new Help(hero, game, this.commands);
        this.commands.put("help", help);
    }

    public void interpret(String input) {
        String[] parsedInput = input.split(" ");
        List<String> arguments = new LinkedList<>(Arrays.asList(parsedInput.clone()));
        String command = arguments.get(0);
        arguments.remove(0);
        if (commands.containsKey(command)) {
            try {
                commands.get(command).launchCommand(arguments);
            } catch (InvalidArgumentNumberException e) {
                System.out.println("There is too few or too many arguments for this command.");
            } catch (NullPointerException e) {
                System.out.println("There is no " + arguments.get(0) + " around you.");
            } catch (ClassCastException e){
                System.out.println("This is not a valid argument for this command.");
            }
        } else System.out.println("I didn't understand that.");
    }
}
