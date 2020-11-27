package game;

public interface Lockable {

	boolean unlock(key key);

	boolean lock(Key key);

}