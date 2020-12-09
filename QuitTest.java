package game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuitTest {
	
	private Game game1;
	private Game game2;
	private Game game3;
	private Quit quit;
	private Scanner sc1;
	private Scanner sc2;
	private Scanner sc3;
	
	@Before
	public void setUp() {
		String reponse1 = "yes";
		String reponse2 = "no";
		String reponse3 = "hezh";
		sc1 = new Scanner(reponse1);
		sc2 = new Scanner(reponse2);
		sc3 = new Scanner(reponse3);
		game1 = new Game(sc1);
		game2 = new Game(sc2);
		game3 = new Game(sc3);
	}
	
	@After
	public void closeStream() {
		sc1.close();
		sc2.close();
		sc3.close();
	}
	
	@Test
	public void launchCommand1() { 
		quit = new Quit(game1);
		List<String> arguments = new LinkedList<>(); 
		assertDoesNotThrow(() -> quit.launchCommand(arguments));	
	}
	
	@Test
	public void launchCommand2() {
		quit = new Quit(game1);
		List<String> arguments = new LinkedList<>(); 
		arguments.add("arg1");
		assertThrows(InvalidArgumentNumberException.class, () -> quit.launchCommand(arguments));
	}
	
	@Test
	public void launchCommand3() {
		quit = new Quit(game1);
		List<String> arguments = new LinkedList<>(); 
		quit.launchCommand(arguments);
		assertFalse(game1.getRunning());
	}
	
	@Test
	public void launchCommand4() {
		quit = new Quit(game2);
		List<String> arguments = new LinkedList<>(); 
		quit.launchCommand(arguments);
		assertTrue(game2.getRunning());
	}
	
	@Test
	public void launchCommand5() {
		quit = new Quit(game3);
		List<String> arguments = new LinkedList<>(); 
		quit.launchCommand(arguments);
		assertTrue(game3.getRunning());
	}

}
