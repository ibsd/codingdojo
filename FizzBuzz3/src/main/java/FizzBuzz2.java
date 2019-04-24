public class FizzBuzz2 {
    public static final int FIZZ_VALUE = 3;
    public static final int BUZZ_VALUE = 5;
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    private final int value;

    public FizzBuzz2(int actual) {
        this.value = actual;
    }

    @Override
    public String toString() {
        String result = "";
        if (isRule(FIZZ_VALUE)) result += FIZZ;
        if (isRule(BUZZ_VALUE)) result += BUZZ;
        if (result.isEmpty()) result += String.valueOf(this.value);
        return result;
    }

    private boolean isRule(int fizzValue) {
        return multyBy(fizzValue) || isContains(String.valueOf(fizzValue));
    }

    private boolean isContains(String expected) {
        return String.valueOf(this.value).contains(expected);
    }

    private boolean multyBy(int i) {
        return this.value % i == 0;
    }
}
