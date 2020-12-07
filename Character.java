package game;

import java.util.*;

public abstract class Character extends Interaction implements Attackable, Attacker {

    private final static int MIN_DICE = 1;
    private final static int MAX_DICE = 20;
    private final static int DEFAULT_ARMOR_CLASS = 10;
    private final static int DEFAULT_ATTACK_POWER = 2;


    private final String name;
    private Place place;
    private Map<String, Item> inventory = new HashMap<>();
    private boolean alive = true;
    private int currentHealthPoints;
    private int maxHealthPoints;
    private int attackBonus;
    private int damageBonus;
    private Armor armor = null;
    private Weapon weapon = null;
    private Random dice = new Random();

    public Character(String name, String description, int maxHealthPoints, int attackBonus, int damageBonus) {
        super(description);
        this.name = name;
        this.maxHealthPoints = maxHealthPoints;
        this.currentHealthPoints = maxHealthPoints;
        this.attackBonus = attackBonus;
        this.damageBonus = damageBonus;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getCurrentHealthPoints() {
        return this.currentHealthPoints;
    }

    public void setCurrentHealthPoints(int currentHealthPoints) {
        this.currentHealthPoints = currentHealthPoints;
    }

    public int getMaxHealthPoints() {
        return this.maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public int getAttackBonus() {
        return this.attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public Place getPlace() {
        return this.place;
    }

    public void setPlace(Place p) {
        if (this.place != null)
            this.freePlace();
        this.place = p;
        p.addCharacter(this.name, this);
    }

    public Map<String, Item> getInventory() {
        return inventory;
    }

    public void freePlace() {
        this.place.freeCharacter(this.name);
        this.place = null;
    }

    public boolean isInInventory(String name) {
        return this.getInventory().containsKey(name);
    }

    public void printInventory() {
        System.out.println("You have :");
        if (!(this.inventory.isEmpty()))
            this.inventory.forEach((k, v) -> {
                System.out.println(k);
            });
        else {
            System.out.println("nothing J.S.");
        }
    }

    @Override
    public void isAttacked(int roll, int damage) {
        int armorClass;
        if (this.armor != null){
            armorClass = this.armor.getArmorClass();
        } else armorClass = Character.DEFAULT_ARMOR_CLASS;

        if (roll >= armorClass) {
            this.currentHealthPoints -= damage;
            System.out.println(" hit " + this.name + "." );
            System.out.println(this.name + " takes " + damage + " points of damage.");
            if (this.currentHealthPoints <= 0) {
                this.currentHealthPoints = 0;
                this.alive = false;
                System.out.println(this.name + " is dead.");
            }
        } else System.out.println(" miss " + this.name + ".");
    }

    @Override
    public void attack(Attackable attackable) {
        int attackRoll = this.dice.nextInt(Character.MAX_DICE) + Character.MIN_DICE;
        int damageRoll;
        if (this.weapon != null){
            damageRoll = this.dice.nextInt(this.weapon.getAttackPower()) + Character.MIN_DICE;
        } else damageRoll = this.dice.nextInt(Character.DEFAULT_ATTACK_POWER) + Character.MIN_DICE;
        System.out.print(this.name);
        attackable.isAttacked(attackRoll + this.attackBonus, damageRoll + this.damageBonus );
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void equipArmor(Armor armor) {
        if (this.armor != null){
            this.armor.switchEquiped();
            this.inventory.put(this.armor.getName(), this.armor);
        }
        armor.equip(this);
        this.inventory.remove(armor.getName());
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void equipWeapon(Weapon weapon) {
        if (this.weapon != null){
            this.weapon.switchEquiped();
            this.inventory.put(this.weapon.getName(), this.weapon);
        }
        weapon.equip(this);
        this.inventory.remove(weapon.getName());
    }

    @Override
    public void print() {
        super.print();
        if (!this.alive)
        System.out.println("But now he's dead.");
    }
}