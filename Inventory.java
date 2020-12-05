package game;

import java.util.List;

public class Inventory extends Command{

	private static final int NB_ARG = 0;

	public Inventory(World world, Hero hero, Game game) {
		super(world, hero, game);
	}

	@Override
	public void launchCommand(List<String> argument) {
		this.getHero().printInventory();
	}

}
