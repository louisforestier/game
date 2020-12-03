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
    public void use()
    {
        System.out.println("You can't use this alone.");
    }
        
    @Override
    public void use(Receiver obj) {
        if(obj instanceof Lockable){
            if (obj instanceof DoorWithLock) {
               obj.receive(this);
            }
            else
            {
                System.out.println("Sorry, but, for now, you can only use key with a door locked.");
            }
        }
        else 
        {
            System.out.println("You can't use this with this object.");
	}
        
    }            

	@Override
	public void print() {
            System.out.println("This " + this.getName() + "is usable.");		
	}

}