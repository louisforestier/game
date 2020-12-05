package game;

import java.util.List;

public class Inventory extends Command{

	private static final int NB_ARG_MAX = 1;
	private static final int NB_ARG_MIN = 0;


	public Inventory(World world, Hero hero, Game game) {
		super(world, hero, game);
	}

	@Override
	public void launchCommand(List<String> argument) throws InvalidArgumentNumberException, NullPointerException{
		if (argument.size() == Inventory.NB_ARG_MIN ){
			this.getHero().printInventory();
		} else if (argument.size() == Inventory.NB_ARG_MAX){
			this.getHero().getInventory().get(argument.get(0)).print();
		} else throw new InvalidArgumentNumberException();
		
	}

	@Override
	public void help() {
		// TODO Auto-generated method stub
		
	}

}
