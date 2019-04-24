import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @ParameterizedTest(name = "should return {0} given {1}")
    @CsvSource({
            "1, '1'",
            "2, '2'",
            "3, 'Fizz'",
            "5, 'Buzz'",
            "15, 'FizzBuzz'",
            "13, 'Fizz'",
            "52, 'Buzz'",
    })
    void testFizzBuzz(int actual, String expected) {
        assertEquals(expected, FizzBuzz.play(actual));
    }
}