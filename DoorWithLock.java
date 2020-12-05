package game;

public class DoorWithLock extends Door implements Lockable {

    private boolean isLocked;
    private Key key;

    public DoorWithLock(Key key, String description) {
        super(description);
        this.key = key;
        this.isLocked = true;
    }

    /*
    public Key printKeyForThisDoor() {
        System.out.println("This door can be unlocked with a" + this.key.getName() + ".");
        return this.key;
    }
     */

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
        } else {
            System.out.println("Wrong key.");
        }
        return this.isLocked;
    }

    @Override
    public Place cross() {
        if (this.isLocked) {
            System.out.println("The door is locked, please use a key.");
            return this.getEntrance();
        } else {
            return this.getExit();
        }
    }

    @Override
    public boolean receive(Usable u) throws ClassCastException{
    	boolean result;
    	if (this.isLocked) {
    		result = this.unlock((Key) u);
    	} else {
    		result = this.lock((Key) u);
    	}
    	return result;
    }

}