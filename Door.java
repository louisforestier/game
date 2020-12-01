package game;

public class Door implements Lookable{

	private Place entrance;
	private Place exit;

	public Door() {
		this.entrance = null;
		this.exit = null;
	}

	public void setEntrance(Place entrance) {
		this.entrance = entrance;
	}
	
	public void setExit(Place exit) {
		this.exit = exit;
	}
	
	public Place getEntrance() {
		return this.entrance;
	}

	public Place getExit() {
		return this.exit;
	}
	
	public Place cross() {
		return this.exit;
	}

	@Override
	public void print() {
		System.out.println("This door goes from the room " + this.getEntrance() + " to room " + this.getExit() + ".");
	}

}