package game;

public class Weapon extends Item implements Equipable{

    private final int attackPower;
    private boolean equiped;

    public Weapon(String name, String description, int attackPower) {
        super(name, true, description);
        this.attackPower = attackPower;
        this.equiped = false;
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public boolean isEquiped() {
        return this.equiped;
    }

    public void switchEquiped(){
        this.equiped = !this.equiped;
    }

    @Override
    public void equip(Character character) {
        character.setWeapon(this);
        this.equiped = true;

    }
}
