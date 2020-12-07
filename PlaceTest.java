package game;

import static org.junit.Assert.assertSame;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class PlaceTest {

	private Door d1;
    private Place p1;
    private Place p2;

    @Before
    public void setUp(){
    	d1 = new Door("testdoor1");
        Map<String, Interaction> l1 = new HashMap<>();
        Map<String, Interaction> l2 = new HashMap<>();
    	p1 = new Place("start", "p1", l1,0);
    	p2 = new Place("end", "p2", l2,0);
    }

    @Test
    public void place() {
        
    }

    @Test
    public void getInteractions() {
    }

    @Test
    public void getName() {
    }

    @Test
    public void addCharacter() {
    }

    @Test
    public void freeCharacter() {
    }

    @Test
    public void isInPlace() {
    }

    @Test
    public void takeOut() {
    }
}
