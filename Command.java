package game;

import java.util.List;

public abstract class Command {
	private final Hero hero;
	private final Game game;
	
	public Command(Hero hero, Game game) {
		this.hero = hero;
		this.game = game;
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
