package game;

import java.util.*;

public class Game {

    private boolean isRunning = true;
    private Hero hero;
    private World world;
    private Scanner scanner;
    private Interpreter interpreter;
    private Random dice = new Random();

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
        System.out.println("");
        System.out.println("Hello traveler and welcome to Morlynn Castle.");
        System.out.println("Your quest : find keys to get out and, maybe, got your hands on a great treasure.");
        System.out.println("Not a big deal but beware!");
        System.out.println("Monsters you've never seen are pacing up and down corridors.");
        System.out.println("Good luck");
        System.out.println("in Morlynn Castle");
        System.out.println("...");
    }

    public void help() {
        System.out.println("You can use the commands :");
        System.out.println("go with a direction to move through a door to the next room in this direction, if it exists.");
        System.out.println("help (which you are using right now) to get the details of the commands.");
        System.out.println("look to get information about the room you are in.");
        System.out.println("take object to put the object in your inventory, if you want to take an item from a chest, enter the name of the chest first.");
        System.out.println("use object to use an object in your inventory, you can use one object on another.");
        System.out.println("inventory allows you to see the objects in our inventory.");
        System.out.println("talk to someone to get more information.");
        System.out.println("quit if you want to quit the game.");
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
        this.history();
        this.help();
        this.world.setStart(this.hero);
        this.hero.look();
    }

    public void runGame() {
        while (this.isRunning && this.hero.isAlive() && !this.hero.isGoalAchieved()) {
            String input = this.scanner.nextLine();
            if (this.hero.getPlace().getEnemiesInPlace().size() != 0){
                int randomEnemyDetection = this.dice.nextInt(100) + 1;
                if (randomEnemyDetection < this.hero.getPlace().getENEMY_DETECTION_THRESHOLD()){
                    //attaque le "premier" ennemi dans la hashmap pour déclencher le combat
                    this.interpreter.interpret("attack " + this.hero.getPlace().getEnemiesInPlace().keySet().stream().findFirst().get());
                } else this.interpreter.interpret(input);
            } else this.interpreter.interpret(input);
        }
    }

    public void ending() {
        if (this.hero.isAlive()){
            if (this.hero.isGoalAchieved()){
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