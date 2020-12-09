package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KeyTest {
    
    private Key k1;
    private Receiver r1;

   
    @BeforeEach
    public void SetUp(){
        String name = "key_one";
        String description = "that's the key_one";
        k1 = new Key(name, description);
        r1 = new DoorWithLock(k1,"door");
    }

    @Test
    public void getName() {
        assertEquals(k1.getName(), "key_one");
    }

    @Test
    public void isTakable() {
        assertTrue(k1.isTakable());
    }

    @Test
    public void use_Receiver() {
        assertDoesNotThrow(() -> k1.use(r1));
    }
    
}
