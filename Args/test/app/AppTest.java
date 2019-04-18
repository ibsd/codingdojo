package app;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {
    private String[] args = "-l -p 8080 -d /usr/logs".split(" ");

    @Test
    public void parseArgsShouldReturnOptions() {
        ArgsParser parser = new ArgsParser();
        Options options = parser.parse(args);
        assertNotNull(options);
    }

    @Test
    public void shouldCheckHasSomeOption() {
        ArgsParser parser = new ArgsParser();
        Options options = parser.parse(args);
        assertTrue("has -l", options.hasOption("-l"));
        assertFalse("has -x", options.hasOption("-x"));
    }

    @Test
    public void shouldGetBoolOption() {
        ArgsParser parser = new ArgsParser();
        Options options = parser.parse(args);
        assertTrue("has -l", options.getBool("-l"));
        assertFalse("has -x", options.getBool("-x"));
    }
}