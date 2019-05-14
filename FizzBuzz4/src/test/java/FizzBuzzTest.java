import org.junit.jupiter.api.Test;
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

    })
    void should_input_1_return_1(int input, String expected) {
        FizzBuzz item = new FizzBuzz(input);
        assertEquals(expected, item.toString());
    }
}
