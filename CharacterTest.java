package game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {

    private Character c1;
    private Place p1;
    private Place p2;
    private Armor armor1;
    private Armor armor2;
    private Weapon weapon1;
    private Weapon weapon2;

    @Before
    public void setUp() {
        c1 = new Guard("c1","");
        p1 = new Place("p1", "piece1", null, 100);
        p2 = new Place("p2", "piece2", null, 100);
        armor1 = new LeatherArmor("armor1" ,"" );
        armor2 = new LeatherArmor("armor2" ,"" );
        weapon1 = new Dagger("weapon1", "");
        weapon2 = new Dagger("weapon2", "");

    }

    @Test
    public void setPlace1() {
        c1.setPlace(p1);
        assertSame(p1, c1.getPlace());
    }

    @Test
    public void setPlace2() {
        c1.setPlace(p1);
        c1.setPlace(p2);
        assertSame(p2,c1.getPlace());
        assertFalse(p1.getInteractions().containsKey(c1.getName()));
    }


    @Test
    public void freePlace() {
        c1.setPlace(p1);
        c1.freePlace();
        assertNull(c1.getPlace());
        assertFalse(p1.getInteractions().containsKey(c1.getName()));
    }

    @Test
    public void isAttacked1() {
        c1.isAttacked(9, 1);
        assertNotEquals(c1.getCurrentHealthPoints(), c1.getMaxHealthPoints() - 1);
    }

    @Test
    public void isAttacked2() {
        c1.isAttacked(11, 1);
        assertEquals(c1.getCurrentHealthPoints(), c1.getMaxHealthPoints() - 1);
    }

    @Test
    public void isAttacked3() {
        c1.isAttacked(11, 11);
        assertEquals(0, c1.getCurrentHealthPoints());
        assertFalse(c1.isAlive());
    }

    @Test
    public void equipArmor1() {
        c1.equipArmor(armor1);
        assertEquals(c1.getArmorClass(), armor1.getArmorClass());
        assertSame(armor1, c1.getArmor());
    }

    @Test
    public void equipArmor2() {
        c1.equipArmor(armor1);
        c1.equipArmor(armor2);
        assertEquals(c1.getArmorClass(), armor2.getArmorClass());
        assertSame(armor2,c1.getArmor());
        assertTrue(c1.getInventory().containsKey(armor1.getName()));
    }

    @Test
    public void equipWeapon1() {
        c1.equipWeapon(weapon1);
        assertEquals(c1.getAttackPower(), weapon1.getAttackPower());
        assertSame(weapon1, c1.getWeapon());
    }

    @Test
    public void equipWeapon2() {
        c1.equipWeapon(weapon1);
        c1.equipWeapon(weapon2);
        assertEquals(c1.getAttackPower(), weapon2.getAttackPower());
        assertSame(weapon2, c1.getWeapon());
        assertTrue(c1.getInventory().containsKey(weapon1.getName()));
    }

}