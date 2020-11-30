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
	public void use(Item i) {
		// TODO - implement game.Hero.use
		//throw new UnsupportedOperationException();
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

}