package game;

import java.util.List;

public class Talk extends Command{

    private static final int NB_ARG = 1;

    public Talk(Hero hero, Game game) {
        super(hero, game);
    }

    public Talkable stringToTalkableInPlace(String name) throws ClassCastException {
        return (Talkable) this.getHero().getPlace().getInteractions().get(name);
    }

    @Override
    public void launchCommand(List<String> argument) throws  ClassCastException, NullPointerException, InvalidArgumentNumberException{
        if (argument.size() == Talk.NB_ARG){
            if (!(argument.get(0).equals(this.getHero().getName()))) {
                this.getHero().talk(stringToTalkableInPlace(argument.get(0)), this.getGame().getScanner());
            } else {
                System.out.println("You're talking to yourself...");
                System.out.println("Are you alright ? You keep repeating \"My precious\".");
            }
        } else throw new InvalidArgumentNumberException();
    }

    @Override
    public void help() {
        System.out.println("talk character_name");
    }
}
