package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;


public class UseTest {

    private Use use;
    private Hero hero;
    private Door d1;
    private DoorWithLock d2;
    private Key key1;
    private Key key2;

    @BeforeEach
    public void setUp() {
        key1 = new Key("key1", "testkey1");
        key2 = new Key("key2", "testkey1");
        d1 = new Door("is d1");
        d2 = new DoorWithLock(key1, "testdoor1");
        Place p1 = new Place("p1", "is p1", null, 0);
        Place p2 = new Place("p2", "is p2", null, 0);
        Place p3 = new Place("p3", "is p3", null, 0);
        d1.setEntrance(p1);
        d1.setExit(p2);
        d2.setEntrance(p1);
        d2.setExit(p3);
        p1.getInteractions().put(d1.getExit().getName(), d1);
        p1.getInteractions().put(d2.getExit().getName(), d2);
        p1.getInteractions().put(key2.getName(), key2);
        hero = new Hero();
        hero.setPlace(p1);
        hero.getInventory().put(key1.getName(), key1);
        use = new Use(hero);
    }


    @Test
    //test fonctionnel
    public void convertStringToUsable1() {
        assertSame(key1, use.convertStringToUsable(key1.getName()));
    }

    @Test
    //test fonctionnel
    public void convertStringToUsable2() {
        assertThrows(ClassCastException.class, () -> use.convertStringToUsable(hero.getName()));
    }

    @Test
    //test fonctionnel
    public void convertStringToUsable3() {
        assertNull(use.convertStringToUsable("arg"));
    }


    @Test
    //test fonctionnel
    public void convertStringToReceiver1() {
        assertSame(d2, use.convertStringToReceiver(d2.getExit().getName()));
    }

    @Test
    //test fonctionnel
    public void convertStringToReceiver2() {
        assertThrows(ClassCastException.class, () -> use.convertStringToReceiver(d1.getExit().getName()));
    }


    @Test
    //test structurel
    public void launchCommand1() {
        List<String> arguments = new LinkedList<>();
        assertThrows(InvalidArgumentNumberException.class, () -> use.launchCommand(arguments));

    }

    @Test
    //test structurel
    public void launchCommand2() {
        List<String> arguments = new LinkedList<>();
        arguments.add("arg1");
        arguments.add("arg2");
        arguments.add("arg3");
        assertThrows(InvalidArgumentNumberException.class, () -> use.launchCommand(arguments));
    }

    @Test
    //test fonctionnel
    public void launchCommand3() {
        List<String> arguments = new LinkedList<>();
        arguments.add("arg1");
        assertThrows(NullPointerException.class, () -> use.launchCommand(arguments));
    }

    @Test
    //test fonctionnel
    public void launchCommand4() {
        List<String> arguments = new LinkedList<>();
        arguments.add(key1.getName());
        arguments.add("arg2");
        assertThrows(NullPointerException.class, () -> use.launchCommand(arguments));
    }

    @Test
    //test fonctionnel
    public void launchCommand5() {
        List<String> arguments = new LinkedList<>();
        arguments.add(key1.getName());
        arguments.add(d1.getExit().getName());
        assertThrows(ClassCastException.class, () -> use.launchCommand(arguments));
    }

    @Test
    //test fonctionnel
    public void launchCommand6() {
        List<String> arguments = new LinkedList<>();
        arguments.add(d1.getExit().getName());
        arguments.add(d2.getExit().getName());
        assertThrows(ClassCastException.class, () -> use.launchCommand(arguments));
    }

    @Test
    //test fonctionnel
    public void launchCommand7() {
        List<String> arguments = new LinkedList<>();
        arguments.add(key2.getName());
        arguments.add(d2.getExit().getName());
        assertDoesNotThrow(() -> use.launchCommand(arguments));
    }


    @Test
    //test fonctionnel
    public void launchCommand8() {
        List<String> arguments = new LinkedList<>();
        arguments.add(key1.getName());
        arguments.add(d2.getExit().getName());
        use.launchCommand(arguments);
        assertFalse(d2.getIsLocked());
    }

    @Test
    //test fonctionnel
    public void launchCommand9() {
        List<String> arguments = new LinkedList<>();
        arguments.add(key2.getName());
        arguments.add(d2.getExit().getName());
        use.launchCommand(arguments);
        assertTrue(d2.getIsLocked());
    }


}