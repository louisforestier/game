package game;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UseTest {

    private Use use;
    private Hero hero;
    private Place p1;
    private Place p2;
    private Place p3;
    private Door d1;
    private DoorWithLock d2;
    private Key key1;
    private Key key2;

    @Before
    public void setUp() {
        key1 = new Key("key1", "testkey1");
        key2 = new Key("key2", "testkey1");
        d1 = new Door("is d1");
        d2 = new DoorWithLock(key1, "testdoor1");
        p1 = new Place("p1", "is p1", null, 0);
        p2 = new Place("p2", "is p2", null, 0);
        p3 = new Place("p3", "is p3", null, 0);
        d1.setEntrance(p1);
        d1.setExit(p2);
        d2.setEntrance(p1);
        d2.setExit(p3);
        p1.getInteractions().put(d1.getExit().getName(), d1);
        p1.getInteractions().put(d2.getExit().getName(), d2);
        p1.getInteractions().put(key2.getName(), key2);
        hero = new Hero();
        hero.setPlace(p1);
        hero.getInventory().put(key1.getName(), key1);
        use = new Use(hero);
    }

    //pour la différence entre les tests boite blanche et boire noire,
    //nous ne sommes pas sûrs du tout, le cours était assez rapide dessus,
    //donc j'ai supposé que les tests boites noires étaient ceux faisait
    //que la méthode donnait un résultat cohérent, regardant la valeur de retour
    //ou le(s) attribut(s) modifié(s)
    //pour les tests boites blanches, j'ai compté les lancements d'erreurs
    //comme des chemins étant donné que nous les utilisons, notamment pour l'affichage,
    //et car les erreurs ne sont visibles que dans le code, donc si on ne connait pas
    //le code on ne peut pas savoir si une exception est lancé

    @Test
    //test boite noire
    public void convertStringToUsable1() {
        assertSame(key1, use.convertStringToUsable(key1.getName()));
    }

    @Test
    // test boite blanche
    public void convertStringToUsable2() {
        assertThrows(ClassCastException.class, () -> use.convertStringToUsable(hero.getName()));
    }

    @Test
    // test boite blanche
    public void convertStringToUsable3() {
        assertDoesNotThrow(() -> use.convertStringToUsable("arg"));
    }

    @Test
    // test boite blanche ou noire ?
    public void convertStringToUsable4() {
        assertSame(null, use.convertStringToUsable("arg"));
    }


    @Test
    //test boite noire
    public void convertStringToReceiver1() {
        assertSame(d2, use.convertStringToReceiver(d2.getExit().getName()));
    }

    @Test
    //test boite blanche
    public void convertStringToReceiver2() {
        assertThrows(ClassCastException.class, () -> use.convertStringToReceiver(d1.getExit().getName()));
    }

    @Test
    //test boite blanche
    public void convertStringToReceiver3() {
        assertDoesNotThrow(() -> use.convertStringToReceiver("arg"));
    }

    @Test
    //test boite blanche
    public void launchCommand1() {
        List<String> arguments = new LinkedList<>();
        assertThrows(InvalidArgumentNumberException.class, () -> use.launchCommand(arguments));

    }

    @Test
    //test boite blanche
    public void launchCommand2() {
        List<String> arguments = new LinkedList<>();
        arguments.add("arg1");
        arguments.add("arg2");
        arguments.add("arg3");
        assertThrows(InvalidArgumentNumberException.class, () -> use.launchCommand(arguments));
    }

    @Test
    //test boite blanche
    public void launchCommand3() {
        List<String> arguments = new LinkedList<>();
        arguments.add("arg1");
        assertThrows(NullPointerException.class, () -> use.launchCommand(arguments));
    }

    @Test
    //test boite blanche
    public void launchCommand4() {
        List<String> arguments = new LinkedList<>();
        arguments.add(key1.getName());
        arguments.add("arg2");
        assertThrows(NullPointerException.class, () -> use.launchCommand(arguments));
    }

    @Test
    //test boite blanche
    public void launchCommand5() {
        List<String> arguments = new LinkedList<>();
        arguments.add(key1.getName());
        arguments.add(d1.getExit().getName());
        assertThrows(ClassCastException.class, () -> use.launchCommand(arguments));
    }

    @Test
    //test boite blanche
    public void launchCommand6() {
        List<String> arguments = new LinkedList<>();
        arguments.add(d1.getExit().getName());
        arguments.add(d2.getExit().getName());
        assertThrows(ClassCastException.class, () -> use.launchCommand(arguments));
    }

    @Test
    //test boite blanche
    public void launchCommand7() {
        List<String> arguments = new LinkedList<>();
        arguments.add(key2.getName());
        arguments.add(d2.getExit().getName());
        assertDoesNotThrow(() -> use.launchCommand(arguments));
    }

    @Test
    //test boite blanche
    public void launchCommand8() {
        List<String> arguments = new LinkedList<>();
        arguments.add(key1.getName());
        arguments.add(d2.getExit().getName());
        assertDoesNotThrow(() -> use.launchCommand(arguments));
    }


    @Test
    //test boite noire
    public void launchCommand9() {
        List<String> arguments = new LinkedList<>();
        arguments.add(key1.getName());
        arguments.add(d2.getExit().getName());
        use.launchCommand(arguments);
        assertFalse(d2.getIsLocked());
    }

    @Test
    //test boire noire
    public void launchCommand10() {
        List<String> arguments = new LinkedList<>();
        arguments.add(key2.getName());
        arguments.add(d2.getExit().getName());
        use.launchCommand(arguments);
        assertTrue(d2.getIsLocked());
    }


}