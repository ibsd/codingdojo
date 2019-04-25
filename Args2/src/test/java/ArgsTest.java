import org.junit.Assert;
import org.junit.Test;

public class ArgsTest {
    private Args setUp() {
        String args = "-l -p 8080 -d /usr/logs";
        String schema = "l:bool,p:int,d:string";
        return new Args(schema, args);
    }

    @Test
    public void should_has_option_l_p_d() {
        Args args = setUp();
        Assert.assertEquals(true, args.hasOption("l"));
        Assert.assertEquals(true, args.hasOption("p"));
        Assert.assertEquals(true, args.hasOption("d"));
    }

    @Test
    public void should_get_option_value() {
        Args args = setUp();
        Assert.assertEquals(true, args.getBool("l"));
        Assert.assertEquals(8080, args.getInt("p"));
        Assert.assertEquals("/usr/logs", args.getString("d"));
    }
}
