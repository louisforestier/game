package game;

public class Door implements Lookable{

	private Place entrance;
	private Place exit;
	private static int currentId = 0;
	private int id;

	public Door() {
		this.entrance = null;
		this.exit = null;
		Door.currentId += 1;
		this.id = Door.currentId;
	}

	public void setEntrance(Place entrance) {
		this.entrance = entrance;
	}
	
	public void setExit(Place exit) {
		this.exit = exit;
	}
	
	public int getId() {
		return this.id;
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
		// TODO Auto-generated method stub
		
	}

}