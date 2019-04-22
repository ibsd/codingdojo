package app;

public class FizzBuzz {
    private final int fizzNumber = 3;
    private final int buzzNumber = 5;
    private final String fizzValue = "Fizz";
    private final String buzzValue = "Buzz";
    private int value;

    FizzBuzz(int v) {
        this.value = v;
    }

    private boolean checkMultiBy(int multi) {
        return this.value % multi == 0;
    }

    @Override
    public String toString() {
        if (checkMultiBy(this.fizzNumber) && checkMultiBy(this.buzzNumber)) {
            return this.fizzValue + this.buzzValue;
        }

        if (checkMultiBy(this.fizzNumber)) {
            return this.fizzValue;
        }

        if (checkMultiBy(this.buzzNumber)) {
            return this.buzzValue;
        }

        if (checkHas(this.fizzNumber)) {
            return this.fizzValue;
        }

        if (checkHas(this.buzzNumber)) {
            return this.buzzValue;
        }

        return String.valueOf(this.value);
    }

    private boolean checkHas(int v) {
        return String.valueOf(this.value).contains(String.valueOf(v));
    }
}