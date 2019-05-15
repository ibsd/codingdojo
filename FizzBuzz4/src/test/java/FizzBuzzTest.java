import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @ParameterizedTest(name = "should return {0} given {1}")
    @CsvSource({
            "1, 1",
            "3, Fizz",
            "5, Buzz",
            "15, FizzBuzz",
            "31, Fizz",
            "56, Buzz",
            "53, FizzBuzz",
    })
    void should_play_fizz_buzz(int input, String expected) {
        FizzBuzz item = new FizzBuzz(input);
        assertEquals(expected, item.toString());
    }
}
