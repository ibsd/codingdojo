package app;

public class FizzBuzz {
    private int value;

    FizzBuzz(int v) {
        this.value = v;
    }

    @Override
    public String toString() {
        if (this.value % 3 == 0) {
            return "Fizz";
        }
        return String.valueOf(this.value);
    }
}