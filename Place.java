package game;

import game.Character;
import game.Door;
import game.Item;
import game.Lookable;

import java.util.*;

public class Place implements Lookable {

	private Collection<Door> doors;
	Collection<Item> items;
	private Collection<Character> characters;
	private static int currentId = 0;
	private int id;
	private String name;

	/**
	 * 
	 * @param name
	 * @param characters
	 * @param doors
	 * @param items
	 */
	public Place(String name, List<Character> characters, List<Door> doors, List<Item> items) {
		// TODO - implement game.Place.game.Place
		throw new UnsupportedOperationException();
	}

	public List<Door> getDoors() {
		// TODO - implement game.Place.getDoors
		throw new UnsupportedOperationException();
	}

	public List<Item> getItems() {
		// TODO - implement game.Place.getItems
		throw new UnsupportedOperationException();
	}

	public void print() {
		// TODO - implement game.Place.print
		throw new UnsupportedOperationException();
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

}