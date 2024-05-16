import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BackendTests {

    @Test
    public void testBackendInteger(){
        Backend backend = new Backend();
        System.out.println("\n\n5 X 6");
        assertEquals(30, Double.valueOf(backend.compute("5 X 6")));
        //add more for addition, subtraction, division of integers
    }

    @Test 
    public void testBackendDouble(){
        Backend backend = new Backend();
        System.out.println("\n\n2.5 / 5");
        assertEquals(0.5, Double.valueOf(backend.compute("2.5 / 5")));
        assertEquals(44.8, Double.valueOf(backend.compute("0.8 X 56")));
        assertEquals(0.008, Double.valueOf(backend.compute("0.08 / 10")));
    }

    @Test 
    public void testBackendMultipleOperations(){
        Backend backend = new Backend();
        System.out.println("\n\n2.5 / 0.5 X 3 + 2 - 5");
        assertEquals(12.0, Double.valueOf(backend.compute("2.5 / 0.5 X 3 + 2 - 5")));
        //add more longer sequences, with both doubles and integers
    }

    @Test 
    public void testDecimalErrors(){
        Backend backend = new Backend();
        System.out.println("\n\n0.08 / 12");
        assertEquals(0.006667, Double.valueOf(backend.compute("0.08 / 12")));
    }
}
