import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Args {
    private HashMap<String, ArgItem> options;

    public Args(String schema, String args_value) {
        ArgSchema schemaOption = new ArgSchema(schema);
        this.options = new HashMap<>();

        parse2(args_value, schemaOption);
    }

    private void parse2(String args_value, ArgSchema schemaOption) {
        List<String> list = Arrays.asList(args_value.split("-"));
        list.forEach(option -> {
            if (option.length() > 0) {
                ArgItem item = new ArgItem(option.trim(), schemaOption);
                this.options.put(item.getFlag(), item);
            }
        });
    }

    public boolean hasOption(String op) {
        return this.options.containsKey(op);
    }

    public boolean getBool(String op) {
        return hasOption(op);
    }

    public int getInt(String op) {
        if (hasOption(op)) {
            return this.options.get(op).getInt();
        }
        return 0;
    }

    public String getString(String op) {
        return this.options.get(op).getString();
    }
}
