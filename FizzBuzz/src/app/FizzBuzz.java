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

    private boolean checkHas(int v) {
        return String.valueOf(this.value).contains(String.valueOf(v));
    }

    @Override
    public String toString() {
        String result = "";

        // check if has Fizz
        if (checkMultiBy(this.fizzNumber) || checkHas(this.fizzNumber)) {
            result += this.fizzValue;
        }

        if (checkMultiBy(this.buzzNumber) || checkHas(this.buzzNumber)) {
            result += this.buzzValue;
        }

        return result.isEmpty() ? String.valueOf(this.value) : result;
    }
}