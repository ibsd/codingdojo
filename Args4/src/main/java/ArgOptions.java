import java.util.HashMap;

public class ArgOptions {
    private final HashMap<String, Object> options;

    public ArgOptions() {
        options = new HashMap<>();
    }

    public boolean has(String input) {
        return options.containsKey(input);
    }

    void add(String flag, String type, String value) {
        switch (type) {
            case "bool":
                options.put(flag, true);
                break;
            case "int":
                options.put(flag, Integer.valueOf(value));
                break;
            case "string":
                options.put(flag, value);
                break;
        }
    }

    public Object get(String input) {
        return options.get(input);
    }
}
