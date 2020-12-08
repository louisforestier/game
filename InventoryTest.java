package game;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedList;
import java.util.List;


import org.junit.Before;
import org.junit.Test;

public class InventoryTest {
	
	private Hero hero;
	private Inventory inventory;
	private Book book;
	
	@Before
	public void setUp(){
		hero = new Hero();
		book = new Book("book", "is book", "oui");
		hero.getInventory().put(book.getName(), book);
		inventory = new Inventory(hero);
	}

	@Test
	public void launchCommand1() {
		List<String> arguments = new LinkedList<>(); 
		arguments.add("arg1");
		arguments.add("arg2");
		assertThrows(InvalidArgumentNumberException.class, () -> inventory.launchCommand(arguments));
	}

	@Test
	public void launchCommand2() {
		List<String> arguments = new LinkedList<>(); 
		assertDoesNotThrow(() -> inventory.launchCommand(arguments));
	}
	
	@Test
	public void launchCommand3() {
		List<String> arguments = new LinkedList<>(); 
		arguments.add("book");
		assertDoesNotThrow(() -> inventory.launchCommand(arguments));
	}
	
	@Test
	public void launchCommand4() {
		List<String> arguments = new LinkedList<>(); 
		arguments.add("arg1");
		assertThrows(NullPointerException.class, () -> inventory.launchCommand(arguments));
	}
}
