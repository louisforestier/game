package game;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.Before;
import org.junit.Test;

public class ScrollTest {
	
	private Scroll scroll;
	private ContainerWithLock chest;
	private Key key1;
	
	@Before
	public void setUp() {
		scroll = new Scroll("scroll", "is scroll", "testok");
		key1 = new Key("key", "is key");
		chest = new ContainerWithLock("chest", "is chest", key1);
	}
	

	@Test
	public void use1() {
		assertDoesNotThrow(() -> scroll.use(chest));
	}
}
