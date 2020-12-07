package game;

public class DoorWithLock extends Door implements Lockable {

    private boolean isLocked;
    private Key key;
    private DoorWithLock mirrorDoor;

    public DoorWithLock(Key key, String description) {
        super(description);
        this.key = key;
        this.isLocked = true;
        this.mirrorDoor = null;
    }

    public void setMirrorDoor(Door mirrorDoor) {
        if (mirrorDoor instanceof DoorWithLock) {
            this.mirrorDoor = (DoorWithLock) mirrorDoor;
        }
    }
    
    public void printKeyForThisDoor() {
        System.out.println("This door can be unlocked with a" + this.key.getName() + ".");
    }

    public boolean getIsLocked() {
        return this.isLocked;
    }

    public boolean changeMirrorDoor() {
    	if(this.mirrorDoor != null) {
    		if (this.mirrorDoor.getIsLocked() != this.isLocked) {
    			this.mirrorDoor.switchLockedForMirrorDoor();
    		}
    		return this.mirrorDoor.getIsLocked();
    	} else return false;
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
    public void receive(Usable u) throws ClassCastException{
    	if(u instanceof Key) {
    		this.receiveForKey((Key) u);
    	} else {
    		this.receiveForScroll((Scroll) u);
    	}
    }

	public void receiveForScroll(Scroll b) {
    	this.printKeyForThisDoor();
	}
    
	public void receiveForKey(Key k) {
    	if (this.isLocked) {
    		this.unlock(k);
    	} else {
    		this.lock(k);
    	}
	}

}