import java.util.Arrays;
import java.util.List;

public class Schema {
    private String type;
    private Parseable parser;
    private String flag;

    public static Schema build(String schema) {
        return SCHEMAS.stream()
                .filter(s -> s.type.equals(schema.split(":")[1]))
                .peek(s -> s.flag(schema.split(":")[0]))
                .findFirst()
                .orElse(UNKNOWN("unknown"));
    }

    private void flag(String flag) {
        this.flag = flag;
    }

    public Schema(String type, Parseable parser) {
        this.type = type;
        this.parser = parser;
    }

    public static Schema BOOL(String type) {
        return new Schema(type, value -> true);
    }

    public static Schema INT(String type) {
        return new Schema(type, Integer::parseInt);
    }

    public static Schema STRING(String type) {
        return new Schema(type, String::trim);
    }

    public static Schema UNKNOWN(String type) {
        return new Schema(type, value -> {
            throw new UnsupportedOperationException("Unsupported schema");
        });
    }

    public static List<Schema> SCHEMAS = Arrays.asList(
            Schema.BOOL("bool"),
            Schema.INT("int"),
            Schema.STRING("string")
    );

    public boolean match(String flag) {
        return this.flag.equals(flag);
    }

    public Object parse(String arg) {
        return this.type.equals("bool") ? true : this.parser.parse(arg.split(" ")[1]);
    }
}
