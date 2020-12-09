package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TalkTest {

    private Talk talk;
    private Hero hero;
    private Place p1;
    private Commoner commoner;
    private Guard guard;


    @BeforeEach
    void setUp() {
        Scanner scanner = new Scanner("1");
        hero = new Hero();
        p1 = new Place("p1", "test_p1", null, 0);
        hero.setPlace(p1);
        Dialog dialog = new Dialog(new ArrayList<>(), new ArrayList<>());
        commoner = new Commoner("commoner", "test_commoner", dialog);
        guard = new Guard("guard", "test_guard");
        p1.getInteractions().put(commoner.getName(), commoner);
        p1.getInteractions().put(guard.getName(), guard);
        talk = new Talk(hero, scanner);
    }

    @Test
        //test boite noire
    void stringToTalkableInPlace1() {
        assertSame(commoner, p1.getInteractions().get(commoner.getName()));
    }

    @Test
        //test boite blanche ou noire ?
    void stringToTalkableInPlace2() {
        assertSame(null, p1.getInteractions().get("arg"));
    }

    @Test
        //test boite blanche
    void stringToTalkableInPlace3() {
        assertThrows(ClassCastException.class, () -> talk.stringToTalkableInPlace(guard.getName()));
    }

    @Test
        //test boite blanche
    void stringToTalkableInPlace4() {
        assertDoesNotThrow(() -> talk.stringToTalkableInPlace("arg"));
    }

    @Test
        //test boite blanche
    void launchCommand1() {
        List<String> arguments = new LinkedList<>();
        assertThrows(InvalidArgumentNumberException.class, () -> talk.launchCommand(arguments));
    }

    @Test
    //test boite blanche
    public void launchCommand2() {
        List<String> arguments = new LinkedList<>();
        arguments.add("arg1");
        arguments.add("arg2");
        assertThrows(InvalidArgumentNumberException.class, () -> talk.launchCommand(arguments));
    }

    @Test
    //test boite blanche
    public void launchCommand3() {
        List<String> arguments = new LinkedList<>();
        arguments.add("arg1");
        assertThrows(NullPointerException.class, () -> talk.launchCommand(arguments));
    }

    @Test
    //test boite blanche
    public void launchCommand4() {
        List<String> arguments = new LinkedList<>();
        arguments.add(guard.getName());
        assertThrows(ClassCastException.class, () -> talk.launchCommand(arguments));
    }

    @Test
    //test boite blanche
    public void launchCommand5() {
        List<String> arguments = new LinkedList<>();
        arguments.add(commoner.getName());
        assertDoesNotThrow(() -> talk.launchCommand(arguments));
    }

    @Test
    //test boite blanche
    public void launchCommand6() {
        List<String> arguments = new LinkedList<>();
        arguments.add(hero.getName());
        assertDoesNotThrow(() -> talk.launchCommand(arguments));
    }

}