package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    private Character c1;
    private Place p1;
    private Place p2;
    private Armor armor1;
    private Armor armor2;
    private Weapon weapon1;
    private Weapon weapon2;

    @BeforeEach
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
    //test fonctionnel
    public void setPlace1() {
        c1.setPlace(p1);
        assertSame(p1, c1.getPlace());
    }

    @Test
    //test fonctionnel
    public void setPlace2() {
        c1.setPlace(p1);
        c1.setPlace(p2);
        assertSame(p2,c1.getPlace());
        assertFalse(p1.getInteractions().containsKey(c1.getName()));
    }


    @Test
    //test fonctionnel
    public void freePlace() {
        c1.setPlace(p1);
        c1.freePlace();
        assertNull(c1.getPlace());
        assertFalse(p1.getInteractions().containsKey(c1.getName()));
    }

    @Test
    //test fonctionnel
    public void isAttacked1() {
        int missedAttack = 9;
        int damage = 1;
        c1.isAttacked(missedAttack, damage);
        assertNotEquals(c1.getCurrentHealthPoints(), c1.getMaxHealthPoints() - damage);
    }

    @Test
    //test fonctionnel
    public void isAttacked2() {
        int successfullAttack = 11;
        int damage = 1;
        c1.isAttacked(successfullAttack, damage);
        assertEquals(c1.getCurrentHealthPoints(), c1.getMaxHealthPoints() - damage);
    }

    @Test
    //test fonctionnel
    public void isAttacked3() {
        int successfullAttack = 11;
        int damage = 11;
        c1.isAttacked(successfullAttack, damage);
        assertEquals(0, c1.getCurrentHealthPoints());
        assertFalse(c1.isAlive());
    }

    @Test
    //test fonctionnel
    public void equipArmor1() {
        c1.equipArmor(armor1);
        assertEquals(c1.getArmorClass(), armor1.getArmorClass());
        assertSame(armor1, c1.getArmor());
    }

    @Test
    //test fonctionnel
    public void equipArmor2() {
        c1.equipArmor(armor1);
        c1.equipArmor(armor2);
        assertEquals(c1.getArmorClass(), armor2.getArmorClass());
        assertSame(armor2,c1.getArmor());
        assertTrue(c1.getInventory().containsKey(armor1.getName()));
    }

    @Test
    //test fonctionnel
    public void equipWeapon1() {
        c1.equipWeapon(weapon1);
        assertEquals(c1.getAttackPower(), weapon1.getAttackPower());
        assertSame(weapon1, c1.getWeapon());
    }

    @Test
    //test fonctionnel
    public void equipWeapon2() {
        c1.equipWeapon(weapon1);
        c1.equipWeapon(weapon2);
        assertEquals(c1.getAttackPower(), weapon2.getAttackPower());
        assertSame(weapon2, c1.getWeapon());
        assertTrue(c1.getInventory().containsKey(weapon1.getName()));
    }

}