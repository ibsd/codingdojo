import java.util.HashMap;

class ArgsSchema {
    private HashMap<String, Object> options;

    ArgsSchema(String schema) {
        String[] values = schema.split(",");
        options = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String[] pair = values[i].split(":");
            options.put(pair[0], pair[1]);
        }
    }

    private boolean match(String flag) {
        return options.containsKey(flag);
    }

    String type(String flag) {
        if (match(flag)) {
            return this.options.get(flag).toString();
        }
        return "error";
    }
}
