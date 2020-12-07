package game;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class GoTest {
	
	private Go go;
	private Hero hero;
	private Place p1;
	private Place p2;
	private Place p3;
	private Map<String, Interaction> l1;
	private Map<String, Interaction> l2;
	private Map<String, Interaction> l3;
	private Door d1;
	private Door d2;
	private DoorWithLock d3;
    private DoorWithLock d4;
    private Key key1;

	@Before
	public void setUp() {
		key1 = new Key("key", "testkey1");
		d1 = new Door("is d1");
		d2 = new Door("is d2");
		d3 = new DoorWithLock(key1, "testdoor1");
        d4 = new DoorWithLock(key1, "testdoor2");
		l1 = new HashMap<>();
        l2 = new HashMap<>();
        l3 = new HashMap<>();
		p1 = new Place("p1", "is p1", l1, 0);
		p2 = new Place("p2", "is p2", l2, 0);
		p3 = new Place("p3", "is p3", l3, 0);
		l1.put("p2", d1);
		l1.put("p3", d3);
        l2.put("p1", d2);
        l3.put("p1", d4);
        d1.setEntrance(p1);
        d1.setExit(p2);
        d2.setEntrance(p2);
        d2.setExit(p1);
        d3.setEntrance(p1);
        d3.setExit(p3);
        d3.setMirrorDoor(d4);
        d4.setEntrance(p3);
        d4.setExit(p1);
        d4.setMirrorDoor(d3);
		hero = new Hero();
		hero.setPlace(p1);
		go = new Go(hero);
	}
	
	@Test
    public void convertStringToDoor(){
        //assertThrows(ClassCastException.class, go.convertStringToDoor("d1"));
        }

    @Test
    public void launchCommand1(){
        //assertThrows(InvalidArgumentNumberException.class, go.launchCommand(null));
    }
}
