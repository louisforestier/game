package game;

public class Hero extends Character {

	public Hero() {
		super("hero");
	}

	/**
	 * 
	 * @param d
	 */
	public void go(Direction d) {
		Door door =getPlace().getDoors().get(d.getValue());
		if (door != null){
			if(door.getIsOpen()){
				if(this.getPlace() == door.getEntree())
					this.setPlace(door.getSortie());
				else this.setPlace(door.getEntree());
			}
			else System.out.println("Cette porte est fermée.");
		}
		else System.out.println("Il n'y aucune issue de ce côté.");
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

}