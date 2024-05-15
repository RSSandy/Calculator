import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BackendTests {

    @Test
    public void testBackendInteger(){
        Backend backend = new Backend();
        assertEquals(backend.compute("5 X 6"), "30");
        //add more for addition, subtraction, division of integers
    }

    @Test 
    public void testBackendDouble(){
        Backend backend = new Backend();
        assertEquals(backend.compute("2.5 / 5"), "0.5");
        //add more for add, sub, mult of doubles 
    }

    @Test 
    public void testBackendMultipleOperations(){
        Backend backend = new Backend();
        assertEquals(backend.compute("2.5 / 0.5 * 3 + 2"), "30");
        //add more longer sequences, with both doubles and integers
    }
}
