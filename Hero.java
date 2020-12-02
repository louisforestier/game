package game;

public class Hero extends Character {
	
	private static final String NAME = "hero";

	public Hero() {
		super(Hero.NAME);
	}

	public void go(Door door) {
		this.setPlace(door.cross());
	}

	public void look() {
		this.getPlace().print();
	}

	public void take(Item i) {
		this.getInventory().put(i.getName(),i);
	}

	public void use(Usable object) {
		object.use();
	}
	
	public void use(Usable obj1, Receiver obj2) {
		obj1.use();
		obj2.receive(obj1);
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	public void look(Lookable l) {
		l.print();
	}

	public boolean isInInventory(String name) {
		return this.getInventory().containsKey(name);
	}

}