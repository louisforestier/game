package game;

import java.util.Scanner;

public class Hero extends Character {

    private static final String NAME = "hero";
    private static final String DESCRIPTION = "You never watched a mirror before ?";
    private static final int STARTING_HP = 30;
    private static final int STARTING_ATT_BONUS = 5;
    private static final int STARTING_DMG_BONUS = 3;
    private boolean goalAchieved = false;
    private Combat ongoingCombat = null;

    public Hero() {
        super(Hero.NAME, Hero.DESCRIPTION, Hero.STARTING_HP, Hero.STARTING_ATT_BONUS, Hero.STARTING_DMG_BONUS);
    }

    public boolean isGoalAchieved() {
        return this.goalAchieved;
    }

    public Combat getOngoingCombat() {
        return ongoingCombat;
    }

    public void setOngoingCombat(Combat ongoingCombat) {
        this.ongoingCombat = ongoingCombat;
    }

    public void go(Door door) throws NullPointerException {
        this.setPlace(door.cross());
        this.look();
        this.goalAchieved = this.getPlace().getName().equals("exit");
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

    public void takeFromContainer(Container c, Item i) throws NullPointerException {
        this.getInventory().put(i.getName(), i);
        c.removeItem(i.getName());
    }

    public void use(Usable object) throws NullPointerException {
        object.use();
    }

    public void use(Usable obj1, Receiver obj2) throws ClassCastException, NullPointerException {
        obj1.use(obj2);
    }

    public void talk(Talkable t, Scanner input) {
        t.talk(input);
    }

    public void equip(Equipable equipable) throws NullPointerException {
        equipable.equip(this);
    }

}