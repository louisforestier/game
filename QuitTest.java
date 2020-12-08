package game;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuitTest {
	
	private Game game;
	private Quit quit;
	private Scanner sc;
	
	@Before
	public void setUp() {
		sc = new Scanner(System.in);
		game = new Game(sc);
		quit = new Quit(game);
	}
	
	@After
	public void closeStream() {
		sc.close();
	}
	
	@Test
	public void launchCommand1() { 
		List<String> arguments = new LinkedList<>(); 
		assertDoesNotThrow(() -> quit.launchCommand(arguments));	
	}
	
	@Test
	public void launchCommand2() {
		List<String> arguments = new LinkedList<>(); 
		arguments.add("arg1");
		assertThrows(InvalidArgumentNumberException.class, () -> quit.launchCommand(arguments));
	}

}
