import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

public class Args {
    private final String args;

    public Args(String args) {
        this.args = args;
    }

    public boolean hasOption(String op) throws NoSuchArgsOptionException {
        return Arrays.stream(this.args.split(" "))
                .filter(o -> o.endsWith(op))
                .map(a -> !a.isEmpty())
                .findFirst()
                .orElseThrow(NoSuchArgsOptionException::new);
    }

    public Object getValue(String op) throws NoSuchArgsOptionException, NoSuchArgsParamException {
        switch (op) {
            case "l":
                return this.hasOption(op);
            case "p":
                return Integer.parseInt(Objects.requireNonNull(this.getParam(op)));
            case "d":
                return this.getParam(op);
            default:
                throw new NoSuchArgsOptionException();
        }
    }

    private String getParam(String op) throws NoSuchArgsParamException {
        return Arrays.stream(this.args.split("-"))
                .filter(notEmpty())
                .filter(o -> o.startsWith(op))
                .map(a -> a.split(" "))
                .map(a -> a[1])
                .findFirst()
                .orElseThrow(NoSuchArgsParamException::new);
    }

    private Predicate<String> notEmpty() {
        return e -> !e.isEmpty();
    }
}
