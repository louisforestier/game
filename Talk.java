package game;

import java.util.List;
import java.util.Scanner;

public class Talk extends Command{

    private static final int NB_ARG = 1;
    
    private static Hero hero;
    private static Scanner scanner;

    public Talk(Hero hero, Scanner input) {
        super();
        Talk.hero = hero;
        Talk.scanner = input;
    }

    public Talkable stringToTalkableInPlace(String name) throws ClassCastException {
        return (Talkable) hero.getPlace().getInteractions().get(name);
    }

    @Override
    public void launchCommand(List<String> argument) throws  ClassCastException, NullPointerException, InvalidArgumentNumberException{
        if (argument.size() == Talk.NB_ARG){
            if (!(argument.get(0).equals(hero.getName()))) {
                hero.talk(stringToTalkableInPlace(argument.get(0)), scanner);
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
