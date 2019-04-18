package app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import app.Schema.Item;

public class Options {
    public class Option {
        private String flag;
        private Object value;

        Option(String arg) {
            this.flag = arg;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    private HashMap<String, Option> options;

    Options() {
        options = new HashMap<>();
    }

    public boolean hasOption(String arg) {
        return options.containsKey(arg);
    }

    public boolean getBool(String arg) throws NoSuchArgsOptionException {
        // TODO default value
        if (hasOption(arg)) {
            return true;
        }
        throw new NoSuchArgsOptionException("Unkonw args: " + arg);
    }

    public int getInt(String arg) throws NoSuchArgsOptionException {
        if (hasOption(arg)) {
            Option option = this.options.get(arg);
            return Integer.parseInt((String) option.value);
        }
        throw new NoSuchArgsOptionException("Unkonw args: " + arg);
    }

    public void add(Option option) {
        this.options.put(option.flag, option);
    }

    public String getString(String arg) throws NoSuchArgsOptionException {
        if (hasOption(arg)) {
            Option option = this.options.get(arg);
            return (String) option.value;
        }
        throw new NoSuchArgsOptionException("Unkonw args: " + arg);
    }
}