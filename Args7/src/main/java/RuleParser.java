class RuleParser {
    private String flag;
    private Parse parser;
    private boolean hasValue;

    private RuleParser(String flag, Parse parser, boolean hasValue) {
        this.flag = flag;
        this.parser = parser;
        this.hasValue = hasValue;
    }

    static RuleParser BOOL(String flag) {
        return new RuleParser(flag, Boolean::parseBoolean, false);
    }

    static RuleParser INT(String flag) {
        return new RuleParser(flag, Integer::parseInt, true);
    }

    static RuleParser STRING(String flag) {
        return new RuleParser(flag, value -> value, true);
    }

    boolean match(String op) {
        return this.flag.equals(op);
    }

    Object parse(String value) {
        return this.parser.parse(value);
    }

    boolean hasValue() {
        return this.hasValue;
    }
}
