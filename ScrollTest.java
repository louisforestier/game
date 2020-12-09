package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScrollTest {
	
	private Scroll scroll;
	private ContainerWithLock chest;

	@BeforeEach
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
