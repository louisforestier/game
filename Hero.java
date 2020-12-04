package game;

public class Hero extends Character {

    private static final String NAME = "hero";
    private static final String DESCRIPTION = "You never watched a mirror before ?";

    public Hero() {
        super(Hero.NAME, Hero.DESCRIPTION);
    }

    public void go(Door door) {
        this.setPlace(door.cross());
        this.look();
    }

    public void look() {
        this.getPlace().print();
    }

    public void take(Item i) {
        this.getInventory().put(i.getName(), i);
        this.getPlace().takeOut(i);
    }

    public void use(Usable object) {
        object.use();
    }

    public void use(Usable obj1, Receiver obj2) throws ClassCastException {
        obj1.use(obj2);
    }

    public void look(Interaction l) {
        l.print();
    }

}