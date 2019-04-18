package app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import app.Options.Option;
import app.Schema.Item;

public class ArgsParser {
    private Schema schema;

    ArgsParser(Schema schema) {
        this.schema = schema;
    }

    public Options parse(String[] args) {
        Options options = new Options();
        for (int i = 0; i < args.length;) {
            String flag = args[i++];
            Optional<Item> result = schema.query(flag);
            if (result.isPresent()) {
                Item item = result.get();
                Option option = options.new Option(flag);
                if (item.hasValue()) {
                    option.setValue(args[i++]);
                }
                options.add(option);
            }
        }
        return options;
    }
}