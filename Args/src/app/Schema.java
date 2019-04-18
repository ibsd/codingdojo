package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Schema {
    public class Item {
        private String config;

        Item(String cfg) {
            this.config = cfg;
        }

        public boolean hasValue() {
            return !config.split(":")[1].equals("bool");
        }

        public String getFlag() {
            return config.split(":")[0];
        }

        public boolean match(String arg) {
            String flag = this.getFlag();
            boolean result = flag.equals(arg);
            return result;
        }
    }

    private List<Item> items;

    Schema(String config) {
        items = new ArrayList<>();
        Arrays.asList(config.split(",")).forEach(cfg -> items.add(new Item(cfg)));
    }

    public Optional<Item> query(String arg) {
        return items.stream().filter(item -> item.match(arg)).findFirst();
    }
}