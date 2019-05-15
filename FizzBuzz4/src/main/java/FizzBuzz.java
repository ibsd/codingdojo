public class FizzBuzz {
    private final int value;

    public FizzBuzz(int i) {
        this.value = i;
    }

    @Override
    public String toString() {
        return Rules.all()
                .stream()
                .map(rule -> rule.exec(this.value))
                .filter(value -> !value.isEmpty())
                .distinct()
                .reduce(String::concat)
                .orElse(String.valueOf(this.value));
    }
}
