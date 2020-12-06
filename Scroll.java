package game;

public class Scroll extends Book{

	public Scroll(String name, String description, String content) {
		super(name, description, content);
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
