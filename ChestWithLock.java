package game;

public class ChestWithLock extends Container implements Lockable{
	
	private boolean isLocked;
    private Key key;

	public ChestWithLock(String name, String description, Key key) {
		super(name, description);
		this.key = key;
        this.isLocked = true;
	}

	@Override
    public void receive(Usable u) throws ClassCastException{
    	if(u instanceof Key) {
    		this.receiveForKey((Key) u);
    	} else {
    		this.receiveForBook((Book) u);	
    	} 
    }

	public void receiveForBook(Book b) {
    	this.printKeyForThisChest();
	}
    
	public void receiveForKey(Key k) {
    	if (this.isLocked) {
    		this.unlock(k);
    	} else {
    		this.lock(k);
    	}
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
				this.getContent().forEach((k, v) -> {System.out.println(k);});
			} else {
				System.out.println("really nothing.");
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
	
	public void printKeyForThisChest() {
        System.out.println("This chest can be unlocked with a " + this.key.getName() + ".");
    }
	
}
