package exo2;
import org.junit.jupiter.api.*;

public class TestIntegerOp {

    @Test
    public void testIntegerOp() {
        IntegerOp expected = new IntegerOp(2);
        Assertions.assertNotEquals(null, expected );
        Assertions.assertEquals(2, expected.getE());
    }

    @Test
    public void testTwice() {
        IntegerOp one = new IntegerOp(1);
        one.twice();
        Assertions.assertEquals(2, one.getE());
    }

    @Test
    public void testTwice0() {
        IntegerOp one = new IntegerOp(0);
        one.twice();
        Assertions.assertEquals(0, one.getE());
    }

    @Test
    public void testHalf() {
        IntegerOp one = new IntegerOp(3);
        one.half();
        Assertions.assertEquals(1, one.getE());
    }


}
