package game;

import java.util.*;

public class World {

    private Map<String,Place> Places = new HashMap<>();

    public World (){
        Map<String, Item> items = new HashMap<>();
        Key key = new Key("key");
        items.put(key.getName(),key);

        Map<String, Character> characters = new HashMap<>();

        List<Door> doors = new ArrayList<>();

        String desc1 = "Bonjour il y a un certain nombre de piece dans ce monde.";

        Place p = new Place("start", desc1,characters, doors, items);
        this.Places.put(p.getName(), p);
    }

    public Map<String, Place> getPlaces() {
        return Places;
    }
}
