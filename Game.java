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
        System.out.println("To play this game, you will have to type combination of words in the command line.");
        System.out.println("When you play, the \"..._name\" in the description of the usable commands below must be replace with the name of what you want to interact with.");
        System.out.println("You can use the commands :");
        System.out.println("go \"room_name\" : to move to the room with the name you put, if it exists and if it is adjacent to yours.");
        System.out.println("help : to get this text.");
        System.out.println("help \"command_name\" : to get the syntax of a specific command.");
        System.out.println("look : to get information about the room you are in.");
        System.out.println("look \"thing_name\" : to get information about a specific thing.");
        System.out.println("take \"item_name\" : object to put the object in your inventory, if you want to take an item from a chest, enter the name of the chest first.");
        System.out.println("use \"thing_name\" : to use an object.");
        System.out.println("use \"thing1_name\" \"thing2_name\" : to use an object on something.");
        System.out.println("inventory : allows you to see the objects in our inventory, you can see a particular object.");
        System.out.println("inventory \"item_name\" : allows you look at a specific object in your inventory.");
        System.out.println("talk  \"someone_name\" : to talk to someone to get more information.");
        System.out.println("quit : if you want to quit the game.");
        System.out.println("attack \"someone_name\" : to attack someone. If you are in combat, it will attack an enemy, \n" +
                "else it will start a combat with all enemies in the room.");
        System.out.println("flee : to flee a combat. Be careful, even if you flee, your enemies can attack you.");
        System.out.println("equip \"item_name\": to equip an item in your inventory.");
        System.out.println("stat : gives the hero attributes.");
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
        System.out.println("This game was made by :");
        System.out.println("FRADET Amandine");
        System.out.println("GUILLOT Clémentine");
        System.out.println("FORESTIER Louis");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game g = new Game(input);
        g.init();
        g.runGame();
        g.ending();
    }
}