package game;

public enum Direction {
	N(0),
	S(1),
	E(2),
	O(3);

	private final int value;

	Direction(int i) {
		this.value = i;
	}

	public int getValue() {
		return value;
	}
}