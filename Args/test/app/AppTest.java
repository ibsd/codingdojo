package app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AppTest {
    private String[] args = "-l -p 8080 -d /usr/logs".split(" ");
    private ArgsParser parser;
    private Options options;

    @Before
    public void setUp() {
        parser = new ArgsParser();
        options = parser.parse(args);
    }

    @Test
    public void parseArgsShouldReturnOptions() {
        assertNotNull(this.options);
    }

    @Test
    public void shouldCheckHasSomeOption() {
        assertTrue("has -l", options.hasOption("-l"));
        assertFalse("has -x", options.hasOption("-x"));
    }

    @Test
    public void shouldGetBoolOption() {
        assertTrue("has -l", options.getBool("-l"));
        assertFalse("has -x", options.getBool("-x"));
    }
}