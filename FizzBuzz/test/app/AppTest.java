package app;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

    @Test
    public void shouldReturnOrigin() {
        int origin = 1;
        FizzBuzz actual = new FizzBuzz(origin);
        assertEquals(String.valueOf(origin), actual.toString());
    }

    @Test
    public void shouldReturnFizzIfDiv3() {
        int origin = 3;
        String expect = "Fizz";
        FizzBuzz actual = new FizzBuzz(origin);
        assertEquals(expect, actual.toString());
    }
}