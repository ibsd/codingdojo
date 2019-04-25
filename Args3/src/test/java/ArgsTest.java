import org.junit.Assert;
import org.junit.Test;

public class ArgsTest {

    private Args getArgs() {
        String args = "-l -p 8080 -d /usr/logs";
        String schema = "l:bool,p:int,d:string";
        return new Args(schema, args);
    }

    @Test
    public void should_has_option_l_p_d() {
        Args args = getArgs();
        Assert.assertTrue(args.hasOption("l"));
        Assert.assertTrue(args.hasOption("p"));
        Assert.assertTrue(args.hasOption("d"));
    }

    @Test
    public void should_get_bool_l() {
        Args args = getArgs();
        Assert.assertTrue(args.getBool("l"));
    }

    @Test
    public void should_get_int_p() {
        Args args = getArgs();
        Assert.assertEquals(8080, args.getInt("p"));
    }

    @Test
    public void should_get_string_d() {
        Args args = getArgs();
        Assert.assertEquals("/usr/logs", args.getString("d"));
    }
}
