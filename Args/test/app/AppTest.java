package app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AppTest {
    private String[] args = "-l -p 8080 -d /usr/logs".split(" ");
    private ArgsParser parser;
    private Options options;
    private Schema schema;

    @Before
    public void setUp() {
        schema = new Schema("-l:bool,-p:int,-d:string");
        parser = new ArgsParser(schema);
        options = parser.parse(args);
    }

    @Test
    public void parseArgsShouldReturnOptions() {
        assertNotNull(options);
    }

    @Test
    public void shouldCheckHasSomeOption() {
        assertTrue("has -l", options.hasOption("-l"));
        assertFalse("has -x", options.hasOption("-x"));
    }

    @Test
    public void shouldGetBoolOption() throws NoSuchArgsOptionException {
        assertTrue("has -l", options.getBool("-l"));
    }

    @Test(expected = NoSuchArgsOptionException.class)
    public void shouldShowExceptionIfUnkonwOption() throws NoSuchArgsOptionException {
        assertTrue("has -x", options.getBool("-x"));
    }

    @Test
    public void shouldGetIntOption() throws NoSuchArgsOptionException {
        assertEquals("has -p 8080", 8080, options.getInt("-p"));
    }

    @Test
    public void shouldGetStringOption() throws NoSuchArgsOptionException {
        assertEquals("has -d /usr/logs", "/usr/logs", options.getString("-d"));
    }
}