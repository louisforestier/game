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
		else {
			System.out.println("Wrong key.");
		}
		return this.isLocked;
	}

	@Override
	public boolean lock(Key key) {
		if(this.isKey == key) {
			this.isLocked = true;
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
	public void receive(Usable u) {
		if(u instanceof Key) {
			if(this.isLocked) {
				this.unlock((Key) u);
			}
			else {
				this.lock((Key) u);
			}
		}
		else {
			System.out.println("This item is not a key.");
		}
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("This door is a lockable door.");
	}
}