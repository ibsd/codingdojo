import java.util.HashMap;

class ArgSchema {
    HashMap<String, String> options;

    ArgSchema(String schema) {
        this.options = new HashMap<>();
        String[] list = schema.split(",");
        for (int i = 0; i < list.length; i++) {
            String[] pair = list[i].split(":");
            options.put(pair[0], pair[1]);
        }
    }

    boolean match(String flag) {
        String op = flag.startsWith("-") ? flag.substring(1) : "";
        return this.options.containsKey(op);
    }

    public boolean hasValue(String flag) {
        return this.options.get(flag).equals("bool");
    }
}
