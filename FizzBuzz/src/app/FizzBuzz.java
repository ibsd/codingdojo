package app;

public class FizzBuzz {
    private final int FizzValue = 3;
    private final int BuzzValue = 5;
    private int value;

    FizzBuzz(int v) {
        this.value = v;
    }

    @Override
    public String toString() {
        if (this.value % (this.FizzValue * this.BuzzValue) == 0) {
            return "FizzBuzz";
        }

        if (this.value % this.FizzValue == 0) {
            return "Fizz";
        }

        if (this.value % this.BuzzValue == 0) {
            return "Buzz";
        }

        return String.valueOf(this.value);
    }
}