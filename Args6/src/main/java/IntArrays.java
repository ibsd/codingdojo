import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class IntArrays {
    private final List<Integer> values;

    @Override
    public String toString() {
        return this.values.stream().map(Objects::toString).collect(Collectors.joining(","));
    }

    IntArrays(String array) {
        this.values = Arrays.stream(array.split(",")).map(Integer::new).collect(Collectors.toList());
    }
}
