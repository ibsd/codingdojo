import java.util.Arrays;
import java.util.NoSuchElementException;

public class Args {
    private final ArgItem[] argItems;

    public Args(String schema) {
        this.argItems = Arrays.stream(schema.split(";")).map(ArgItem::new).toArray(ArgItem[]::new);
    }

    public ArgItem getItem(String flag) {
        return Arrays.stream(this.argItems).filter(item -> item.match(flag)).findFirst().orElseThrow(NoSuchElementException::new);
    }

    public void parse(String args) {
        Arrays.stream(args.split("-")).filter(arg -> !arg.isEmpty()).forEach(arg -> {
            ArgItem item = this.getItem(arg.trim());
            item.parse(arg);
        });
    }
}
