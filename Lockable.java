package game;

public interface Lockable {

	boolean unlock(Key key);

	boolean lock(Key key);

}