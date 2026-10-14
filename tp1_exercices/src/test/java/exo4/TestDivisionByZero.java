package exo4;

import exo3.BinString;
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestDivisionByZero {
    BinString binString;

    @Test
    void testMainDivisionByZero1() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        DivisionByZero.main(new String[]{"5"});
        Assertions.assertEquals("i = 10", outContent.toString().trim());
        System.setOut(originalOut);
    }

    @Test
    public void testMainDivisionByZero2() {
        Exception exc = Assertions.assertThrows(ArithmeticException.class, () -> {
            PrintStream originalOut = System.out;
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            DivisionByZero.main(new String[]{});
            Assertions.assertEquals("i = 10", outContent.toString().trim());
            System.setOut(originalOut);
        });
        Assertions.assertEquals("nb arguments null", exc.getMessage());
    }
}
