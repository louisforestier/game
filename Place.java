package game;

import java.util.*;

public class Place implements Lookable {

	private static int currentId = 0;
	private final int id;
	private final String name;
	private final String description;
	private List<Door> doors = new ArrayList<>();
	private Map<String,Item> items = new HashMap<>();
	private Map<String,Character> characters = new HashMap<>();

	/**
	 * 
	 * @param name
	 * @param characters
	 * @param doors
	 * @param items
	 */
	public Place(String name, String description, Map<String, Character> characters, List<Door> doors, Map<String,Item> items) {
		this.name = name;
		this.id = Place.currentId;
		this.description = description;
		this.doors = doors;
		this.items = items;
		this.characters = characters;
		Place.currentId++;
	}

	public List<Door> getDoors() {
		return this.doors;
	}


	public void print() {
		System.out.print(this.description);
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}
	public Map<String,Character> getCharacters() {
		return characters;
	}

	public Map<String,Item> getItems() {
		return items;
	}

}