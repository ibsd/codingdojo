package app;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

    private void testEqual(int origin, String expect) {
        FizzBuzz actual = new FizzBuzz(origin);
        assertEquals(expect, actual.toString());
    }

    @Test
    public void shouldReturnOrigin() {
        testEqual(1, "1");
        testEqual(2, "2");
    }

    @Test
    public void shouldReturnFizzIfDiv3() {
        testEqual(3, "Fizz");
    }

    @Test
    public void shouldReturnBuzzIfDiv5() {
        testEqual(5, "Buzz");
    }

    @Test
    public void shouldReturnFizzBuzzIfDiv3and5() {
        testEqual(15, "FizzBuzz");
    }

    @Test
    public void shouldReturnFizzIfHas3() {
        testEqual(13, "Fizz");
    }

    @Test
    public void shouldReturnBuzzIfHas5() {
        testEqual(52, "Buzz");
    }
}