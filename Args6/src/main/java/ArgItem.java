public class ArgItem {

    private final String key;
    private final String type;
    private final String defaultValue;
    private Object value;

    public ArgItem(String input) {
        String[] list = input.split(":");
        this.key = list[0];
        this.type = list[1];
        this.defaultValue = list[2];
    }

    public String defaultValue() {
        return this.defaultValue;
    }

    boolean match(String flag) {
        return flag.startsWith(this.key);
    }

    public Object getValue() {
        return this.value;
    }

    void parse(String arg) {
        switch (this.type) {
            case "bool":
                this.value = true;
                break;
            case "int":
                this.value = parseInts(arg.split(" ")[1]);
                break;
            case "string":
                this.value = arg.split(" ")[1];
                break;
        }
    }

    private IntArray parseInts(String str) {
        return new IntArray(str);
    }
}
