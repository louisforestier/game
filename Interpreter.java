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
        Command inventory = new Inventory(world, hero, game);
        this.commands.put("inventory", inventory);
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
