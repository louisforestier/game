package game;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.HashMap;
import java.util.LinkedList;
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
	private DoorWithLock d3;
    private Key key1;

	@Before
	public void setUp() {
		key1 = new Key("key", "testkey1");
		d1 = new Door("is d1");
		d3 = new DoorWithLock(key1, "testdoor1");
		l1 = new HashMap<>();
        l2 = new HashMap<>();
        l3 = new HashMap<>();
		p1 = new Place("p1", "is p1", l1, 0);
		p2 = new Place("p2", "is p2", l2, 0);
		p3 = new Place("p3", "is p3", l3, 0);
		l1.put("p2", d1);
		l1.put("p3", d3);
        d1.setEntrance(p1);
        d1.setExit(p2);
        d3.setEntrance(p1);
        d3.setExit(p3);
		hero = new Hero();
		hero.setPlace(p1);
		go = new Go(hero);
	}
	
	@Test
    public void convertStringToDoor1(){
		assertThrows(ClassCastException.class, () -> go.convertStringToDoor(hero.getName()));
	}
	
	@Test
	public void convertStringToDoor2() {
		assertDoesNotThrow(() -> go.convertStringToDoor(d1.getExit().getName()));
	}
	
	@Test
	public void convertStringToDoor3() {
		assertDoesNotThrow(() -> go.convertStringToDoor(d3.getExit().getName()));
	}

    @Test
    public void launchCommand1(){
        List<String> arguments = new LinkedList<>(); 
    	assertThrows(InvalidArgumentNumberException.class, () -> go.launchCommand(arguments));
    }
}
