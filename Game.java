package game;

import java.util.*;

public class Game {

    private boolean running = true;
    private final Hero hero;
    private final World world;
    private final Scanner scanner;
    private final Interpreter interpreter;

    public Game(Scanner input) {
        this.hero = new Hero();
        this.world = new World();
        this.scanner = input;
        this.interpreter = new Interpreter(this.hero, this);
    }


    public Scanner getScanner() {
        return scanner;
    }
    
    //cette methode ne sert que pour les tests
    public boolean getRunning() {
    	return this.running;
    }


    public void history() {
        System.out.println();
        System.out.println("Hello hero and welcome to Morlynn Castle.");
        System.out.println("No time for pleasantries.");
        System.out.println("The military are carrying out a coup d'état and have taken the king hostage just now.");
        System.out.println("Your mission, should you choose to accept it, is to kill the guards in the throne room to save the king and exit the castle.");
        System.out.println("I bet the king knows just the way out, because the main entrance has closed just behind you.");
        System.out.println("You managed to sneak into the castle through this one, but in order not to attract attention you don't carry any weapons or armour.");
        System.out.println("You will have to equip yourself by finding what you can in the castle. ");
        System.out.println("Some of the doors will be locked, luckily you can find a way to open them, keys should do the trick.");
        System.out.println("Be careful, the guards might attack you.");
        System.out.println("Good luck, you might need it. ");
        System.out.println("...");
    }

    public void help() {
        System.out.println("You can use the commands :");
        System.out.println("go : with a direction to move through a door to the next room in this direction, if it exists.");
        System.out.println("help : (which you are using right now) to get the details of the commands, if you want a specific command specified after the help.");
        System.out.println("look : to get information about the room you are in or an object.");
        System.out.println("take : object to put the object in your inventory, if you want to take an item from a chest, enter the name of the chest first.");
        System.out.println("use : object to use an object in your inventory, you can use one object on another.");
        System.out.println("inventory : allows you to see the objects in our inventory, you can see a particular object.");
        System.out.println("talk : to someone to get more information.");
        System.out.println("quit : if you want to quit the game.");
        System.out.println("attack : to someone.");
        System.out.println("equip : an item if it is in your inventory.");
        System.out.println("stat : gives the hero statistics.");
        System.out.println();
    }

    public void quit() {
        System.out.println("Do you really want to quit the game ?");
        System.out.println("Answer with yes or no.");
        switch (this.scanner.nextLine()) {
            case "yes":
                this.running = false;
                break;
            case "no":
                System.out.println("You continue to play.");
                break;
            default:
                System.out.println("I didn't understand that.");
        }
    }

    public void init() {
        System.out.println("To start the game, please type \"start\" and press Enter");
        while (!scanner.nextLine().equals("start") && scanner.hasNext()) {
            System.out.println("I didn't understand your command.");
        }
        this.history();
        System.out.println("Type anything and press Enter to continue.");
        scanner.nextLine();
        this.help();
        System.out.println("Type anything and press Enter to continue.");
        scanner.nextLine();
        this.world.setStart(this.hero);
        this.hero.look();
    }


    public void runGame() {
        String input;
        boolean executed_command;
        while (this.running && this.hero.isAlive() && !this.hero.isGoalAchieved()) {
            if (this.hero.getPlace().randomEncoutner()) {
                //attaque le "premier" ennemi dans la hashmap pour déclencher le combat
                input = ("attack " + this.hero.getPlace().getAnEnemyName());
                System.out.println("You're being attacked !");
                this.interpreter.interpret(input);
            } else {
                do {
                    input = this.scanner.nextLine();
                    executed_command = this.interpreter.interpret(input);
                } while (!executed_command);
            }
        }
    }

    public void ending() {
        if (this.hero.isAlive()) {
            if (this.hero.isGoalAchieved()) {
                System.out.println("You have completed the story !");
            }
        } else System.out.println("You died.");
        System.out.println("Thank you for playing Morlynn Castle.");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game g = new Game(input);
        g.init();
        g.runGame();
        g.ending();
    }
}