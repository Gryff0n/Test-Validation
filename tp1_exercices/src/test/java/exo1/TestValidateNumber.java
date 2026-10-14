package exo1;

import org.junit.jupiter.api.*;

public class TestValidateNumber {

    @Test
    public void testValidateNumber1() {
        Boolean expected = true;
        Assertions.assertEquals(expected, PrimeNumber.validateNumber(3));
    }


    @Test
    public void testValidateNumber2() {
            Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> PrimeNumber.validateNumber(-3));
            Assertions.assertEquals("negative numbers", e.getMessage());
    }

    @Test
    public void testValidateNumber3() {
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> PrimeNumber.validateNumber(0));
        Assertions.assertEquals("zero", e.getMessage());
    }

    @Test
    public void testValidateNumber4() {
        Boolean expected = false;
        Assertions.assertEquals(expected, PrimeNumber.validateNumber(4));
    }


}
