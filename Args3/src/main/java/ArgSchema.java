import java.util.HashMap;

class ArgSchema {
    private HashMap<String, String> options;

    ArgSchema(String schema) {
        this.options = new HashMap<>();
        String[] list = schema.split(",");
        for (String s : list) {
            String[] pair = s.split(":");
            options.put(pair[0], pair[1]);
        }
    }

    boolean match(String flag) {
        return this.options.containsKey(flag);
    }

    boolean hasValue(String flag) {
        return !this.options.get(flag).equals("bool");
    }
}
