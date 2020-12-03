package game;

import java.util.*;

public class World {

    private Map<String,Place> places = new HashMap<>();

    public World () {
    	String desc1 = "You are in the hall, there is a door and a key.";
        String desc2 = "You are in the guard room, there are two doors.";
        String desc3 = "You are in the throne room, there is a door and a key.";

        Map<String, Lookable> interactions1 = new HashMap<>();
        Map<String, Lookable> interactions2 = new HashMap<>();
        Map<String, Lookable> interactions3 = new HashMap<>();
        
        Key key1 = new Key("small key");
        Key key2 = new Key("gold key");
        
        Door d1 = new Door();
        Door d2 = new Door();
        Door d3 = new DoorWithLock(key1);
        Door d4 = new DoorWithLock(key1);
        
        interactions1.put(key1.getName(),key1);
        interactions3.put(key2.getName(),key2);
        
        Place p1 = new Place("hall", desc1, interactions1);
        Place p2 = new Place("guard room", desc2, interactions2);
        Place p3 = new Place("throne room", desc3, interactions3);
        
        d1.setEntrance(p1);
        d1.setExit(p2);
        d2.setEntrance(p2);
        d2.setExit(p1);
        
        d3.setEntrance(p2);
        d3.setExit(p3);
        d4.setEntrance(p3);
        d4.setExit(p2);
        
        p1.getInteractions().put(d1.getExit().getName(), d1);
        
        p2.getInteractions().put(d2.getExit().getName(), d2);
        p2.getInteractions().put(d3.getExit().getName(), d3);
        
        p3.getInteractions().put(d4.getExit().getName(), d4);
        
        this.places.put(p1.getName(), p1);
        this.places.put(p2.getName(), p2);
        this.places.put(p3.getName(), p3);
    }

    public boolean isInWorld(String name){
        return this.places.containsKey(name);
    }

    public void setStart(Hero hero){
        hero.setPlace(places.get("start"));
    }

}
