package game;

import java.util.List;

public class Inventory extends Command{

	private static final int NB_ARG_MAX = 1;
	private static final int NB_ARG_MIN = 0;
	
	private static Hero hero;


	public Inventory(Hero hero) {
		super();
		Inventory.hero = hero;
	}

	@Override
	public void launchCommand(List<String> argument) throws InvalidArgumentNumberException, NullPointerException{
		if (argument.size() == Inventory.NB_ARG_MIN ){
			hero.printInventory();
		} else if (argument.size() == Inventory.NB_ARG_MAX){
			hero.getInventory().get(argument.get(0)).print();
		} else throw new InvalidArgumentNumberException();
		
	}

	@Override
	public void help() {
		System.out.println("inventory");
		System.out.println("inventory name_of_object");
	}

}
