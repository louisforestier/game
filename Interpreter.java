package game;

import java.util.*;

public class Interpreter {

    private Map<String, Command> commands = new HashMap<>();

    public Interpreter(Hero hero, Game game) {
        Command go = new Go(hero);
        this.commands.put("go", go);
        Command use = new Use(hero);
        this.commands.put("use", use);
        Command look = new Look(hero, game);
        this.commands.put("look", look);
        Command take = new Take(hero, game);
        this.commands.put("take", take);
        Command quit = new Quit(game);
        this.commands.put("quit", quit);
        Command inventory = new Inventory(hero);
        this.commands.put("inventory", inventory);
        Command help = new Help(game, commands);
        this.commands.put("help", help);
        Command talk = new Talk(hero, game);
        this.commands.put("talk", talk);
        Command attack = new Attack(hero, game);
        this.commands.put("attack", attack);
        Command equip = new Equip(hero);
        this.commands.put("equip", equip);
        Command stat = new Stat(hero);
        this.commands.put("stat", stat);

    }

    public Interpreter(Map<String, Command> commands) {
        this.commands.putAll(commands);
    }

    public boolean interpret(String input) {
        boolean executed_command = true;
        String[] parsedInput = input.split(" ");
        List<String> arguments = new LinkedList<>(Arrays.asList(parsedInput.clone()));
        if (arguments.size() != 0) {                //sinon erreur possible quand on entre juste un espace
            String command = arguments.get(0);
            arguments.remove(0);
            if (commands.containsKey(command)) {
                try {
                    commands.get(command).launchCommand(arguments);
                } catch (InvalidArgumentNumberException e) {
                    System.out.println("There is too few or too many arguments for this command.");
                    executed_command = false;
                } catch (NullPointerException e) {
                    System.out.println("There is no " + arguments.get(0) + " around you.");
                    executed_command = false;
                } catch (ClassCastException e) {
                    System.out.println("This is not a valid argument for this command.");
                    executed_command = false;
                }
            } else {
                System.out.println("I didn't understand that.");
                executed_command = false;
            }
        }
        return executed_command;
    }

}
