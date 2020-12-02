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
	public void use() {
            System.out.println("You're using the " + this.getName() +".");
	}

	@Override
	public void print() {
            System.out.println("This " + this.getName() + "is usable.");		
	}

}