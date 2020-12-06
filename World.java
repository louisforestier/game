package game;

import java.util.*;

public class World {

    private Map<String, Place> places = new HashMap<>();

    public World() {
        //description des pieces
        String desc1 = "You are in the hall.";
        String desc2 = "You are in the guard room.";
        String desc3 = "You are in the throne room.";

        Map<String, Interaction> interactions1 = new HashMap<>();
        Map<String, Interaction> interactions2 = new HashMap<>();
        Map<String, Interaction> interactions3 = new HashMap<>();

        //description des clefs
        String keyDesc1 = "This looks like a small key, made of iron. ";
        String keyDesc2 = "This is a big old gold key. Its shine has been tarnished by time.";

        //création des clefs
        Key key1 = new Key("small_key", keyDesc1);
        Key key2 = new Key("gold_key", keyDesc2);
        
        //description des coffres
        String chestDesc1 = "This looks like an old wooden chest. ";
        String chestDesc2 = "This looks like a big gold chest. ";
        
        //creation des coffres
        Container chest1 = new Container("wooden_chest", chestDesc1);
        ChestWithLock chest2 = new ChestWithLock("golden_chest", chestDesc2, key2);
        
        //descriptions d'objets divers
        String goldDesc1 = "There are gold_coins.";
        Gold gold1 = new Gold("gold_coins", goldDesc1);
        
        String scrollDesc1 = "This is an old tattered scroll. ";
        
        String scrollContenu1 = "This scroll allows you to know the key to a door.";
        
        Scroll scroll1 = new Scroll("knock_scroll", scrollDesc1, scrollContenu1);
        
        //ajout de contenus dans les coffres
        chest1.getContent().put(scroll1.getName(), scroll1);
        chest2.getContent().put(gold1.getName(), gold1);

        //description des portes
        String unlockedDoor = ", though it doesn't appear to be locked.";
        String lockedDoor = ", though it is definitely locked.";
        String woodenDoorDesc = "This big wooden door bar your way";
        String ironDoorDesc = "This is a very sturdy iron door";

        //creation des portes
        Door d1 = new Door(woodenDoorDesc + unlockedDoor);
        Door d2 = new Door(ironDoorDesc + unlockedDoor);
        DoorWithLock d3 = new DoorWithLock(key1, woodenDoorDesc + lockedDoor);
        DoorWithLock d4 = new DoorWithLock(key1, woodenDoorDesc + lockedDoor);

        //creation de listes pour l'interaction talk
        List<String> playerChoice1 = new ArrayList<>();
        List<String> dialogs1 = new ArrayList<>();

        //choix des dialogues du joueur
        playerChoice1.add("Hello.");
        playerChoice1.add("I need to find a key.");

        //choix des reponses du pnj
        dialogs1.add("Hello, my name is Michel the old man.");
        dialogs1.add("You are looking for a key ? I think I saw one in the hall.");

        //creation 
        Dialog dialog1 = new Dialog(playerChoice1,dialogs1);

        //creation d'un pnj
        Folk f1 = new Folk("old_man", "Just an old man", false, dialog1);
        interactions2.put(f1.getName(), f1);

        //ajout des objets (coffres, clefs) dans les pieces qui serviront d'interaction
        interactions1.put(key1.getName(), key1);
        interactions1.put(chest1.getName(), chest1);
        interactions2.put(chest2.getName(), chest2);
        interactions3.put(key2.getName(), key2);

        //création des pieces
        Place p1 = new Place("hall", desc1, interactions1);
        Place p2 = new Place("guard_room", desc2, interactions2);
        Place p3 = new Place("throne_room", desc3, interactions3);

        //creation des entrees-sorties des portes
        d1.setEntrance(p1);
        d1.setExit(p2);
        d2.setEntrance(p2);
        d2.setExit(p1);

        d3.setEntrance(p2);
        d3.setExit(p3);
        d3.setMirrorDoor(d4);
        d4.setEntrance(p3);
        d4.setExit(p2);
        d4.setMirrorDoor(d3);

        //ajout des portes dans chaque piece
        p1.getInteractions().put(d1.getExit().getName(), d1);

        p2.getInteractions().put(d2.getExit().getName(), d2);
        p2.getInteractions().put(d3.getExit().getName(), d3);

        p3.getInteractions().put(d4.getExit().getName(), d4);

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
