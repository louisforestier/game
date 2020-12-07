package game;

import java.util.List;
import java.util.Map;

public class Attack extends Command {

    private static final int NB_ARG = 1;

    private Hero hero;
    private Game game;

    public Attack(Hero hero, Game game) {
        this.hero = hero;
        this.game = game;
    }

    public Attackable stringToAttackableInPlace(String name) throws ClassCastException {
        return (Attackable) hero.getPlace().getInteractions().get(name);
    }

    @Override
    public void launchCommand(List<String> argument) throws InvalidArgumentNumberException, ClassCastException, NullPointerException{
        if (argument.size() == Attack.NB_ARG){
            if (!(argument.get(0).equals(hero.getName()))) {
                Attackable a = stringToAttackableInPlace(argument.get(0));
                if (a instanceof NonPlayerCharacter ){
                    NonPlayerCharacter npc = (NonPlayerCharacter)a;
                    if (npc.isAlive()) {
                        if (this.hero.getOngoingCombat() == null) {
                            if (!npc.isHostile()){
                                npc.setHostile(true);
                                System.out.println("Hey ! What have I done to deserve this ?!");
                            }
                            ((NonPlayerCharacter) a).setHostile(true);
                            Combat c = new Combat(this.hero, this.hero.getPlace().getEnemiesInPlace(), this.game);
                            this.hero.setOngoingCombat(c);
                            this.hero.getOngoingCombat().runCombat(this.hero, this.game.getScanner());

                        } else this.hero.attack(this.hero.getOngoingCombat().getEnemies().get(argument.get(0)));
                    } else {
                        System.out.println("You're attacking a dead body...");
                        System.out.println("God, what is wrong with you ?");
                        System.out.println("Are you trying to get on my nerves ?! Because you're successfull !");
                    }
                } else hero.attack(a);
            } else {
                System.out.println("You're want to hurt yourself ?");
                System.out.println("I mean, I'm not judging or anything but that's pretty messed up.");
            }

        } else throw new InvalidArgumentNumberException();
    }

    @Override
    public void help() {
        System.out.println("attack enemy_name");
    }
}
