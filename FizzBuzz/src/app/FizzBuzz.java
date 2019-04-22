package app;

public class FizzBuzz {
    private final int FizzValue = 3;
    private final int BuzzValue = 5;
    private int value;

    FizzBuzz(int v) {
        this.value = v;
    }

    private boolean checkMultiBy(int multi) {
        return this.value % multi == 0;
    }

    @Override
    public String toString() {
        if (checkMultiBy(this.FizzValue) && checkMultiBy(this.BuzzValue)) {
            return "FizzBuzz";
        }

        if (checkMultiBy(this.FizzValue)) {
            return "Fizz";
        }

        if (checkMultiBy(this.BuzzValue)) {
            return "Buzz";
        }

        if (checkHas(this.FizzValue)) {
            return "Fizz";
        }

        if (checkHas(this.BuzzValue)) {
            return "Buzz";
        }

        return String.valueOf(this.value);
    }

    private boolean checkHas(int v) {
        return String.valueOf(this.value).contains(String.valueOf(v));
    }
}