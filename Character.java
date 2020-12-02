package game;

import java.util.*;

public abstract class Character implements Lookable{

	private final String name;
	private Place place;
	private Map<String,Item> inventory = new HashMap<>();

	
	public Character(String s) {
		this.name = s;
	}

	public String getName() {
		return this.name;
	}

	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place p) {
		if(this.place != null)
			this.freePlace();
		this.place = p;
		p.addCharacter(this.name, this);
	}

	public Map<String,Item> getInventory() {
		return inventory;
	}

	public void freePlace() {
		this.place.freeCharacter(this.name);
		this.place = null;
	}
}