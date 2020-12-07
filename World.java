package game;

import java.util.*;

public class World {

    private Map<String, Place> places = new HashMap<>();

    public World() {
        //description des pieces
        String desc1 = "You are in the hall.";
        String desc2 = "You are in the weapon room.";
        String desc3 = "You are in the gallery.";
        String desc4 = "You are in the guard room.";
        String desc5 = "You are in the cellar.";
        String desc6 = "You are in the throne room, but the kind is not here.";
        String desc7 = "You are outside.";

        Map<String, Interaction> interactions1 = new HashMap<>();
        Map<String, Interaction> interactions2 = new HashMap<>();
        Map<String, Interaction> interactions3 = new HashMap<>();
        Map<String, Interaction> interactions4 = new HashMap<>();
        Map<String, Interaction> interactions5 = new HashMap<>();
        Map<String, Interaction> interactions6 = new HashMap<>();

        //description des clefs
        String keyDesc1 = "This looks like a small key, made of iron. ";
        String keyDesc2 = "This is a big old gold key. Its shine has been tarnished by time.";
        String keyDesc3 = "This looks like an heavy key, made of iron. ";

        //création des clefs
        Key key1 = new Key("small_key", keyDesc1);
        Key key2 = new Key("gold_key", keyDesc2);
        Key key3 = new Key("heavy_key", keyDesc3);
        
        //description des coffres
        String chestDesc1 = "This looks like an old wooden chest. ";
        String chestDesc2 = "This looks like a big gold chest. ";
        
        //creation des coffres
        Container chest1 = new Container("wooden_chest", chestDesc1);
        ContainerWithLock chest2 = new ContainerWithLock("golden_chest", chestDesc2, key2);
        
        //descriptions d'objets divers
        String goldDesc1 = "There are gold_coins.";
        Gold gold1 = new Gold("gold_coins", goldDesc1);
        
        String scrollDesc1 = "This is an old tattered scroll. ";
        
        String scrollContent1 = "This scroll allows you to know the key to a door.";
        
        Scroll scroll1 = new Scroll("knock_scroll", scrollDesc1, scrollContent1);
        
        //ajout de contenus dans les coffres
        chest1.getContent().put(scroll1.getName(), scroll1);
        chest2.getContent().put(gold1.getName(), gold1);

        //description des portes
        String unlockedDoor = ", though it doesn't appear to be locked.";
        String lockedDoor = ", though it is definitely locked.";
        String woodenDoorDesc = "This big wooden door bar your way";
        String ironDoorDesc = "This is a very sturdy iron door";
        String goldenDoorDesc = "This is a very beautiful door with gilding";
        String heavyDoorDesc = "This is an heavy wooden door";

        //creation des portes
        Door d1 = new Door(woodenDoorDesc + unlockedDoor);
        Door d2 = new Door(woodenDoorDesc + unlockedDoor);
        
        DoorWithLock d3 = new DoorWithLock(key1, ironDoorDesc + lockedDoor);
        DoorWithLock d4 = new DoorWithLock(key1, ironDoorDesc + lockedDoor);
        
        DoorWithLock d5 = new DoorWithLock(key2, goldenDoorDesc + lockedDoor);
        DoorWithLock d6 = new DoorWithLock(key2, goldenDoorDesc + lockedDoor);
        
        Door d7 = new Door(woodenDoorDesc + unlockedDoor);
        Door d8 = new Door(woodenDoorDesc + unlockedDoor);
        
        DoorWithLock d9 = new DoorWithLock(key1, ironDoorDesc + lockedDoor);
        DoorWithLock d10 = new DoorWithLock(key1, ironDoorDesc + lockedDoor);
        
        Door d11 = new Door(woodenDoorDesc + unlockedDoor);
        Door d12 = new Door(woodenDoorDesc + unlockedDoor);
        
        DoorWithLock d13 = new DoorWithLock(key3, heavyDoorDesc + lockedDoor);
        

        //creation de listes pour l'interaction talk
        List<String> playerChoice1 = new ArrayList<>();
        List<String> dialogs1 = new ArrayList<>();

        //choix des dialogues du joueur
        playerChoice1.add("Hello.");
        playerChoice1.add("I need to find a key.");

        //choix des reponses du pnj
        dialogs1.add("Hello, my name is Michel the old man.");
        dialogs1.add("You are looking for a key ? I think I saw one in the hall and another in the throne room.");

        //creation 
        Dialog dialog1 = new Dialog(playerChoice1,dialogs1);

        //creation d'un pnj
        Commoner oldman = new Commoner("old_man", "Just an old man",dialog1);
        interactions2.put(oldman.getName(), oldman);

        Guard guard = new Guard("guard", "A dangerous guard, armed with a spike");
        interactions3.put(guard.getName(), guard);

        String leatherArmorDesc = "The breastplate and shoulder protectors of this armor are made of leather that has been stiffened \n" +
                "by being boiled in oil. The rest of the armor is made of softer and more flexible materials.";
        LeatherArmor leatherArmor = new LeatherArmor("leather_armor", leatherArmorDesc);


        String scaleMailDesc = "This armor consists of a coat and leggings (and perhaps a separate skirt) of leather covered with \n" +
                "overlapping pieces of metal, much like the scales of a fish. The suit includes gauntlets.";
        ScaleMail scaleMail = new ScaleMail("scale_mail", scaleMailDesc);

        String plateArmorDesc = "Plate consists of shaped, interlocking metal plates to cover the entire body. A suit of plate includes\n" +
                "gauntlets, heavy leather boots, a visored helmet, and thick layers of padding underneath the armor.\n" +
                "Buckles and straps distribute the weight over the body.";
        PlateArmor plateArmor = new PlateArmor("plate_armor", plateArmorDesc);

        Dagger dagger = new Dagger("dagger", "iron dagger" );
        Sword sword = new Sword("sword", "iron sword");
        //Greatsword greatsword = new Greatsword("greatsword", "iron greatsword");


        //ajout des objets (coffres, clefs) dans les pieces qui serviront d'interaction
        interactions1.put(key1.getName(), key1);
        interactions1.put(chest1.getName(), chest1);
        interactions2.put(chest2.getName(), chest2);
        interactions3.put(key2.getName(), key2);
        interactions6.put(key3.getName(), key3);

        interactions1.put(dagger.getName(), dagger);
        interactions1.put(leatherArmor.getName(), leatherArmor);
        chest2.getContent().put(sword.getName(), sword);
        chest2.getContent().put(scaleMail.getName(), scaleMail);
        interactions3.put(plateArmor.getName(), plateArmor);
        //interactions3.put(greatsword.getName(), greatsword);
        
        //coeficient d'attaque de chaque piece
        int coef1 = 50;
        int coef2 = 80;
        int coef3 = 10;
        int coef4 = 90;
        int coef5 = 12;
        int coef6 = 60;
        int coef7 = 0;

        //création des pieces
        Place p1 = new Place("hall", desc1, interactions1, coef1);
        Place p2 = new Place("weapon_room", desc2, interactions2, coef2);
        Place p3 = new Place("gallery", desc3, interactions3, coef3);
        Place p4 = new Place("guard_room", desc4, interactions4, coef4);
        Place p5 = new Place("cellar", desc5, interactions5, coef5);
        Place p6 = new Place("throne_room", desc6, interactions6,coef6);
        Place p7 = new Place("exit", desc7, null, coef7);
        
        //creation des entrees-sorties des portes
        d1.setEntrance(p1);
        d1.setExit(p3);
        d2.setEntrance(p3);
        d2.setExit(p1);

        d3.setEntrance(p1);
        d3.setExit(p2);
        d3.setMirrorDoor(d4);
        d4.setEntrance(p2);
        d4.setExit(p1);
        d4.setMirrorDoor(d3);
        
        d5.setEntrance(p3);
        d5.setExit(p6);
        d5.setMirrorDoor(d6);
        d6.setEntrance(p6);
        d6.setExit(p3);
        d6.setMirrorDoor(d5);
        
        d7.setEntrance(p3);
        d7.setExit(p5);
        d8.setEntrance(p5);
        d8.setExit(p3);
        
        d9.setEntrance(p2);
        d9.setExit(p4);
        d9.setMirrorDoor(d10);
        d10.setEntrance(p4);
        d10.setExit(p4);
        d10.setMirrorDoor(d9);
        
        d11.setEntrance(p4);
        d11.setExit(p5);
        d12.setEntrance(p5);
        d12.setExit(p4);
        
        d13.setEntrance(p6);
        d13.setExit(p7);

        //ajout des portes dans chaque piece
        p1.getInteractions().put(d1.getExit().getName(), d1);
        p1.getInteractions().put(d3.getExit().getName(), d3);

        p2.getInteractions().put(d4.getExit().getName(), d4);
        p2.getInteractions().put(d9.getExit().getName(), d9);

        p3.getInteractions().put(d2.getExit().getName(), d2);
        p3.getInteractions().put(d5.getExit().getName(), d5);
        
        p4.getInteractions().put(d10.getExit().getName(), d10);
        p4.getInteractions().put(d11.getExit().getName(), d11);
        
        p5.getInteractions().put(d12.getExit().getName(), d12);
        p5.getInteractions().put(d8.getExit().getName(), d8);
        
        p6.getInteractions().put(d6.getExit().getName(), d6);
        p6.getInteractions().put(d13.getExit().getName(), d13);

        //ajout des pieces dans le monde
        this.places.put(p1.getName(), p1);
        this.places.put(p2.getName(), p2);
        this.places.put(p3.getName(), p3);
    }

    //
    public boolean isInWorld(String name) {
        return this.places.containsKey(name);
    }

    //place le joueur dans une piece pour le debut du jeu
    public void setStart(Hero hero) {
        hero.setPlace(places.get("hall"));
    }

}
