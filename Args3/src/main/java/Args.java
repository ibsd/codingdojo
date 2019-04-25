import java.util.HashMap;

public class Args {
    private HashMap<String, Object> options;

    public Args(String schema, String args_value) {
        ArgSchema schemaOption = new ArgSchema(schema);
        this.options = new HashMap<>();

        parse(args_value, schemaOption);
    }

    private void parse(String args_value, ArgSchema schemaOption) {
        String[] list = args_value.split(" ");
        for (int i = 0; i < list.length; ) {
            String flag = list[i++];
            if (schemaOption.match(flag)) {
                flag = flag.substring(1);
                options.put(flag, schemaOption.hasValue(flag) ? true : list[i++]);
            }
        }
    }

    public boolean hasOption(String op) {
        return this.options.containsKey(op);
    }

    public boolean getBool(String op) {
        return hasOption(op);
    }

    public int getInt(String op) {
        if (hasOption(op)) {
            return Integer.parseInt(this.options.get(op).toString());
        }
        return 0;
    }

    public String getString(String op) {
        return this.options.get(op).toString();
    }
}
