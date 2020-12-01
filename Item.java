package game;

public abstract class Item implements Lookable{
    
	private String name;
    private boolean isTakable;

	/**
	 * 
	 * @param name
	 */
	public Item(String name) {
            this.name = name;
            this.isTakable = false;
	}
        
        public Item(String name, boolean takable)
        {
            this.name = name;
            this.isTakable = takable;
        }

	public String getName() {
    	return this.name;
	}
        
        public boolean isTakable(){
            return this.isTakable;
        }
        
        @Override
        public void print() {
            System.out.println("It is a " + this.getName()); 
        }
        
}