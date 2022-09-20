import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleValidatorTest {
    private TriangleValidator triangleValidator = new TriangleValidator();

    @Test
    void testInputShortArrayReturnFalse(){
        boolean returnedValue = triangleValidator.validateTriangle(new int[]{1,2});
        assertFalse(returnedValue);
    }

    @Test
    void testInputLongArrayReturnFalse(){
        boolean returnedValue = triangleValidator.validateTriangle(new int[]{2,2,2,2});
        assertFalse(returnedValue);
    }

//    @Test
//    void testNegativeSideReturnFalse(){
//        boolean returnedValue = triangleValidator.validateTriangle(new int[]{2,-2, 2});
//        assertFalse(returnedValue);
//    }
    //matematikailag nem külön eset

    @Test
    void testZeroSideReturnFalse(){
        boolean returnedValue = triangleValidator.validateTriangle(new int[]{2, 0, 2});
        assertFalse(returnedValue);
    }

    @Test
    void testValidTriangleReturnTrue(){
        boolean returnedValue = triangleValidator.validateTriangle(new int[]{3, 4, 5});
        assertTrue(returnedValue);
    }

    @Test
    void testCsideInvalidReturnFalse(){
        boolean returnedValue = triangleValidator.validateTriangle(new int[]{3, 4, 9});
        assertFalse(returnedValue);
    }

    @Test
    void testBsideInvalidReturnFalse(){
        boolean returnedValue = triangleValidator.validateTriangle(new int[]{3, 9, 4});
        assertFalse(returnedValue);
    }

    @Test
    void testAsideInvalidReturnFalse(){
        boolean returnedValue = triangleValidator.validateTriangle(new int[]{9, 3, 4});
        assertFalse(returnedValue);
    }
}