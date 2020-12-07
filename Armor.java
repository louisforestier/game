package game;

public class Armor extends Item implements Equipable {

    private final int armorClass;
    private boolean equiped;

    public Armor(String name, String description, int armorClass) {
        super(name, true, description);
        this.armorClass = armorClass;
        this.equiped = false;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public boolean isEquiped() {
        return equiped;
    }

    public void switchEquiped(){
        this.equiped = !this.equiped;
    }

    @Override
    public void equip(Character character) {
        character.setArmor(this);
        this.equiped = true;

    }
}
