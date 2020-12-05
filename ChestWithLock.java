package game;

public class ChestWithLock extends Chest implements Lockable{
	
	private boolean isLocked;
    private Key key;

	public ChestWithLock(String name, String description, Key key) {
		super(name, description);
		this.key = key;
        this.isLocked = true;
	}

	@Override
	public boolean receive(Usable u)  throws ClassCastException {
		boolean result;
		if (this.isLocked) {
			result = this.unlock((Key) u);
		} else {
			result = this.lock((Key) u);
		}
		return result;
	}

	@Override
	public boolean unlock(Key key) {
		if (this.key == key) {	
			this.isLocked = false;
		} else {
			System.out.println("Wrong key.");
		}
		return this.isLocked;
	}

	@Override
	public boolean lock(Key key) {
		if (this.key == key) {	
			this.isLocked = true;
		} else {
			System.out.println("Wrong key.");
		}
		return this.isLocked;
	}

	@Override
	public void printContent() {
		if(!this.isLocked) {
			System.out.println("There are :");
			if (!(this.getContent().isEmpty())) {
				this.getContent().forEach((k, v) -> {v.print();});
			} else {
				System.out.println("nothing J.S.");
			}
		} else {
			System.out.println("This chest is locked, please unlock it to look this content.");
		}
	}
	
	@Override
	public void supprObj(String name) {
		if(!this.isLocked) {
			this.getContent().remove(name);
		} else {
			System.out.println("This chest is locked, please unlock it to remove an object.");
		}
	}
	
	@Override
	public void addObj(String name, Item object) {
		if(!this.isLocked) {
			this.getContent().put(name, object);
		} else {
			System.out.println("This chest is locked, please unlock it to add object.");
		}
	}
	
}
