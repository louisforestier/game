package game;

import java.util.*;

public class World {

    private Map<String, Place> places = new HashMap<>();

    public World() {
        String desc1 = "You are in the hall.";
        String desc2 = "You are in the guard room.";
        String desc3 = "You are in the throne room.";

        Map<String, Interaction> interactions1 = new HashMap<>();
        Map<String, Interaction> interactions2 = new HashMap<>();
        Map<String, Interaction> interactions3 = new HashMap<>();

        String keyDesc1 = "This looks like a small key, made of iron. ";
        String keyDesc2 = "This is a big old gold key. Its shine has been tarnished by time.";

        Key key1 = new Key("small_key", keyDesc1);
        Key key2 = new Key("gold_key", keyDesc2);
        
        String ChestDesc1 = "This looks like an old wooden chest. ";
        String ChestDesc2 = "This looks like a big gold chest. ";
        
        Chest chest1 = new Chest("wooden_chest", ChestDesc1);
        Chest chest2 = new ChestWithLock("golden_chest", ChestDesc1, key2);

        String unlockedDoor = ", though it doesn't appear to be locked.";
        String lockedDoor = ", though it is definitely locked.";
        String woodenDoorDesc = "This big wooden door bar your way";
        String ironDoorDesc = "This is a very sturdy iron door";

        Door d1 = new Door(woodenDoorDesc + unlockedDoor);
        Door d2 = new Door(ironDoorDesc + unlockedDoor);
        Door d3 = new DoorWithLock(key1, woodenDoorDesc + lockedDoor);
        Door d4 = new DoorWithLock(key1, woodenDoorDesc + lockedDoor);

        List<String> playerChoice1 = new ArrayList<>();
        List<String> dialogs1 = new ArrayList<>();

        playerChoice1.add("Hello.");
        playerChoice1.add("I need to find a key.");

        dialogs1.add("Hello, my name is Michel the old man.");
        dialogs1.add("You are looking for a key ? I think I saw one in the hall.");

        Dialog dialog1 = new Dialog(playerChoice1,dialogs1);

        Folk f1 = new Folk("old_man", "Just an old man", false, dialog1);
        interactions2.put(f1.getName(), f1);

        interactions1.put(key1.getName(), key1);
        interactions1.put(chest1.getName(), chest1);
        interactions2.put(chest2.getName(), chest2);
        interactions3.put(key2.getName(), key2);

        Place p1 = new Place("hall", desc1, interactions1);
        Place p2 = new Place("guard_room", desc2, interactions2);
        Place p3 = new Place("throne_room", desc3, interactions3);

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

        p1.getInteractions().put(d1.getExit().getName(), d1);

        p2.getInteractions().put(d2.getExit().getName(), d2);
        p2.getInteractions().put(d3.getExit().getName(), d3);

        p3.getInteractions().put(d4.getExit().getName(), d4);

        this.places.put(p1.getName(), p1);
        this.places.put(p2.getName(), p2);
        this.places.put(p3.getName(), p3);
    }

    public boolean isInWorld(String name) {
        return this.places.containsKey(name);
    }

    public void setStart(Hero hero) {
        hero.setPlace(places.get("hall"));
    }

}
