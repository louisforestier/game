package game;

public class Door {

	private Place entrance;
	private Place exit;
	private static int currentId = 0;
	private int id;

	public Door(Place piece1, Place piece2) {
		this.entrance = piece1;
		this.exit = piece2;
		Door.currentId += 1;
		this.id = Door.currentId;
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

}