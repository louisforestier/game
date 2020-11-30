package game;

public class DoorWithLock extends Door implements Lockable, Receiver {

	private boolean isLocked;
	private Key isKey;

	public DoorWithLock(Key key) {
		super();
		this.isKey = key;
		this.isLocked = true;
	}

	@Override
	public boolean unlock(Key key) {
		if(this.isKey == key) {
			this.isLocked = false;
		}
		return this.isLocked;
	}

	@Override
	public boolean lock(Key key) {
		if(this.isKey == key) {
			this.isLocked = true;
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
	public void receive(Item i) {
		if(i instanceof Key) {
			if(this.isLocked) {
				this.unlock((Key) i);
			}
			else {
				this.lock((Key) i);
			}
		}
		else {
			System.out.println("This item is not a key.");
		}
	}
}