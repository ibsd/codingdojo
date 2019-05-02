import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ArgsList {
    private final List<ArgsItem> args;

    public ArgsList(String schemas) {
        this.args = Arrays.stream(schemas.split(";")).map(ArgsItem::new).collect(Collectors.toList());
    }

    public ArgsItem getItem(String flag) {
        return this.args.stream().filter(arg -> arg.match(flag)).findFirst().orElseThrow(NoSuchElementException::new);
    }

    public void parse(String args) {
        Arrays.stream(args.split("-")).filter(arg -> !arg.isEmpty()).forEach(arg -> {
            ArgsItem item = this.getItem(arg);
            item.parse(arg);
        });
    }
}
