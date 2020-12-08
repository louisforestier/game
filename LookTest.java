package game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LookTest {
	
	private Place p1;
	private Hero hero;
	private Book book;
	private Gold gold;
	private Look look;
	
	@Before
	public void setUp() {
		p1 = new Place("p1", "is p1", null, 0);
		hero = new Hero();
		book = new Book("book", "is book", "oui");
		p1.getInteractions().put("book", book);
		gold = new Gold("gold", "is gold");
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
