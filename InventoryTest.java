package game;


import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class InventoryTest {

	private Inventory inventory;

	@BeforeEach
	public void setUp(){
		Hero hero = new Hero();
		Book book = new Book("book", "is book", "oui");
		hero.getInventory().put(book.getName(), book);
		inventory = new Inventory(hero);
	}

	@Test
	//test fonctionnel
	public void launchCommand1() {
		List<String> arguments = new LinkedList<>(); 
		arguments.add("arg1");
		arguments.add("arg2");
		assertThrows(InvalidArgumentNumberException.class, () -> inventory.launchCommand(arguments));
	}

	@Test
	//test fonctionnel
	public void launchCommand2() {
		List<String> arguments = new LinkedList<>(); 
		assertDoesNotThrow(() -> inventory.launchCommand(arguments));
	}
	
	@Test
	//test fonctionnel
	public void launchCommand3() {
		List<String> arguments = new LinkedList<>(); 
		arguments.add("book");
		assertDoesNotThrow(() -> inventory.launchCommand(arguments));
	}
	
	@Test
	//test fonctionnel
	public void launchCommand4() {
		List<String> arguments = new LinkedList<>(); 
		arguments.add("arg1");
		assertThrows(NullPointerException.class, () -> inventory.launchCommand(arguments));
	}
}
