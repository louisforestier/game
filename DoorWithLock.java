package game;

public class DoorWithLock extends Door implements Lockable, Receiver {

	private boolean isLocked;
	private Key isKey;

	public DoorWithLock(Place p1, Place p2, Key key) {
		super(p1,p2);
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
			System.out.println("the door is locked, please use a key");
			return this.getEntrance();
		}
		else {
			return this.getExit();
		}
	}
	
	@Override
	public void receive(Item i) {
		
		if(this.isLocked) {
			this.unlock()
		}
	}
}