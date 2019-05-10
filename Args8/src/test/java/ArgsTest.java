import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArgsTest {
    private Rule rule;

    @BeforeEach
    void setUp() {
        this.rule = new Rule("l:bool:true;p:int:0;d:string:/logs");
    }

    @Test
    void can_parse_bool_arg() {
        Args args = new Args("-l");
        args.schema(rule);
        assertTrue(args.has("-l"));
        assertTrue(args.has("l"));
        assertEquals(true, args.get("l"));
    }

    @Test
    void can_parse_int_arg() {
        Args args = new Args("-p 8080");
        args.schema(rule);
        assertTrue(args.has("-p"));
        assertTrue(args.has("p"));
        assertEquals(8080, args.get("p"));
    }

    @Test
    void can_parse_string_arg() {
        Args args = new Args("-d /var/logs");
        args.schema(rule);
        assertTrue(args.has("-d"));
        assertTrue(args.has("d"));
        assertEquals("/var/logs", args.get("d"));
    }

    @Test
    void can_parse_multi_arg() {
        Args args = new Args("-l -p 8080 -d /var/logs");
        args.schema(rule);
        assertTrue(args.has("-l"));
        assertTrue(args.has("p"));
        assertTrue(args.has("d"));
        assertEquals(true, args.get("l"));
        assertEquals(8080, args.get("p"));
        assertEquals("/var/logs", args.get("d"));
    }
}
