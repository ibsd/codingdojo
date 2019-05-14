import java.util.Arrays;
import java.util.List;

public class Rules {

    public static List<Playable> all() {
        return Arrays.asList(
                DivRule.create(3, "Fizz"),
                DivRule.create(5, "Buzz")
        );
    }
}
