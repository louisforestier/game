package game;

import java.util.*;

public abstract class Character {

	private static int currentId = 0;
	private int id;
	private String name;
	private Place place;
	private Map<String,Item> inventory = new HashMap<>();

	/**
	 * 
	 * @param s
	 */
	public Character(String s) {
		this.id = Character.currentId;
		this.name = s;
		this.place = null;
		this.inventory = null;
		Character.currentId++;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place p) {
		this.place = p;
	}

	public Map<String,Item> getInventory() {
		return inventory;
	}

}