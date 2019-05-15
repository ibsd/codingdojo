public class DivRule implements Executable {
    private int input;
    private final String output;

    public DivRule(int in, String out) {
        this.input = in;
        this.output = out;
    }

    public static Executable create(int in, String out) {
        return new DivRule(in, out);
    }

    @Override
    public String exec(int i) {
        if (i % this.input == 0) return this.output;
        return "";
    }
}
