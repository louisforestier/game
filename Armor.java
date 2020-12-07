package game;

public class Armor extends Item implements Equipable {

    private final int armorClass;

    public Armor(String name, String description, int armorClass) {
        super(name, true, description);
        this.armorClass = armorClass;
    }

    public int getArmorClass() {
        return armorClass;
    }



    @Override
    public void equip(Character character) {
        character.equipArmor(this);

    }
}
