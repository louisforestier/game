package game;

public abstract class Item implements Lookable{

	private static int currentId = 0;
	private int id;
	private String name;
        private boolean isTakable;

	/**
	 * 
	 * @param name
	 */
	public Item(String name) {
            this.name = name;
            
	}

	public int getId() {
            return this.id;
	}

	public String getName() {
            return this.name;
	}
        
        public boolean isTakable(){
            return this.isTakable;
        }
        
}