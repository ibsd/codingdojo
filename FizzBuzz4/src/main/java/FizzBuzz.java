import java.util.List;

public class FizzBuzz {
    private final int value;

    public FizzBuzz(int i) {
        this.value = i;
    }

    @Override
    public String toString() {
        // FIXME rule to array
        List<Playable> rules = Rules.all();
        return rules.stream()
                .map(rule -> rule.play(this.value))
                .filter(value -> !value.isEmpty())
                .reduce(String::concat)
                .orElse(String.valueOf(this.value));
    }
}
