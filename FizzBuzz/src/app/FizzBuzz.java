package app;

public class FizzBuzz {
    private int value;

    FizzBuzz(int v) {
        this.value = v;
    }

    @Override
    public String toString() {
        if (this.value % 15 == 0) {
            return "FizzBuzz";
        }

        if (this.value % 3 == 0) {
            return "Fizz";
        }

        if (this.value % 5 == 0) {
            return "Buzz";
        }

        return String.valueOf(this.value);
    }
}