package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


public class QuitTest {
	
	private Game game;
	private Quit quit;
	private Scanner scanner;

	@BeforeEach
	public void setUp() {
		String reponse1 = "yes";
		String reponse2 = "no";
		String reponse3 = "hezh";
		scanner = new Scanner(reponse1);
		game = new Game(scanner);
	}
	
	@AfterEach
	public void closeStream() {
		scanner.close();
	}
	
	@Test
	//test structurel
	public void launchCommand1() { 
		quit = new Quit(game);
		List<String> arguments = new LinkedList<>(); 
		assertDoesNotThrow(() -> quit.launchCommand(arguments));	
	}
	
	@Test
	//test structurel
	public void launchCommand2() {
		quit = new Quit(game);
		List<String> arguments = new LinkedList<>(); 
		arguments.add("arg1");
		assertThrows(InvalidArgumentNumberException.class, () -> quit.launchCommand(arguments));
	}


}
