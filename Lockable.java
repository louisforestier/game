package game;

public interface Lockable extends Receiver {

	boolean unlock(Key key);

	boolean lock(Key key);

}