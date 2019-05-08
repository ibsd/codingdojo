import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Args {
    private static final List<RuleParser> SCHEMA = Arrays.asList(
            RuleParser.BOOL("l"),
            RuleParser.INT("p"),
            RuleParser.STRING("d")
    );
    private final String args;

    public Args(String args) {
        this.args = args;
    }

    public boolean hasOption(String op) {
        return Arrays.stream(this.args.split(" "))
                .filter(o -> o.endsWith(op))
                .map(a -> !a.isEmpty())
                .findFirst()
                .orElse(false);
    }

    public Object getValue(String op) throws NoSuchArgsOptionException {
        return SCHEMA.stream()
                .filter(rule -> rule.match(op))
                .map(rule -> rule.parse(params(op, rule)))
                .findFirst()
                .orElseThrow(NoSuchArgsOptionException::new);
    }

    private String params(String op, RuleParser rule) {
        return rule.hasValue() ? this.getParam(op) : Boolean.valueOf(this.hasOption(op)).toString();
    }

    private String getParam(String op) {
        return Arrays.stream(this.args.split("-"))
                .filter(notEmpty())
                .filter(o -> o.startsWith(op))
                .map(a -> a.split(" "))
                .map(a -> a[1])
                .findFirst()
                .orElse("");
    }

    private Predicate<String> notEmpty() {
        return e -> !e.isEmpty();
    }
}
