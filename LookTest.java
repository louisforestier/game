package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

public class LookTest {

	private Look look;
	private Gold gold;
	
	@BeforeEach
	public void setUp() {
		Place p1 = new Place("p1", "is p1", null, 0);
		Hero hero = new Hero();
		Book book = new Book("book", "is book", "oui");
		p1.getInteractions().put("book", book);
		gold = new Gold("gold", "is gold");
		look = new Look(hero);
		hero.setPlace(p1);
	}
	
	@Test
	//test structurel
	public void launchCommand1() {
		List<String> arguments = new LinkedList<>(); 
		assertDoesNotThrow(() -> look.launchCommand(arguments));	
	}
	
	@Test
	//test structurel
	public void launchCommand2() {
		List<String> arguments = new LinkedList<>(); 
		arguments.add("arg1");
		arguments.add("arg2");
		assertThrows(InvalidArgumentNumberException.class, () -> look.launchCommand(arguments));
	}
	
	@Test
	//test fonctionnel
	public void launchCommand3() {
		List<String> arguments = new LinkedList<>(); 
		arguments.add("book");
		assertDoesNotThrow(() -> look.launchCommand(arguments));	
	}
	
	@Test
	//test fonctionnel
	public void launchCommand4() {
		List<String> arguments = new LinkedList<>(); 
		arguments.add(gold.getName());
		assertThrows(NullPointerException.class, () -> look.launchCommand(arguments));
	}

}
