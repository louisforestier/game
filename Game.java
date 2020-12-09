package game;

import java.util.*;

public class Game {

    private boolean running = true;
    private Hero hero;
    private World world;
    private Scanner scanner;
    private Interpreter interpreter;

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
        System.out.println("Hello traveler and welcome to Morlynn Castle.");
        System.out.println("Your quest : find keys to get out and, maybe, got your hands on a great treasure.");
        System.out.println("Not a big deal but beware!");
        System.out.println("The guards will prevent you.");
        System.out.println("Good luck");
        System.out.println("in Morlynn Castle");
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