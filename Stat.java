package game;

import java.util.List;

public class Stat extends Command {

    private static final int NB_ARG = 0;

    private final Hero hero;

    public Stat(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void launchCommand(List<String> argument) throws InvalidArgumentNumberException {
        if (argument.size() == Stat.NB_ARG) {
            System.out.println("Your attributes : ");
            System.out.println("HP : " + hero.getCurrentHealthPoints() + "/" + this.hero.getMaxHealthPoints());
            System.out.println("Armor class : " + this.hero.getArmorClass());
            System.out.println("Attack power : " + this.hero.getAttackPower());
        } else throw new InvalidArgumentNumberException();
    }

    @Override
    public void help() {
        System.out.println("stat");
    }
}
