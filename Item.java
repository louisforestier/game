package game;

public abstract class Item {

	private static int currentId = 0;
	private int id;
	private String name;

	/**
	 * 
	 * @param name
	 */
	public Item(String name) {
		this.name = name;
		// TODO - implement game.Item.game.Item
		throw new UnsupportedOperationException();
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

}