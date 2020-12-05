package game;

import java.util.*;

public class Game {

    private boolean isRunning = true;
    private Hero hero;
    private World world;
    private Scanner scanner;
    private Interpreter interpreter;

    public Game() {
        this.hero = new Hero();
        this.world = new World();
        this.scanner = new Scanner(System.in);
        this.interpreter = new Interpreter(this.hero, this);
    }


    public void help() {
        System.out.println("You can use the commands :");
        System.out.println("go with a direction to move through a door to the next room in this direction, if it exists.");
        System.out.println("help (which you are using right now) to get the details of the commands.");
        System.out.println("look to get information about the room you are in.");
        System.out.println("take object to put the object in your inventory, if you want to take an item from a chest, enter the name of the chest first.");
        System.out.println("use object to use an object in your inventory, you can use one object on another.");
        System.out.println("inventory allows you to see the objects in our inventory.");
        System.out.println("");
    }

    public void quit() {
        System.out.println("Do you really want to quit the game ?");
        System.out.println("Answer with yes or no.");
        switch (this.scanner.nextLine()) {
            case "yes":
                this.isRunning = false;
                break;
            case "no":
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
        this.help();
        this.world.setStart(this.hero);
        this.hero.look();
    }

    public void runGame() {
        while (this.isRunning) {
            String input = this.scanner.nextLine();
            this.interpreter.interpret(input);
        }
    }

    public void ending() {
        System.out.println("End of game.");
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.init();
        g.runGame();
        g.ending();
    }
}