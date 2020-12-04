package game;

import java.util.*;

public abstract class Character extends Interaction {

	private final String name;
	private Place place;
	private Map<String,Item> inventory = new HashMap<>();

	
	public Character(String name, String description) {
		super(description);
		this.name = name;
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

	public boolean isInInventory(String name) {
		return this.getInventory().containsKey(name);
	}
	
	public void printInventory() {
		System.out.println("You have :");
		this.inventory.forEach((k, v) -> {v.print();});
	}

}