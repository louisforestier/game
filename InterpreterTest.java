package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterTest {

    private Interpreter interpreter;


    @BeforeEach
    void setUp() {
        Scanner scanner = new Scanner("");
        Game game = new Game(scanner);
        Hero hero = new Hero();
        interpreter = new Interpreter(hero, game);
    }

/*
    Nous n'avons pas voulu tester chaque commande de l'interpreter car elle sont toutes testés séparément.
    les tests peuvent être considéré comme fonctionnels ou structurels car avec ces 4 tests, on teste chaque décision,
    mais comme on teste la valeur de retour, on sait aussi si la fonction a le comportement adéquat.
*/

    @Test
    //test structurel
    void interpret1() {
        assertFalse(interpreter.interpret(""));
    }

    @Test
    //test structurel
    void interpret2() {
        assertFalse(interpreter.interpret("drhdfh"));
    }

    @Test
    //test structurel
    void interpret3() {
        assertFalse(interpreter.interpret("help fsgdf"));
    }

    @Test
    //test structurel
    void interpret4() {
        assertTrue(interpreter.interpret("help"));
    }
}