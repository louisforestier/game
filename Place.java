package game;

import game.Character;
import game.Door;
import game.Item;
import game.Lookable;

import java.util.*;

public class Place implements Lookable {

	private static int currentId = 0;
	private final int id;
	private final String name;
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
	public Place(String name, Map<String, Character> characters, List<Door> doors, Map<String,Item> items) {
		this.name = name;
		this.id = Place.currentId;
		this.doors = doors;
		this.items = items;
		this.characters = characters;

		// TODO - implement game.Place.game.Place
		//throw new UnsupportedOperationException();
	}

	public List<Door> getDoors() {
		// TODO - implement game.Place.getDoors
		//throw new UnsupportedOperationException();
		return this.doors;
	}


	public void print() {
		// TODO - implement game.Place.print
		//throw new UnsupportedOperationException();
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