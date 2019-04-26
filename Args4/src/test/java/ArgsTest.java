import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArgsTest {
    ArgOptions options;

    @BeforeEach
    void setUp() {
        String[][] args = {{"l", ""}, {"p", "8080"}, {"d", "/logs"}};
        String[][] schema = {{"l", "bool"}, {"p", "int"}, {"d", "string"}};
        options = Args.prase(schema, args);
    }

    @ParameterizedTest()
    @CsvSource({
            "l, true",
            "p, true",
            "d, true"
    })
    void can_check_has_option(String input, String expected) {
        assertEquals(expected.equals("true"), options.has(input));
    }

    @ParameterizedTest()
    @CsvSource({
            "l, true",
            "p, 8080",
            "d, /logs"
    })
    void can_get_value(String input, String expected) {
        assertEquals(expected, String.valueOf(options.get(input)));
    }
}