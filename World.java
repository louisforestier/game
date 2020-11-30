package game;

import java.util.*;

public class World {

    private Map<String,Place> Places = new HashMap<>();

    public World () {
    	String desc1 = "Bonjour il y a un certain nombre de piece dans ce monde.";
        
        Map<String, Lookable> interactions = new HashMap<>();
        Key key = new Key("key");
        Door d1 = new Door();
        Door d2 = new Door();
        interactions.put(key.getName(),key);
        
        Place p1 = new Place("start", desc1, interactions);
        Place p2 = new Place("end", desc1, null);
        
        d1.setEntrance(p1);
        d1.setExit(p2);
        d2.setEntrance(p2);
        d2.setExit(p1);
        
        p1.getInteractions().put(d1.getExit().getName(), d1);
        
        p2.getInteractions().put(d2.getExit().getName(), d2);
        
        this.Places.put(p1.getName(), p1);
        this.Places.put(p2.getName(), p2);
    }

    public boolean isInWorld(String name){
        return this.Places.containsKey(name);
    }

    public void setStart(Hero hero){
        hero.setPlace(Places.get("start"));
    }

}
