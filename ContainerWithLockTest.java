package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerWithLockTest {
	private ContainerWithLock chest;
    private Book book;
    private Key key;

    @BeforeEach
    public void setUp(){
    	key = new Key("key", "is key");
    	chest = new ContainerWithLock("chest", "is chest",key);
    	book = new Book("book", "is book", "oui");
    }
    
    @Test
	//test fonctionnel
	public void unlock() {
		assertFalse(chest.unlock(key));
	}

	@Test
	//test fonctionnel
	public void lock() {
		assertTrue(chest.lock(key));
	}
	
	@Test
	//test fonctionnel
	public void receiveForKey() {
		chest.receiveForKey(key);
    	assertFalse(chest.getIsLocked());
	}
	
	@Test
	//test fonctionnel
	public void receive1(){
		assertThrows(ClassCastException.class, () -> chest.receive(book));
    }
	
	@Test
	//test fonctionnel
	public void receive2(){
		assertDoesNotThrow(() -> chest.receive(key));
    }


/*
    les test de addItem et removeItem sont fonctionnels mais ils correspondent aussi aux tests structurels,
  	on passe par toutes les décisions.
*/

	@Test
	//test fonctionnel
	public void addItem1() {
		chest.unlock(key);
		chest.addItem("book", book);
		assertFalse(chest.getContent().isEmpty());
	}
	
	@Test
	//test fonctionnel
	public void addItem2() {
		chest.addItem("book", book);
		assertTrue(chest.getContent().isEmpty());
	}
	
	@Test
	//test fonctionnel
	public void removeItem1() {
		chest.unlock(key);
		chest.addItem("book", book);
		chest.removeItem("book");
		assertTrue(chest.getContent().isEmpty());
	}
	
	@Test
	//test fonctionnel
	public void removeItem2() {
		chest.unlock(key);
		chest.addItem("book", book);
		chest.lock(key);
		chest.removeItem("book");
		assertFalse(chest.getContent().isEmpty());
	}
	
	

}
