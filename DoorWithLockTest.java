package game;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class DoorWithLockTest {
    private DoorWithLock d1;
    private DoorWithLock d2;
    private DoorWithLock d3;
    private Place p1;
    private Place p2;
    private Key key1;
    private Key key2;

    @BeforeEach
    public void setUp() {
        key1 = new Key("key", "testkey1");
        key2 = new Key("wrongKey", "testkey2");
        d1 = new DoorWithLock(key1, "testdoor1");
        d2 = new DoorWithLock(key1, "testdoor2");
        d3 = new DoorWithLock(key1, "testdoor3");
        Map<String, Interaction> l1 = new HashMap<>();
        Map<String, Interaction> l2 = new HashMap<>();
        l1.put("end", d1);
        l2.put("start", d2);
        p1 = new Place("start", "p1", l1,0);
        p2 = new Place("end", "p2", l2,0);
        d1.setEntrance(p1);
        d1.setExit(p2);
        d1.setMirrorDoor(d2);
        d2.setEntrance(p2);
        d2.setExit(p1);
        d2.setMirrorDoor(d1);
    }
    
    @Test
    //test fonctionnel
    public void setMirrorDoor() {
    	d1.setMirrorDoor(d3);
    	assertSame(d3, d1.getMirrorDoorForDoorWithLock());
    }
    
    @Test
    //test fonctionnel
    public void setMirrorDoor2() {
    	assertNull(d3.getMirrorDoorForDoorWithLock());
    }
    
    @Test
    //test fonctionnel
    public void getMirrorDoorForDoorWithLock() {
    	assertSame(d2, d1.getMirrorDoorForDoorWithLock());
    }
    
    @Test
    //test fonctionnel
    public void changeMirrorDoor1() {
    	assertFalse(d3.changeMirrorDoor());
    }
    
    @Test
    //test fonctionnel
    public void changeMirrorDoor2() {
    	assertTrue(d1.changeMirrorDoor());
    }
    
    @Test
    //test fonctionnel
    public void changeMirrorDoor3() {
    	d1.unlock(key1);
    	assertFalse(d1.changeMirrorDoor());
    }

    @Test
    //test fonctionnel
    public void switchLockedForMirrorDoor() {
    	assertFalse(d1.switchLockedForMirrorDoor());
    }
    
    @Test
    //test fonctionnel
    public void unlock1() {
        assertFalse(d1.unlock(key1));
    }

    @Test
    //test fonctionnel
    public void unlock2() {
        assertTrue(d1.unlock(key2));
    }
    
    @Test
    //test fonctionnel
    public void unlock3() {
    	d1.unlock(key1);
        assertFalse(d2.getIsLocked());
    }

    @Test
    //test fonctionnel
    public void lock1() {
        assertTrue(d1.lock(key1));
    }

    @Test
    //test fonctionnel
    public void lock2() {
        assertTrue(d1.lock(key2));
    }

    @Test
    //test fonctionnel
    public void lock3() {
        d1.lock(key1);
        assertTrue(d2.getIsLocked());
    }

    @Test
    //test fonctionnel
    public void cross1() {
        assertSame(p1, d1.cross());
    }

    @Test
    //test fonctionnel
    public void cross2() {
        d1.unlock(key1);
        assertSame(p2, d1.cross());
    }
    
    
    @Test
    //test fonctionnel
    public void receiveForKey() {
    	d1.unlock(key1);
    	assertFalse(d1.getIsLocked());
    }

    @Test
    //test fonctionnel
    public void receive() {
    	d2.receive(key1);
    	assertFalse(d2.getIsLocked());
    }
      
}