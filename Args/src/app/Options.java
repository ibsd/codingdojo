package app;

import java.util.List;

public class Options {
    private List<String> options;

    Options(List<String> list) {
        this.options = list;
    }

    public boolean hasOption(String arg) {
        return options.stream().filter(option -> option.contains(arg)).count() > 0;
    }

    public boolean getBool(String arg) {
        if (hasOption(arg)) {
            return true;
        }
        // TODO not in schema should show error
        return false;
    }
}