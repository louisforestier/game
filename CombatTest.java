package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CombatTest {

    private Combat combat;
    private Hero hero;
    private Character enemy1;
    private Character enemy2;
    private final Map<String, Character> enemies = new HashMap<>();


    @BeforeEach
    void setUp() {
        hero = new Hero();
        enemy1 = new Guard("enemy1", "test_enemy1");
        enemy2 = new Guard("enemy2", "test_enemy2");
        enemies.put(enemy1.getName(), enemy1);
        enemies.put(enemy2.getName(), enemy2);
        Scanner input = new Scanner("flee");
        combat = new Combat(hero, enemies, input);
        hero.setOngoingCombat(combat);
    }


/*
    je ne vois pas comment tester cette fonction, elle ne peut pas renvoyer d'exceptions en fonction de l'input
    car elles sont catch dans l'interpreter. Il est compliqué de connaître les résultats sachant que celui-ci est
    déterminé de manière aléatoire. Une solution aurait été de créer une classe Dice ou RandomNumberGenerator au lieu d'utiliser Random
    pour pouvoir créer des instances non aléatoires pour les tests mais nous n'avons pas eu le temps de nous pencher
    sur cette solution.
    De plus je ne suis sûr que cela soit très utile, les commandes de l'interpreter et celui-ci sont déjà testés.

    @Test
    void heroTurn() {
    }
*/

/*
    De même pour cette méthode.
    De plus elle n'est pas très utile mais peut servir dans le cas où on aurait, plus tard,
    plus d'actions possibles pour les ennemies.
    @Test
    void enemyTurn() {
    }
*/


    @Test
        //test fonctionnel
    void endCombat1() {
        assertTrue(combat.endCombat(hero));
    }

    @Test
        //test fonctionnel
    void endCombat2() {
        enemy1.setAlive(false);
        assertTrue(combat.endCombat(hero));
    }

    @Test
        //test fonctionnel
    void endCombat3() {
        hero.setAlive(false);
        assertFalse(combat.endCombat(hero));
    }

    @Test
        //test fonctionnel
    void endCombat4() {
        enemy1.setAlive(false);
        enemy2.setAlive(false);
        assertFalse(combat.endCombat(hero));
    }

    @Test
        //test fonctionnel
    void runCombat() {
        combat.runCombat(hero);
        assertNull(hero.getOngoingCombat());
    }
}