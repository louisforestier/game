package game;

import java.util.List;

public abstract class Command {
	private final World world;
	private final Hero hero;
	private final Game game;
	
	public Command(World world, Hero hero, Game game) {
		this.world = world;
		this.hero = hero;
		this.game = game;
	}
	
	public World getWorld(){
		return this.world;
	}
	
	public Hero getHero() {
		return this.hero;
	}

	public Game getGame() {
		return game;
	}

	public abstract void launchCommand(List<String> argument);

	public abstract void help();
}
