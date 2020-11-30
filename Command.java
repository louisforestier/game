package game;

import java.util.List;

public abstract class Command {
	private World world; 
	private Hero hero;
	
	public Command(World world, Hero hero) {
		this.world = world;
		this.hero = hero;
	}
	
	public World getWorld(){
		return this.world;
	}
	
	public Hero getHero() {
		return this.hero;
	}
	
	public abstract boolean argOk(List<String> argument);
	
	public abstract void launchCommand(List<String> argument);

}
