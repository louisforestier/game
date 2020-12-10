package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TakeTest {

    private Take take;
    private Hero hero;
    private Key key1;
    private Key key2;
    private Container container;

    @BeforeEach
    void setUp() {
        hero = new Hero();
        key1 = new Key("key1", "test_key1");
        key2 = new Key("key2", "test_key2");
        container = new Container("container", "test_container");
        Place place = new Place("place", "test_place", null, 0);
        place.getInteractions().put(key1.getName(), key1);
        container.getContent().put(key2.getName(), key2);
        place.getInteractions().put(container.getName(), container);
        hero.setPlace(place);
        take = new Take(hero);
    }

    @Test
        //test fonctionnel
    void stringToItemInPlace1() {
        assertSame(container, take.stringToItemInPlace(container.getName()));
    }

    @Test
        //test fonctionnel
    void stringToItemInPlace2() {
        assertNull(take.stringToItemInPlace(key2.getName()));
    }

    @Test
        //test fonctionnel
    void stringToItemInPlace3() {
        assertThrows(ClassCastException.class, () -> take.stringToItemInPlace(hero.getName()));
    }


    @Test
        //test fonctionnel
    void stringToChestInPlace1() {
        assertSame(container, take.stringToContainerInPlace(container.getName()));
    }

    @Test
        //test fonctionnel
    void stringToChestInPlace2() {
        assertNull(take.stringToContainerInPlace("arg"));
    }

    @Test
        //test fonctionnel
    void stringToChestInPlace3() {
        assertThrows(ClassCastException.class, () -> take.stringToContainerInPlace(key1.getName()));
    }


    @Test
        //test fonctionnel
    void stringToItemInChest1() {
        assertSame(key2, take.stringToItemInContainer(key2.getName(), container));

    }

    @Test
        //test fonctionnel
    void stringToItemInChest2() {
        assertNull(take.stringToItemInContainer(key1.getName(), container));
    }

    @Test
        //test structurel
    void launchCommand1() {
        List<String> arguments = new LinkedList<>();
        assertThrows(InvalidArgumentNumberException.class, () -> take.launchCommand(arguments));
    }

    @Test
        //test structurel
    void launchCommand2() {
        List<String> arguments = new LinkedList<>();
        arguments.add("arg1");
        arguments.add("arg2");
        arguments.add("arg3");
        assertThrows(InvalidArgumentNumberException.class, () -> take.launchCommand(arguments));
    }

    @Test
        //test fonctionnel
    void launchCommand3() {
        List<String> arguments = new LinkedList<>();
        arguments.add(key2.getName());
        assertThrows(NullPointerException.class, () -> take.launchCommand(arguments));
    }

    @Test
        //test fonctionnel
    void launchCommand4() {
        List<String> arguments = new LinkedList<>();
        arguments.add(hero.getName());
        assertThrows(ClassCastException.class, () -> take.launchCommand(arguments));
    }

    @Test
        //test fonctionnel
    void launchCommand5() {
        List<String> arguments = new LinkedList<>();
        arguments.add(key1.getName());
        assertDoesNotThrow(() -> take.launchCommand(arguments));
    }

    @Test
        //test fonctionnel
    void launchCommand6() {
        List<String> arguments = new LinkedList<>();
        arguments.add("arg1");
        arguments.add(key1.getName());
        assertThrows(NullPointerException.class, () -> take.launchCommand(arguments));
    }

    @Test
        //test fonctionnel
    void launchCommand7() {
        List<String> arguments = new LinkedList<>();
        arguments.add(key1.getName());
        arguments.add("arg1");
        assertThrows(ClassCastException.class, () -> take.launchCommand(arguments));
    }

    @Test
        //test fonctionnel
    void launchCommand8() {
        List<String> arguments = new LinkedList<>();
        arguments.add("arg1");
        arguments.add("arg2");
        assertThrows(NullPointerException.class, () -> take.launchCommand(arguments));
    }

    @Test
        //test fonctionnel
    void launchCommand9() {
        List<String> arguments = new LinkedList<>();
        arguments.add(container.getName());
        arguments.add("arg2");
        assertThrows(NullPointerException.class, () -> take.launchCommand(arguments));
    }

    @Test
        //test structurel
    void launchCommand10() {
        List<String> arguments = new LinkedList<>();
        arguments.add(container.getName());
        arguments.add(key2.getName());
        assertDoesNotThrow(() -> take.launchCommand(arguments));
    }


    @Test
        //test fonctionnel
    void launchCommand11() {
        List<String> arguments = new LinkedList<>();
        arguments.add(key1.getName());
        take.launchCommand(arguments);
        assertTrue(hero.getInventory().containsKey(key1.getName()));
    }

    @Test
        //test fonctionnel
    void launchCommand12() {
        List<String> arguments = new LinkedList<>();
        arguments.add(container.getName());
        arguments.add(key2.getName());
        take.launchCommand(arguments);
        assertTrue(hero.getInventory().containsKey(key2.getName()));
    }


}