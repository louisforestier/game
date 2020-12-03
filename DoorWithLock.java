package game;

public class DoorWithLock extends Door implements Lockable{

	private boolean isLocked;
	private Key isKey;
	
	public DoorWithLock(Key key) {
		super();
		this.isKey = key;
		this.isLocked = true;
	}
	
	public Key printKeyForThisDoor() {
		System.out.println("This door is open with " + this.isKey.getName() + ".");
		return this.isKey;
	}
	
	
	public boolean getIsLocked() {
		return this.isLocked;
	}
	
	public boolean changeMirrorDoor() {
		if(this.getMirrorDoor().getIsLocked() != this.isLocked) {
			this.getMirrorDoor().switchLockedForMirrorDoor();
		}
		return this.getMirrorDoor().getIsLocked();
	}
	
	public boolean switchLockedForMirrorDoor() {
		if(this.isLocked) {
			this.isLocked = false;
		}
		else {
			this.isLocked = true;
		}
		return this.isLocked;
	}

	@Override
	public boolean unlock(Key key) {
		if(this.isKey == key) {
			this.isLocked = false;
			this.changeMirrorDoor();
		}
		else {
			System.out.println("Wrong key.");
		}
		return this.isLocked;
	}

	@Override
	public boolean lock(Key key) {
		if(this.isKey == key) {
			this.isLocked = true;
			this.changeMirrorDoor();
		}
		else {
			System.out.println("Wrong key.");
		}
		return this.isLocked;
	}

	@Override
	public Place cross() {
		if(this.isLocked) {
			System.out.println("The door is locked, please use a key.");
			return this.getEntrance();
		}
		else {
			return this.getExit();
		}
	}
	
	@Override
	public boolean receive(Usable u) {
		boolean result;
		if(u instanceof Key) {
			if(this.isLocked) {
				result = this.unlock((Key) u);
			}
			else {
				result = this.lock((Key) u);
			}
		}
		else {
			System.out.println("This item is not a key.");
			result = false;
		}
		return result;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("This door is a lockable door.");
		this.printKeyForThisDoor();
	}
}