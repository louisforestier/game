package game;

public class Hero extends Character {

    private static final String NAME = "hero";
    private static final String DESCRIPTION = "You never watched a mirror before ?";

    public Hero() {
        super(Hero.NAME, Hero.DESCRIPTION);
    }

    public void go(Door door) throws NullPointerException{
        this.setPlace(door.cross());
        this.look();
    }

    public void look() {
        this.getPlace().print();
    }

    public void look(Interaction l) throws NullPointerException {
        l.print();
    }

    public void take(Item i) throws NullPointerException {
        this.getInventory().put(i.getName(), i);
        this.getPlace().takeOut(i);
    }
    
    public void takeFromChest(Chest c, Item i) throws NullPointerException {
    	this.getInventory().put(i.getName(), i);
    	c.supprObj(i.getName());
    }

    public void use(Usable object) throws NullPointerException {
        object.use();
    }

    public void use(Usable obj1, Receiver obj2) throws ClassCastException, NullPointerException {
        obj1.use(obj2);
    }


}