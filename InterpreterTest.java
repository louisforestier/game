package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterTest {

    private Interpreter interpreter;
    private Game game;
    private Hero hero;
    private Scanner scanner;


    @BeforeEach
    void setUp() {
        scanner = new Scanner("");
        game = new Game(scanner);
        hero = new Hero();
        interpreter = new Interpreter(hero,game);
    }

/*
    Nous n'avons pas voulu tester chaque commande de l'interpreter car elle sont toutes testés séparément.
*/

    @Test
    //test boite blanche
    void interpret1() {
        assertFalse(interpreter.interpret(""));
    }

    @Test
    //test
    void interpret2() {
        assertFalse(interpreter.interpret("drhdfh"));
    }

    @Test
    void interpret3() {
        assertFalse(interpreter.interpret("help fsgdf"));
    }

    @Test
    void interpret4() {
        assertTrue(interpreter.interpret("help"));
    }
}