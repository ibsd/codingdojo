import java.util.Arrays;

public class ArgsItem {
    private static final int INDEX_KEY = 0;
    private static final int INDEX_TYPE = 1;
    private static final int INDEX_DEFAULT = 2;
    private final String[] schema;
    private Object value;

    public ArgsItem(String schema) {
        this.schema = Arrays.stream(schema.split(":")).toArray(String[]::new);
    }

    public String getDefault() {
        return this.schema[INDEX_DEFAULT];
    }

    boolean match(String flag) {
        return flag.startsWith(this.schema[INDEX_KEY]);
    }

    void parse(String arg) {
        switch (this.schema[INDEX_TYPE]) {
            case "bool":
                this.value = true;
                break;
            case "int":
                this.value = new IntArrays(arg.split(" ")[1]);
                break;
            case "string":
                this.value = arg.split(" ")[1];
                break;
        }
    }

    public Object getValue() {
        return this.value;
    }
}
