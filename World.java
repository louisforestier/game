package game;

import java.util.*;

public class World {

    private Map<String,Place> Places = new HashMap<>();

    public World (){
        Place p = new Place("start", null, null,null);
        this.Places.put(p.getName(), p);
    }

    public Map<String, Place> getPlaces() {
        return Places;
    }
}
