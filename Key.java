package game;

public class Key extends Item implements Usable {
    
    public Key(String name, String description) {
        super(name, true, description);
    }

    @Override
    public void use() {
        System.out.println("You can't use this alone.");
    }

    @Override
    public void use(Receiver obj) throws ClassCastException {
        if (obj instanceof Lockable) {
            obj.receive(this);
        } else {
            System.out.println("You can't use this with this object.");
        }

    }
}