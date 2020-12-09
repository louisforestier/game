package game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class HeroTest {

    private Hero hero;
    private Place p1;
    private Place p2;
    private Place p3;
    private Map<String, Interaction> l1;
    private Map<String, Interaction> l2;
    private Map<String, Interaction> l3;
    private Door d1;
    private DoorWithLock d2;
    private Door d3;
    private Key key1;
    private Key key2;
    private Container chest;
    private Armor armor;
    private Weapon weapon;


    @Before
    public void setUp() {
        key1 = new Key("key1", "testkey1");
        key2 = new Key("key2", "testkey2");
        d1 = new Door("is d1");
        d2 = new DoorWithLock(key1, "locked door");
        d3 = new Door("door with no entrance nor exit");
        chest = new Container("chest","chest_test");
        chest.getContent().put(key2.getName(), key2);
        l1 = new HashMap<>();
        l1.put("p2", d1);
        l1.put("p3", d2);
        l1.put(chest.getName(), chest);
        p1 = new Place("p1", "is p1", l1, 0);
        p2 = new Place("p2", "is p2", null, 0);
        p3 = new Place("p3", "is p3", null, 0);
        d1.setEntrance(p1);
        d1.setExit(p2);
        d2.setEntrance(p1);
        d2.setExit(p3);
        hero = new Hero();
        hero.setPlace(p1);
        armor = new LeatherArmor("leather_armor_test","testequip1");
        weapon = new Dagger("dagger_test","testequip2");
    }

    @Test
    public void go1() {
        hero.go(d1);
        assertSame(p2, hero.getPlace());
    }

    @Test
    public void go2() {
        hero.go(d2);
        assertSame(p1, hero.getPlace());
    }

        @Test //should never happen
    public void go3() {
        assertThrows(NullPointerException.class, () -> hero.go(d3));
    }


    @Test
    public void take() {
        hero.take(key1);
        assertSame(key1,hero.getInventory().get(key1.getName()));
        assertFalse(hero.getPlace().getInteractions().containsKey(key1.getName()));
    }

    @Test
    public void takeFromChest() {
        hero.takeFromChest(chest,key2);
        assertSame(key2, hero.getInventory().get(key2.getName()));
        assertFalse(chest.getContent().containsKey(key2.getName()));
    }


    @Test
    public void equip1() {
        hero.equip(armor);
        assertSame(armor, hero.getArmor());
        assertEquals(hero.getArmorClass(), armor.getArmorClass());
    }

    @Test
    public void equip2() {
        hero.equip(weapon);
        assertSame(weapon, hero.getWeapon());
        assertEquals(hero.getAttackPower(), weapon.getAttackPower());
    }

    @Test
    public void equip3() {
        assertThrows(NullPointerException.class, () -> hero.equip(null));
    }


}