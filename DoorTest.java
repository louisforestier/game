package game;

import static org.junit.Assert.assertSame;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class DoorTest {

    private Door d1;
    private Place p1;

    @Before
    public void setUp(){
    	d1 = new Door("testdoor1");
        Map<String, Interaction> l1 = new HashMap<>();
    	p1 = new Place("start", "p1", l1,0);
    }

    @Test
    public void getEntrance() {
    	assertSame(null, d1.getEntrance());
    }

    @Test
    public void getExit() {
    	assertSame(null, d1.getExit());
    }
    
    @Test
    public void setEntrance() {
    	d1.setEntrance(p1);
    	assertSame(p1, d1.getEntrance());
    }
    
    @Test
    public void setExit() {
    	d1.setExit(p1);
    	assertSame(p1, d1.getExit());
    }

    @Test
    public void cross1() {
    	assertSame(null, d1.getExit());
    }
    
    @Test
    public void cross2() {
    	d1.setExit(p1);
    	assertSame(p1, d1.getExit());
    }
    
}