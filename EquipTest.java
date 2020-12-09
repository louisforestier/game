package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EquipTest {

    private Equip equip;
    private Key key;
    private Weapon weapon;

    @BeforeEach
    void setUp() {
        Hero hero = new Hero();
        key = new Key("key", "test_key");
        weapon = new Dagger("equipment", "test_equipment");
        hero.getInventory().put(weapon.getName(), weapon);
        hero.getInventory().put(key.getName(), key);
        equip = new Equip(hero);
    }

    @Test
        //test boite noire
    void stringtoEquipable1() {
        assertSame(weapon, equip.stringtoEquipable("equipment"));
    }

    @Test
        //test boite noire
    void stringtoEquipable2() {
        assertNull(equip.stringtoEquipable("arg"));
    }

    @Test
        //test boite blanche
    void stringtoEquipable3() {
        assertThrows(ClassCastException.class, () -> equip.stringtoEquipable(key.getName()));
    }

    @Test
    //test boite blanche
    void stringtoEquipable4() {
        assertDoesNotThrow(() -> equip.stringtoEquipable(weapon.getName()));
    }


    @Test
    //test boite blanche
    void launchCommand1() {
        List<String> arguments = new LinkedList<>();
        assertThrows(InvalidArgumentNumberException.class, () -> equip.launchCommand(arguments));
    }

    @Test
    //test boite blanche
    void launchCommand2() {
        List<String> arguments = new LinkedList<>();
        arguments.add("arg1");
        arguments.add("arg2");
        assertThrows(InvalidArgumentNumberException.class, () -> equip.launchCommand(arguments));
    }

    @Test
        //test boite blanche
    void launchCommand3() {
        List<String> arguments = new LinkedList<>();
        arguments.add("arg1");
        assertThrows(NullPointerException.class, () -> equip.launchCommand(arguments));
    }

    @Test
        //test boite blanche
    void launchCommand4() {
        List<String> arguments = new LinkedList<>();
        arguments.add(key.getName());
        assertThrows(ClassCastException.class, () -> equip.launchCommand(arguments));
    }

    @Test
        //test boite blanche
    void launchCommand5() {
        List<String> arguments = new LinkedList<>();
        arguments.add(weapon.getName());
        assertDoesNotThrow(() -> equip.launchCommand(arguments));
    }


}