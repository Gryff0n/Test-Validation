package exo3;

import org.junit.jupiter.api.*;
@org.junit.jupiter.api.TestInstance(TestInstance.Lifecycle.PER_CLASS)


public class BinTest  {
    BinString binString;

    @BeforeAll
    public void setUp() {
        binString = new BinString();
    }

    @Test
    public void testSumFunction() throws Exception {
        int expected = 0;
        Assertions.assertEquals(expected, binString.sum(""));
        expected = 100;
        Assertions.assertEquals(expected, binString.sum("d"));
        expected = 265;
        Assertions.assertEquals(expected, binString.sum("Add"));
    }

    @Test
    public void testBinariseFunction() {
        //String expected = "101";
        //Assertions.assertEquals(expected, binString.binarise(5));
        String expected = "11111100";
        Assertions.assertEquals(expected, binString.binarise(252));
    }

    @Test
    public void testTotalConversion() {
        String expected = "1000001";
        Assertions.assertEquals(expected, binString.convert("A"));
    }
}