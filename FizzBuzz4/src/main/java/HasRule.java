public class HasRule implements Executable {
    private int input;
    private final String output;

    public HasRule(int in, String out) {
        this.input = in;
        this.output = out;
    }

    public static HasRule create(int in, String out) {
        return new HasRule(in, out);
    }

    @Override
    public String exec(int i) {
        if (String.valueOf(i).contains(String.valueOf(this.input))) return this.output;
        return "";
    }
}
