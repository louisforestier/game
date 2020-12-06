package game;

public class DoorWithLock extends Door implements Lockable {

    private boolean isLocked;
    private Key key;

    public DoorWithLock(Key key, String description) {
        super(description);
        this.key = key;
        this.isLocked = true;
    }

    
    public void printKeyForThisDoor() {
        System.out.println("This door can be unlocked with a" + this.key.getName() + ".");
    }

    public boolean getIsLocked() {
        return this.isLocked;
    }

    public boolean changeMirrorDoor() {
        if (this.getMirrorDoor().getIsLocked() != this.isLocked) {
            this.getMirrorDoor().switchLockedForMirrorDoor();
        }
        return this.getMirrorDoor().getIsLocked();
    }

    public boolean switchLockedForMirrorDoor() {
        if (this.isLocked) {
            this.isLocked = false;
        } else {
            this.isLocked = true;
        }
        return this.isLocked;
    }

    @Override
    public boolean unlock(Key key) {
        if (this.key == key) {
            this.isLocked = false;
            this.changeMirrorDoor();
            System.out.println("You unlock the door using the " + key.getName() + ".");
        } else {
            System.out.println("Wrong key.");
        }
        return this.isLocked;
    }

    @Override
    public boolean lock(Key key) {
        if (this.key == key) {
            this.isLocked = true;
            this.changeMirrorDoor();
            System.out.println("You lock the door using the " + key.getName() + ".");
        } else {
            System.out.println("Wrong key.");
        }
        return this.isLocked;
    }

    @Override
    public Place cross() {
        if (this.isLocked) {
            System.out.println("This door is locked, maybe you could use something to unlock it.");
            return this.getEntrance();
        } else {
            return this.getExit();
        }
    }

    @Override
    public boolean receive(Usable u) throws ClassCastException{
    	if(u instanceof Key) {
    		return this.receiveForKey((Key) u);
    	} else if (u instanceof Book){
    		this.receiveForBook((Book) u);
    		return true;
    	} else return false;
    }

	public void receiveForBook(Book b) {
    	this.printKeyForThisDoor();
	}
    
	public boolean receiveForKey(Key k) {
		boolean result;
    	if (this.isLocked) {
    		result = this.unlock(k);
    	} else {
    		result = this.lock(k);
    	}
    	return result;
	}

}