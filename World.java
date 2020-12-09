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

        Map<String, Interaction> interactionsH = new HashMap<>();
        Map<String, Interaction> interactionsW = new HashMap<>();
        Map<String, Interaction> interactionsG = new HashMap<>();
        Map<String, Interaction> interactionsGr = new HashMap<>();
        Map<String, Interaction> interactionsC = new HashMap<>();
        Map<String, Interaction> interactionsT = new HashMap<>();

        //description des clefs
        String keyDesc1 = "This looks like a small key, made of iron. ";
        String keyDesc2 = "This is a big gold key. Its shine has been tarnished by time.";
        String keyDesc3 = "This looks like an heavy key, made of iron. ";
        String keyDesc4 = "This is a big old key, made of iron. ";

        //création des clefs
        Key key1 = new Key("small_key", keyDesc1);
        Key key2 = new Key("gold_key", keyDesc2);
        Key key3 = new Key("heavy_key", keyDesc3);
        Key key4 = new Key("big_key", keyDesc4);
        
        //description des coffres
        String chestDesc1 = "This looks like an old wooden chest. ";
        String chestDesc2 = "This looks like a big gold chest. ";
        
        //creation des coffres
        Container chest1 = new Container("wooden_chest", chestDesc1);
        ContainerWithLock chest2 = new ContainerWithLock("golden_chest", chestDesc2, key4);
        
        //descriptions d'objets divers
        String goldDesc1 = "There are gold_coins.";
        Gold gold1 = new Gold("gold_coins", goldDesc1);
        
        String scrollDesc1 = "This is an old tattered scroll. ";
        
        String scrollContent1 = "This scroll allows you to know the key to a door.";
        
        Scroll scroll1 = new Scroll("knock_scroll", scrollDesc1, scrollContent1);
        
        //ajout de contenus dans les coffres
        chest1.getContent().put(scroll1.getName(), scroll1);
        chest1.getContent().put(key1.getName(), key1);
        chest2.getContent().put(gold1.getName(), gold1);

        //description des portes
        String unlockedDoor = ", though it doesn't appear to be locked.";
        String lockedDoor = ", though it is definitely locked.";
        String woodenDoorDesc = "This big wooden door bar your way";
        String ironDoorDesc = "This is a very sturdy iron door";
        String goldenDoorDesc = "This is a very beautiful door with gilding";
        String heavyDoorDesc = "This is an heavy wooden door";

        //creation des portes
        Door dhg = new Door(woodenDoorDesc + unlockedDoor);
        Door dgh = new Door(woodenDoorDesc + unlockedDoor);
        
        DoorWithLock dhw = new DoorWithLock(key1, ironDoorDesc + lockedDoor);
        DoorWithLock dwh = new DoorWithLock(key1, ironDoorDesc + lockedDoor);
        
        DoorWithLock dgt = new DoorWithLock(key2, goldenDoorDesc + lockedDoor);
        DoorWithLock dtg = new DoorWithLock(key2, goldenDoorDesc + lockedDoor);
        
        Door dgc = new Door(woodenDoorDesc + unlockedDoor);
        Door dcg = new Door(woodenDoorDesc + unlockedDoor);
        
        DoorWithLock dwgr = new DoorWithLock(key1, ironDoorDesc + lockedDoor);
        DoorWithLock dgrw = new DoorWithLock(key1, ironDoorDesc + lockedDoor);
        
        Door dgrc = new Door(woodenDoorDesc + unlockedDoor);
        Door dcgr = new Door(woodenDoorDesc + unlockedDoor);
        
        DoorWithLock de = new DoorWithLock(key3, heavyDoorDesc + lockedDoor);
        

        //creation de listes pour l'interaction talk
        List<String> playerChoice1 = new ArrayList<>();
        List<String> playerChoice2 = new ArrayList<>();
        List<String> playerChoice3 = new ArrayList<>();
        List<String> dialogs1 = new ArrayList<>();
        List<String> dialogs2 = new ArrayList<>();
        List<String> dialogs3 = new ArrayList<>();

        //choix des dialogues du joueur
        playerChoice1.add("Hello.");
        playerChoice1.add("I need to find a key.");
        playerChoice2.add("Hello.");
	    playerChoice2.add("I need to find exit.");
	    playerChoice3.add("Please to meet you, your majesty.");
	    playerChoice3.add("I am an hero.");
	    playerChoice3.add("I need to find exit.");

        //choix des reponses du pnj
        dialogs1.add("Hello, my name is Michel the old man.");
        dialogs1.add("You are looking for a key ? I think I saw one in a chest of the hall and another in the throne room.");
        dialogs2.add("Hello, I am a servant.");
        dialogs2.add("You want to find the exit, go see the king.");
        dialogs3.add("Mmm...Who are you ? You killed my guards.");
        dialogs3.add("What do you want from me ?");
        dialogs3.add("You want to find the exit ! Ah ! Take this this key and go away.");

        //creation 
        Dialog dialog1 = new Dialog(playerChoice1,dialogs1);
        Dialog dialog2 = new Dialog(playerChoice2, dialogs2);
        Dialog dialog3 = new Dialog(playerChoice3, dialogs3);

        //creation d'un pnj
        Commoner oldman = new Commoner("old_man", "Just an old man",dialog1);
        interactionsH.put(oldman.getName(), oldman);
        
        Commoner servant = new Commoner("servant", "A big servant, with red noze", dialog2);
        interactionsC.put(servant.getName(), servant);
        
        King king = new King("king", "He looks much richer than you, your deduction talents tell you he's the king.", dialog3);
        interactionsT.put(king.getName(), king);

        Guard guard1 = new Guard("guard1", "A dangerous guard, armed with a spike");
        interactionsW.put(guard1.getName(), guard1);
        
        Guard guard2 = new Guard("guard2", "A tall an dangerous guard, armed with a spike");
        interactionsGr.put(guard2.getName(), guard2);
        
        Guard guard3 = new Guard("guard3", "A dangerous guard, armed with a spike");
        interactionsT.put(guard3.getName(), guard3);
        
        Guard guard4 = new Guard("guard4", "A dangerous guard, armed with a spike");
        interactionsT.put(guard4.getName(), guard4);

        String leatherArmorDesc = "The breastplate and shoulder protectors of this armor are made of leather that has been stiffened \n" +
                "by being boiled in oil. The rest of the armor is made of softer and more flexible materials.";
        LeatherArmor leatherArmor = new LeatherArmor("leather_armor", leatherArmorDesc);


        String scaleMailDesc = "This armor consists of a coat and leggings (and perhaps a separate skirt) of leather covered with \n" +
                "overlapping pieces of metal, much like the scales of a fish. The suit includes gauntlets.";
        ScaleMail scaleMail = new ScaleMail("scale_mail", scaleMailDesc);
        chest2.getContent().put(scaleMail.getName(), scaleMail);

        String plateArmorDesc = "Plate consists of shaped, interlocking metal plates to cover the entire body. A suit of plate includes\n" +
                "gauntlets, heavy leather boots, a visored helmet, and thick layers of padding underneath the armor.\n" +
                "Buckles and straps distribute the weight over the body.";
        PlateArmor plateArmor = new PlateArmor("plate_armor", plateArmorDesc);

        Dagger dagger = new Dagger("dagger", "iron dagger" );
        Sword sword = new Sword("sword", "iron sword");
        chest2.getContent().put(sword.getName(), sword);
        
        Greatsword greatsword = new Greatsword("greatsword", "iron greatsword");


        //ajout des objets (coffres, clefs) dans les pieces qui serviront d'interaction
        interactionsH.put(chest1.getName(), chest1);
        interactionsH.put(dagger.getName(), dagger);
        interactionsH.put(leatherArmor.getName(), leatherArmor);
        
        interactionsW.put(plateArmor.getName(), plateArmor);
        interactionsW.put(greatsword.getName(), greatsword);
        
        interactionsC.put(key4.getName(), key4);
        
        interactionsG.put(key2.getName(), key2);
        
        interactionsT.put(chest2.getName(), chest2);
        interactionsT.put(key3.getName(), key3);
   
        
        //coeficient d'attaque de chaque piece
        int coef1 = 50;
        int coef2 = 70;
        int coef3 = 10;
        int coef4 = 70;
        int coef5 = 12;
        int coef6 = 60;
        int coef7 = 0;

        //création des pieces
        Place hall = new Place("hall", desc1, interactionsH, coef1);
        Place weaponroom = new Place("weapon_room", desc2, interactionsW, coef2);
        Place gallery = new Place("gallery", desc3, interactionsG, coef3);
        Place guardroom = new Place("guard_room", desc4, interactionsGr, coef4);
        Place cellar = new Place("cellar", desc5, interactionsC, coef5);
        Place throneroom = new Place("throne_room", desc6, interactionsT,coef6);
        Place exit = new Place("exit", desc7, null, coef7);
        
        //creation des entrees-sorties des portes
        dhg.setEntrance(hall);
        dhg.setExit(gallery);
        dgh.setEntrance(gallery);
        dgh.setExit(hall);

        dhw.setEntrance(hall);
        dhw.setExit(weaponroom);
        dhw.setMirrorDoor(dwh);
        dwh.setEntrance(weaponroom);
        dwh.setExit(hall);
        dwh.setMirrorDoor(dhw);
        
        dgt.setEntrance(gallery);
        dgt.setExit(throneroom);
        dgt.setMirrorDoor(dtg);
        dtg.setEntrance(throneroom);
        dtg.setExit(gallery);
        dtg.setMirrorDoor(dgt);
        
        dgc.setEntrance(gallery);
        dgc.setExit(cellar);
        dcg.setEntrance(cellar);
        dcg.setExit(gallery);
        
        dwgr.setEntrance(weaponroom);
        dwgr.setExit(guardroom);
        dwgr.setMirrorDoor(dgrw);
        dgrw.setEntrance(guardroom);
        dgrw.setExit(guardroom);
        dgrw.setMirrorDoor(dwgr);
        
        dgrc.setEntrance(guardroom);
        dgrc.setExit(cellar);
        dcgr.setEntrance(cellar);
        dcgr.setExit(guardroom);
        
        de.setEntrance(throneroom);
        de.setExit(exit);

        //ajout des portes dans chaque piece
        hall.getInteractions().put(dhg.getExit().getName(), dhg);
        hall.getInteractions().put(dhw.getExit().getName(), dhw);

        weaponroom.getInteractions().put(dwh.getExit().getName(), dwh);
        weaponroom.getInteractions().put(dwgr.getExit().getName(), dwgr);

        gallery.getInteractions().put(dgh.getExit().getName(), dgh);
        gallery.getInteractions().put(dgt.getExit().getName(), dgt);
        gallery.getInteractions().put(dgc.getExit().getName(), dgc);
        
        guardroom.getInteractions().put(dgrw.getExit().getName(), dgrw);
        guardroom.getInteractions().put(dgrc.getExit().getName(), dgrc);
        
        cellar.getInteractions().put(dcgr.getExit().getName(), dcgr);
        cellar.getInteractions().put(dcg.getExit().getName(), dcg);
        
        throneroom.getInteractions().put(dtg.getExit().getName(), dtg);
        throneroom.getInteractions().put(de.getExit().getName(), de);

        //ajout des pieces dans le monde
        this.places.put(hall.getName(), hall);
        this.places.put(weaponroom.getName(), weaponroom);
        this.places.put(gallery.getName(), gallery);
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
