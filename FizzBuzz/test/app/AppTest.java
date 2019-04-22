package app;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

    @Test
    public void shouldReturnOrigin() {
        int origin = 1;
        FizzBuzz actual = new FizzBuzz(1);
        assertEquals(String.valueOf(origin), actual.toString());
    }

}