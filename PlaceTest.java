package game;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlaceTest {

    private Place p1;
    private Place p2;
    private Key key1;
    private Key key2;
    private Character c1;
    private Character c2;

    @BeforeEach
    public void setUp(){
    	c1 = new Guard("c1", "test_c1");
    	c2 = new Guard("c2", "test_c2");
    	key1 = new Key("key1","test_key1");
    	key2 = new Key("key2","test_key2");
        Map<String, Interaction> l1 = new HashMap<>();
        l1.put(c1.getName(), c1);
        l1.put(key1.getName(), key1);
    	p1 = new Place("p1", "test_p1", l1,101);
    	p2 = new Place("p2", "test_p2", null,0);
    }

    @Test
    public void addCharacter() {
        p1.addCharacter(c2.getName(), c2);
        assertTrue(p1.getInteractions().containsKey(c2.getName()));
    }

    @Test
    public void freeCharacter() {
        p1.freeCharacter(c1.getName());
        assertFalse(p1.getInteractions().containsKey(c1.getName()));
    }

    @Test
    public void isInPlace1() {
        assertTrue(p1.isInPlace(key1.getName()));
    }

    @Test
    public void isInPlace2() {
        assertFalse(p1.isInPlace(key2.getName()));
    }


    @Test
    public void takeOut() {
        p1.takeOut(key1);
        assertFalse(p1.getInteractions().containsKey(key1.getName()));
    }

    @Test
    public void getEnemiesInPlace1() {
        p1.addCharacter(c2.getName(), c2);
        Map<String, Character> enemies = new HashMap<>();
        enemies.put(c1.getName(), c1);
        enemies.put(c2.getName(), c2);
        assertEquals(enemies, p1.getEnemiesInPlace());
    }

    @Test
    public void getEnemiesInPlace2() {
        assertTrue(p2.getEnemiesInPlace().isEmpty());
    }


    @Test
    public void randomEncoutner1(){
        assertTrue(p1.randomEncoutner());
    }

    @Test
    public void randomEncoutner2(){
        assertFalse(p2.randomEncoutner());
    }

    @Test
    public void randomEncoutner3(){
        p2.addCharacter(c2.getName(), c2);
        assertFalse(p2.randomEncoutner());
    }

    @Test
    public void getAnEnemyName(){
        assertEquals(c1.getName(),p1.getAnEnemyName());
    }


}
