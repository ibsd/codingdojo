public class DivRule implements Playable {
    private int input;
    private final String output;

    public DivRule(int in, String out) {
        this.input = in;
        this.output = out;
    }

    public static Playable create(int in, String out) {
        return new DivRule(in, out);
    }

    @Override
    public String play(int i) {
        if (i % this.input == 0) return this.output;
        return "";
    }
}
