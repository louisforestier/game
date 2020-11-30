package game;

public class Hero extends Character {

	public Hero() {
		super("hero");
	}

	/**
	 * 
	 * @param door
	 */
	public void go(Door door) {
		this.setPlace(door.cross());
	}

	public void look() {
		this.getPlace().print();
	}

	/**
	 * 
	 * @param i
	 */
	public void take(Item i) {
		this.getInventory().put(i.getName(),i);
	}



	/**
	 * 
	 * @param i
	 */
	public void use(Usable object) {
		// TODO - implement game.Hero.use
		//throw new UnsupportedOperationException();
	}
	
	public void use(Usable obj1, Receiver obj2) {
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	public void look(Lookable l) {
		l.print();
	}
}