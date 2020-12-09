package game;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LookTest {

	private Look look;
	
	@Before
	public void setUp() {
		Place p1 = new Place("p1", "is p1", null, 0);
		Hero hero = new Hero();
		Book book = new Book("book", "is book", "oui");
		p1.getInteractions().put("book", book);
		Gold gold = new Gold("gold", "is gold");
		look = new Look(hero);
		hero.setPlace(p1);
	}
	
	@Test
	public void launchCommand1() {
		List<String> arguments = new LinkedList<>(); 
		assertDoesNotThrow(() -> look.launchCommand(arguments));	
	}
	
	@Test
	public void launchCommand2() {
		List<String> arguments = new LinkedList<>(); 
		arguments.add("arg1");
		arguments.add("arg2");
		assertThrows(InvalidArgumentNumberException.class, () -> look.launchCommand(arguments));
	}
	
	@Test
	public void launchCommand3() {
		List<String> arguments = new LinkedList<>(); 
		arguments.add("book");
		assertDoesNotThrow(() -> look.launchCommand(arguments));	
	}
	
	@Test
	public void launchCommand4() {
		List<String> arguments = new LinkedList<>(); 
		arguments.add("gold");
		assertThrows(NullPointerException.class, () -> look.launchCommand(arguments));
	}

}
