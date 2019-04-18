package app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArgsParser {
    ArgsParser() {
    }

    public Options parse(String[] args) {
        List<String> all = Arrays.asList(args);
        List<String> options = all.stream().filter(o -> o.startsWith("-")).collect(Collectors.toList());
        return new Options(options);
    }
}