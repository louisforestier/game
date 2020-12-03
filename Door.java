package game;

public class Door implements Lookable{

	private Place entrance;
	private Place exit;
	private DoorWithLock mirrorDoor;

	public Door() {
		this.entrance = null;
		this.exit = null;
		this.mirrorDoor = null;
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
	
	public void setMirrorDoor(Door mirrorDoor) {
		if(mirrorDoor instanceof DoorWithLock) {
			this.mirrorDoor = (DoorWithLock)mirrorDoor;
		}
	}
	
	public DoorWithLock getMirrorDoor() {
		return this.mirrorDoor;
	}
	
	public Place cross() {
		return this.exit;
	}

	@Override
	public void print() {
		System.out.println("This door goes from the room " + this.getEntrance() + " to room " + this.getExit() + ".");
	}

}