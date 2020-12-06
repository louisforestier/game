package game;

public class Book extends Item implements Usable {

	public Book(String name, String description) {
		super(name, true, description);
	}

	@Override
	public void use() {
		System.out.println("You read that this book should be used on a door or a chest.");	
	}

	@Override
	public void use(Receiver obj) {
		if (obj instanceof Lockable) {
            obj.receive(this);
        } else {
            System.out.println("You can't use this with this object.");
        }
	}
	
}
