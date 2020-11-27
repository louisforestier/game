package game;

import java.io.IOException;
import java.util.*;

public class Game {

	private boolean isRunning = true;
	private Hero hero;
	private World map;

	public Game() {
		this.hero = new Hero();
		this.map = new World();
	}

	public void help() {
		System.out.println("You can use the commands :");
		System.out.println("go with a direction to move through a door to the next room in this direction, if it exists.");
		System.out.println("help (which you are using right now) to get the details of the commands.");
		System.out.println("look to get information about the room you are in.");
		System.out.println("take object to put the object in your inventory.");
		System.out.println("use object to use an object in your inventory.");
	}

	public void quit(Scanner sc) {
		System.out.println("Do you really want to quit the game ?");
		System.out.println("Answer with yes or no.");
		switch (sc.next()){
			case "yes" :
				this.isRunning = false;
				break;
			case "no" :
				break;
			default:
				System.out.println("I didn't understand that.");
		}
	}


	public void startQuest() throws IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("To start the game, please type \"start\" and press Enter");
			while(!scanner.nextLine().equals("start") && scanner.hasNext()){
				System.out.println("Je n'ai pas compris votre commande.");
			}
			this.help();
			Hero player = this.hero;
			World world = this.map;
			player.setPlace(world.getPlaces().get("start"));
			while(this.isRunning){
				Place location = player.getPlace();
				System.out.print("What's next ?");
				switch (scanner.next()){
					case "go" :
						player.go(Direction.valueOf(scanner.next()));
						break;
					case "help":
						this.help();
						break;
					case "look":
						player.look();
						break;
					case "take" :
						String itemToTakeName = scanner.next();
						if (location.getItems().containsKey(itemToTakeName)){
							Item itemToTake = location.getItems().get(itemToTakeName);
							player.take(itemToTake);
						}
						else{
							System.out.println("I didn't understand that.");
						}
						break;
					case "quit" : this.quit(scanner);
						break;
					case "use":
						String itemToUseName = scanner.next();
						if(player.getInventory().containsKey(itemToUseName)) {
							Item i2 = player.getInventory().get(itemToUseName);
							player.use(i2);
						}
						else{
							System.out.println("I didn't understand that.");
						}
						break;
					default :
						System.out.println("I didn't understand that.");
				}
			}
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Game g = new Game();
		g.startQuest();
	}
}