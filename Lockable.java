package game;

public interface Lockable extends Receiver {

	public boolean unlock(Key key);

	public boolean lock(Key key);

}