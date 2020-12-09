package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AttackTest {

    private Attack attack1;
    private Attack attack2;
    private Hero hero;
    private Scanner scanner1;
    private Scanner scanner2;
    private Place p1;
    private Dialog dialog;
    private Commoner commoner;
    private Guard guard;
    private Armor armor;
    private Combat combat;

    @BeforeEach
    void setUp() {
        scanner1 = new Scanner("flee");
        scanner2 = new Scanner("attack guard\nflee");
        hero = new Hero();
        p1 = new Place("p1", "test_p1", null, 0);
        hero.setPlace(p1);
        dialog = new Dialog(new ArrayList<>(), new ArrayList<>());
        commoner = new Commoner("commoner", "test_commoner", dialog);
        guard = new Guard("guard", "test_guard");
        armor = new LeatherArmor("armor", "test_armor");
        p1.getInteractions().put(commoner.getName(), commoner);
        p1.getInteractions().put(guard.getName(), guard);
        p1.getInteractions().put(armor.getName(),armor);
        attack1 = new Attack(hero, scanner1);
        attack2 = new Attack(hero, scanner2);
        combat = new Combat(hero,hero.getPlace().getEnemiesInPlace(), scanner2);
    }

    @Test
    //test boite noir
    void stringToAttackableInPlace1() {
        assertSame(commoner, attack1.stringToAttackableInPlace(commoner.getName()));
    }

    @Test
    //test boite blanche ?
    void stringToAttackableInPlace2() {
        assertSame(null, attack1.stringToAttackableInPlace("arg"));
    }

    @Test
    //test boite blanche
    void stringToAttackableInPlace3() {
        assertThrows(ClassCastException.class, () -> attack1.stringToAttackableInPlace(armor.getName()));
    }

    @Test
    //test boite blanche
    void stringToAttackableInPlace4() {
        assertDoesNotThrow(() -> attack1.stringToAttackableInPlace(commoner.getName()));
    }

    @Test
    //test boite blanche/noire ? permet de tester un chemin mais permet aussi de vérifier que la fonction fait bien ce qu'il faut
    void startCombat1() {
        attack1.startCombat(commoner);
        assertTrue(commoner.isHostile());
        assertTrue(hero.getOngoingCombat() != null);
    }

    @Test
        //test boite noire
    void startCombat2() {
        attack1.startCombat(guard);
        assertTrue(hero.getOngoingCombat() != null);
    }


    @Test
    //test boite blanche
    void attackInCombat1() {
        attack1.startCombat(guard);
        assertDoesNotThrow(() -> attack1.attackInCombat(guard));
    }

    @Test
    //test boite blanche
    void attackInCombat2() {
        attack1.startCombat(guard);
        assertThrows(NullPointerException.class,() -> attack1.attackInCombat(commoner));
    }

    /*
    attackNonPlayerCharacter ne semble pas testable en boite noire à cause des générateurs de nombres aléatoires
    dans attack de character.
    De plus, il est inutile de tester si hero.ungoingCombat est différent de null dans le cas où on attaque
    un personnage mort, car à la fin de cette méthode dans tous les cas cet attribut est null.
*/

    @Test
    void attackNonPlayerCharacter1() {
        assertThrows(NullPointerException.class,() -> attack1.attackNonPlayerCharacter(null));
    }

    @Test
    //test boite blanche
    void attackNonPlayerCharacter2() {
        assertDoesNotThrow(() -> attack1.attackNonPlayerCharacter(guard));
    }

    @Test
    //test boite blanche
    void attackNonPlayerCharacter3() {
        hero.setOngoingCombat(combat);
        assertDoesNotThrow(() -> attack2.attackNonPlayerCharacter(guard));
    }

    @Test
    void attackNonPlayerCharacter4() {
        guard.setAlive(false);
        assertDoesNotThrow(() -> attack1.attackNonPlayerCharacter(guard));
    }

    @Test
        //test boite blanche
    void launchCommand1() {
        List<String> arguments = new LinkedList<>();
        assertThrows(InvalidArgumentNumberException.class, () -> attack1.launchCommand(arguments));
    }

    @Test
    //test boite blanche
    public void launchCommand2() {
        List<String> arguments = new LinkedList<>();
        arguments.add("arg1");
        arguments.add("arg2");
        assertThrows(InvalidArgumentNumberException.class, () -> attack1.launchCommand(arguments));
    }

    @Test
    //test boite blanche
    public void launchCommand3() {
        List<String> arguments = new LinkedList<>();
        arguments.add("arg1");
        assertThrows(NullPointerException.class, () -> attack1.launchCommand(arguments));
    }

    @Test
    //test boite blanche
    public void launchCommand4() {
        List<String> arguments = new LinkedList<>();
        arguments.add(armor.getName());
        assertThrows(ClassCastException.class, () -> attack1.launchCommand(arguments));
    }

    @Test
    //test boite blanche
    public void launchCommand5() {
        List<String> arguments = new LinkedList<>();
        arguments.add(guard.getName());
        assertDoesNotThrow(() -> attack1.launchCommand(arguments));
    }

    @Test
    //test boite blanche
    public void launchCommand6() {
        List<String> arguments = new LinkedList<>();
        arguments.add(hero.getName());
        assertDoesNotThrow(() -> attack1.launchCommand(arguments));
    }

    @Test
    //test boite blanche
    public void launchCommand7() {
        List<String> arguments = new LinkedList<>();
        arguments.add(guard.getName());
        hero.setOngoingCombat(combat);
        assertDoesNotThrow(() -> attack2.launchCommand(arguments));
    }

    //il manque un test boite blanche pour tester le cas où on attaque un attaquable qui n'est pas un personnage
    //mais nous n'avons pas eu le temps d'implanter une classe remplissant ces conditions, nous voulions cependant
    //laissé cette option, dans le cas de potentiels extensions du programme.





}