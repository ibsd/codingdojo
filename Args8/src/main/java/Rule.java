import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rule {

    private List<Schema> rules;

    public Rule(String schema) {
        this.rules =
                Arrays.stream(schema.split(";"))
                        .map(Schema::build)
                        .collect(Collectors.toList());
    }

    public Object value(String arg) {
        return this.rules.stream()
                .filter(schema -> schema.match(arg.split(" ")[0]))
                .map(schema -> schema.parse(arg))
                .findFirst()
                .orElseThrow(UnknownError::new);
    }
}
