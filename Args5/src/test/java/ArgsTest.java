import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgsTest {
    @ParameterizedTest()
    @CsvSource({
            "l:bool:true, true",
            "p:int:8080, 8080",
            "d:string:/var/logs, /var/logs",
    })
    void can_parse_schema_and_return_default_value(String input, String expected) {
        ArgItem arg = new ArgItem(input);
        assertEquals(expected, arg.toString());
    }

    @ParameterizedTest()
    @CsvSource({
            "-l, l:bool:true",
            "-p 8080, p:int:8080",
            "-d /var/logs, d:string:/var/logs",
    })
    void can_parse_args_and_return_actual_value(String input, String expected) {
        ArgItem arg = new ArgItem(expected);
        arg.parse(input);
        assertEquals(arg.defaultValue(), arg.toString());
    }

    @Test
    void can_parse_args() {
        Args args = new Args("l:bool:true,p:int:0,d:string:/var/logs", "-l -p 8080 -d /usr/logs");
        assertEquals("true", args.getItem("l").toString());
        assertEquals(true, args.getItem("l").getValue());
        assertEquals("8080", args.getItem("p").toString());
        assertEquals(8080, args.getItem("p").getValue());
        assertEquals("/usr/logs", args.getItem("d").toString());
        assertEquals("/usr/logs", args.getItem("d").getValue());
    }
}
