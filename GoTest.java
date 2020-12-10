package game;



import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoTest {
	
	private Go go;
	private Hero hero;
	private Place p2;
	private Door d1;
	private DoorWithLock d2;

	@BeforeEach
	public void setUp() {
		Key key1 = new Key("key", "testkey1");
		d1 = new Door("is d1");
		d2 = new DoorWithLock(key1, "testdoor1");
		Place p1 = new Place("p1", "is p1", null, 0);
		p2 = new Place("p2", "is p2", null, 0);
		Place p3 = new Place("p3", "is p3", null, 0);
        d1.setEntrance(p1);
        d1.setExit(p2);
        d2.setEntrance(p1);
        d2.setExit(p3);
        p1.getInteractions().put(d1.getExit().getName(), d1);
        p1.getInteractions().put(d2.getExit().getName(), d2);
		hero = new Hero();
		hero.setPlace(p1);
		go = new Go(hero);
	}
	
	@Test
	//test fonctionnel
	public void convertStringToDoor1(){
		assertThrows(ClassCastException.class, () -> go.convertStringToDoor(hero.getName()));
	}
	
	@Test
	//test fonctionnel
	public void convertStringToDoor2() {
		assertDoesNotThrow(() -> go.convertStringToDoor("p2"));
	}
	
	@Test
	//test fonctionnel
	public void convertStringToDoor3() {
		assertDoesNotThrow(() -> go.convertStringToDoor("p3"));
	}
	
	@Test
	//test fonctionnel
	public void convertStringToDoor4() {
		assertSame(d1, go.convertStringToDoor("p2"));
	}
	
	@Test
	//test fonctionnel
	public void convertStringToDoor5() {
		assertSame(d2, go.convertStringToDoor("p3"));
	}

    @Test
	//test structurel
	public void launchCommand1(){
        List<String> arguments = new LinkedList<>(); 
    	assertThrows(InvalidArgumentNumberException.class, () -> go.launchCommand(arguments));
    }
    
    @Test
	//test structurel
	public void launchCommand2() {
		List<String> arguments = new LinkedList<>(); 
		arguments.add("arg1");
		arguments.add("arg2");
		assertThrows(InvalidArgumentNumberException.class, () -> go.launchCommand(arguments));
	}

    
	@Test
	//test fonctionnel
	public void launchCommand3() {
		List<String> arguments = new LinkedList<>(); 
		arguments.add("arg1");
		assertThrows(NullPointerException.class, () -> go.launchCommand(arguments));
	}
	
	@Test
	//test fonctionnel
	public void launchCommand4() {
		List<String> arguments = new LinkedList<>(); 
		arguments.add("p2");
		go.launchCommand(arguments);
		assertSame(p2, hero.getPlace());
	}
}
