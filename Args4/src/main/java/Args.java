import java.util.Arrays;
import java.util.Objects;

public class Args {
    public static ArgOptions prase(String[][] schema, String[][] args) {
        ArgOptions options = new ArgOptions();
        Arrays.asList(args).forEach(arg -> {
                    Arrays.stream(schema).filter(op -> Objects.equals(arg[0], op[0])).findFirst().map(option -> {
                        options.add(arg[0], option[1], arg[1]);
                        return option;
                    });
                }
        );
        return options;
    }
}
