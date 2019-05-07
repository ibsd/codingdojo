import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArgsTest {
    @Test
    void should_test_work() {
        assertEquals(1, 1);
    }

    @Test
    void parse_args_l() throws NoSuchArgsOptionException, NoSuchArgsParamException {
        Args args = new Args("-l");
        assertTrue(args.hasOption("l"));
        assertEquals(Boolean.class, args.getValue("l").getClass());
        assertEquals(args.getValue("l"), Boolean.TRUE);
    }

    @Test
    void parse_args_no_l() {
        Args args = new Args("-?");
        assertThrows(NoSuchArgsOptionException.class, () -> args.hasOption("l"));
    }

    @Test
    void parse_args_p_8080() throws NoSuchArgsOptionException, NoSuchArgsParamException {
        Args args = new Args("-p 8080");
        assertTrue(args.hasOption("p"));
        assertEquals(Integer.class, args.getValue("p").getClass());
        assertEquals(args.getValue("p"), 8080);
    }

    @Test
    void parse_args_d_var_logs() throws NoSuchArgsOptionException, NoSuchArgsParamException {
        Args args = new Args("-d /var/logs");
        assertTrue(args.hasOption("d"));
        assertEquals(String.class, args.getValue("d").getClass());
        assertEquals(args.getValue("d"), "/var/logs");
    }

    @Test
    void parse_args_l_p_d() throws NoSuchArgsOptionException, NoSuchArgsParamException {
        Args args = new Args("-l -p 8080 -d /var/logs");
        assertEquals(args.getValue("l"), Boolean.TRUE);
        assertEquals(args.getValue("p"), 8080);
        assertEquals(args.getValue("d"), "/var/logs");
    }
}
