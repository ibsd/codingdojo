import java.util.Arrays;
import java.util.stream.Collectors;

public class IntArray {
    private final Integer[] values;

    IntArray(String str) {
        this.values = Arrays.stream(str.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
    }

    @Override
    public String toString() {
        return Arrays.stream(this.values).map(Object::toString).collect(Collectors.joining(","));
    }
}
