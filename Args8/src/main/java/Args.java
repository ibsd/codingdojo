import java.util.Arrays;

public class Args {
    private final String args;
    private Rule rule;

    public Args(String arg) {
        this.args = arg;
    }

    public boolean has(String flag) {
        return Arrays.stream(this.args.split(" "))
                .anyMatch(s -> s.endsWith(flag));
    }

    public Object get(String flag) {
        return Arrays.stream(this.args.split("-"))
                .filter(s -> !s.isEmpty())
                .filter(s -> new Args(s).has(flag))
                .map(this::parse)
                .findFirst()
                .orElse(new Object());
    }

    private Object parse(String args) {
        return this.rule.value(args);
    }

    public void schema(Rule rule) {
        this.rule = rule;
    }
}
