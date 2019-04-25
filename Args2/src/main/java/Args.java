import java.util.HashMap;

public class Args {
    private HashMap<String, Object> options;
    private ArgsSchema schema;

    public Args(String schema, String args) {
        this.schema = new ArgsSchema(schema);
        this.prase(args);
    }

    private void prase(String args) {
        String[] values = args.split(" ");
        options = new HashMap<>();
        for (int i = 0; i < values.length; ) {
            String flag = values[i++];
            if (flag.startsWith("-")) {
                flag = flag.substring(1);
            }
            switch (this.schema.type(flag))
            {
                case "bool":
                    options.put(flag, true);
                    break;
                case "int":
                case "string":
                    options.put(flag, values[i++]);
                    break;
            }
        }
    }

    public boolean hasOption(String option) {
        return this.options.containsKey(option);
    }

    public boolean getBool(String option) {
        return hasOption(option);
    }

    public int getInt(String option) {
        if (hasOption(option)) {
            return Integer.parseInt(this.options.get(option).toString());
        }
        return 0;
    }

    public String getString(String option) {
        if (hasOption(option)) {
            return this.options.get(option).toString();
        }
        return "";
    }
}
