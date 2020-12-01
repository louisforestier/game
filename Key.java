package game;

/**
 *
 * @author name
 */
public class Key extends Item implements Usable{
	/**
	 * @param name
	 */ 
	public Key(String name) {
		super(name, true);
	}
        
        @Override
	public void use(DoorWithlock door) {
            door.unlock(this);
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

}