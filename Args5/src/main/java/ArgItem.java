public class ArgItem {
    private final String key;
    private final String type;
    private Object value;
    private final String defaultValue;

    public ArgItem(String schema) {
        String[] list = schema.split(":");
        this.key = list[0];
        this.type = list[1];
        this.defaultValue = list[2];
        this.value = null;
    }

    @Override
    public String toString() {
        return this.value == null ? this.defaultValue : this.value.toString();
    }

    public String defaultValue() {
        return this.defaultValue;
    }

    public Object parse(String args) {
        String[] list = args.split(" ");
        if (this.key.equals(list[0])) {
            switch (this.type) {
                case "bool":
                    this.value = true;
                    break;
                case "int":
                    this.value = list.length > 1 ? Integer.parseInt(list[1]) : this.defaultValue;
                    break;
                case "string":
                    this.value = list.length > 1 ? list[1] : this.defaultValue;
                    break;
            }
        }
        return this.value;
    }

    public String getKey() {
        return this.key;
    }

    public boolean match(String flag) {
        return this.key.endsWith(flag);
    }

    public Object getValue() {
        return this.value;
    }
}
