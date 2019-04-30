import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Args {
    private List<ArgItem> items;

    public Args(String schema, String args) {
        String[] schemaList = schema.split(",");
        String[] argList = args.split("-");
        items = new ArrayList<>();
        Arrays.asList(schemaList).forEach(aSchema -> {
            ArgItem item = new ArgItem(aSchema);
            Arrays.stream(argList).filter(arg -> arg.startsWith(item.getKey())).findFirst().map(String::trim).map(item::parse);
            items.add(item);
        });
    }

    public ArgItem getItem(String flag) {
        return items.stream().filter(item -> item.match(flag)).findFirst().get();
    }
}
