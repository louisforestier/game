package game;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.Before;
import org.junit.Test;

public class ScrollTest {
	
	private Scroll scroll;
	private ContainerWithLock chest;

	@Before
	public void setUp() {
		scroll = new Scroll("scroll", "is scroll", "testok");
		Key key1 = new Key("key", "is key");
		chest = new ContainerWithLock("chest", "is chest", key1);
	}
	

	@Test
	public void use1() {
		assertDoesNotThrow(() -> scroll.use(chest));
	}
}
