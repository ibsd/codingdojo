import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgsTest {
    @ParameterizedTest
    @CsvSource({
            "l:bool:true, true",
            "p:int:8080, 8080",
            "'q:int:80,90', '80,90'",
            "d:string:/var/logs, /var/logs",
            "'e:string:/var,/logs', '/var,/logs'",
    })
    void can_parse_schema_item_and_return_default_value(String input, String expected) {
        ArgItem item = new ArgItem(input);
        assertEquals(expected, item.defaultValue());
    }

    @ParameterizedTest
    @CsvSource({
            "l:bool:true;p:int:8080;d:string:/var/logs, true;8080;/var/logs",
            "'l:bool:true;p:int:80,90;d:string:/var,/logs', 'true;80,90;/var,/logs'",
    })
    void can_parse_schema_list_and_return_default_value(String input, String expected) {
        Args args = new Args(input);
        String[] defaultValues = expected.split(";");
        assertEquals(defaultValues[0], args.getItem("l").defaultValue());
        assertEquals(defaultValues[1], args.getItem("p").defaultValue());
        assertEquals(defaultValues[2], args.getItem("d").defaultValue());
    }

    @ParameterizedTest
    @CsvSource({
            "-l -p 9090 -d /tmp/logs, 'true;9090;/tmp/logs'",
            "'-l -p 90,80 -d /tmp,/logs', 'true;90,80;/tmp,/logs'",
    })
    void can_parse_args_and_return_value(String input, String expected) {
        Args args = new Args("l:bool:false;p:int:8080;d:string:/var/logs");
        args.parse(input);
        String[] defaultValues = expected.split(";");
        assertEquals(defaultValues[0], args.getItem("l").getValue().toString());
        assertEquals(defaultValues[1], args.getItem("p").getValue().toString());
        assertEquals(defaultValues[2], args.getItem("d").getValue().toString());
    }
}
