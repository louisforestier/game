package game;

import java.util.List;

public class Equip extends Command {

    private static final int NB_ARG = 1;

    private Hero hero;

    public Equip(Hero hero) {
        this.hero = hero;
    }

    public Equipable stringtoEquipable(String name) throws ClassCastException {
        return (Equipable) this.hero.getInventory().get(name);
    }

    @Override
    public void launchCommand(List<String> argument) throws InvalidArgumentNumberException, NullPointerException {
        if (argument.size() == Equip.NB_ARG)
            stringtoEquipable(argument.get(0)).equip(hero);
        else throw new InvalidArgumentNumberException();
    }

    @Override
    public void help() {
        System.out.println("equip armor_name");
        System.out.println("or equip weapon_name");
    }
}
