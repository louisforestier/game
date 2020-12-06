package game;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;


public class DoorWithLockTest {
    private DoorWithLock d1;
    private DoorWithLock d2;
    private Place p1;
    private Place p2;
    private Map<String, Interaction> l1;
    private Map<String, Interaction> l2;
    private Key key1;
    private Key key2;
    //quand autre objet, faire dans receiver test si usable pas key

    @Before
    public void setUp() {
        key1 = new Key("key", "testkey1");
        key2 = new Key("wrongKey", "testkey2");
        d1 = new DoorWithLock(key1, "testdoor1");
        d2 = new DoorWithLock(key1, "testdoor2");
        l1 = new HashMap<>();
        l2 = new HashMap<>();
        l1.put("end", d1);
        l2.put("start", d2);
        p1 = new Place("start", "p1", l1);
        p2 = new Place("end", "p2", l2);
        d1.setEntrance(p1);
        d1.setExit(p2);
        d2.setEntrance(p2);
        d2.setExit(p1);
    }

    /*
    @Test
    public void printKeyForThisDoor() {
        assertSame(key1, d1.printKeyForThisDoor());
    }
     */
    
    @Test
    public void unlock1() {
        assertFalse(d1.unlock(key1));
    }

    @Test
    public void unlock2() {
        assertTrue(d1.unlock(key2));
    }

    @Test
    public void lock1() {
        assertTrue(d1.lock(key1));
    }

    @Test
    public void lock2() {
        assertTrue(d1.lock(key2));
    }

    @Test
    public void lock3() {
        d1.unlock(key1);
        assertFalse(d1.lock(key2));
    }

    @Test
    public void cross1() {
        assertSame(p1, d1.cross());
    }

    @Test
    public void cross2() {
        d1.unlock(key1);
        assertSame(p2, d1.cross());
    }

    @Test
    public void receive1() {
        //assertFalse(d1.receive(key1));
    }

    @Test
    public void receive2() {
        d1.unlock(key1);
        //assertTrue(d1.receive(key1));
    }
}