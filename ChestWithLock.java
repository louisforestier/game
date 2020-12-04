package game;

public class ChestWithLock extends Chest implements Lockable{
	
	private boolean isLocked;
    private Key key;

	public ChestWithLock(String name, boolean takable, String description, Key key) {
		super(name, takable, description);
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(Key key) {
		// TODO Auto-generated method stub
		return false;
	}

}
