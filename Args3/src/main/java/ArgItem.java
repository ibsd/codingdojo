class ArgItem {
    private final String flag;
    private final String value;

    ArgItem(String trim, ArgSchema schemaOption) {
        String[] pair = trim.split(" ");
        this.flag = schemaOption.match(pair[0]) ? pair[0] : "Error";
        this.value = schemaOption.hasValue(this.flag) ? pair[1] : "";
    }

    String getFlag() {
        return this.flag;
    }

    int getInt() {
        return Integer.parseInt(this.value);
    }

    String getString() {
        return this.value;
    }
}
