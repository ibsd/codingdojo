import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgsListTest {
    @ParameterizedTest
    @CsvSource({
            "l:bool:true, true",
            "p:int:8080, 8080",
            "'q:int:80,90', '80,90'",
            "d:string:/var/logs, /var/logs",
            "'e:string:/var,/logs', '/var,/logs'",
    })
    void can_parse_schema_item_and_return_default_value(String input, String expected) {
        ArgsItem item = new ArgsItem(input);
        assertEquals(expected, item.getDefault());
    }

    @ParameterizedTest
    @CsvSource({
            "l:bool:true;p:int:8080;d:string:/var/logs, true;8080;/var/logs",
            "'l:bool:true;p:int:80,90;d:string:/var,/logs', 'true;80,90;/var,/logs'",
    })
    void can_parse_schema_list_and_return_default_value(String input, String expected) {
        ArgsList args = new ArgsList(input);
        String[] defaultValues = expected.split(";");
        assertEquals(defaultValues[0], args.getItem("l").getDefault());
        assertEquals(defaultValues[1], args.getItem("p").getDefault());
        assertEquals(defaultValues[2], args.getItem("d").getDefault());
    }

    @ParameterizedTest
    @CsvSource({
            "-l -p 9090 -d /tmp/logs, 'true;9090;/tmp/logs'",
            "'-l -p 90,80 -d /tmp,/logs', 'true;90,80;/tmp,/logs'",
    })
    void can_parse_args_and_return_value(String input, String expected) {
        ArgsList args = new ArgsList("l:bool:false;p:int:8080;d:string:/var/logs");
        args.parse(input);
        String[] defaultValues = expected.split(";");
        assertEquals(defaultValues[0], args.getItem("l").getValue().toString());
        assertEquals(defaultValues[1], args.getItem("p").getValue().toString());
        assertEquals(defaultValues[2], args.getItem("d").getValue().toString());
    }
}
