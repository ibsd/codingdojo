import java.util.List;

public class FizzBuzz {
    private final int value;

    public FizzBuzz(int i) {
        this.value = i;
    }

    public String apply(List<Executable> rules) {
        return rules.stream()
                .map(rule -> rule.exec(this.value))
                .filter(value -> !value.isEmpty())
                .distinct()
                .reduce(String::concat)
                .orElse(String.valueOf(this.value));
    }
}
