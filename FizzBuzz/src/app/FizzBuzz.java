package app;

public class FizzBuzz {
    private int value;

    FizzBuzz(int v) {
        this.value = v;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}