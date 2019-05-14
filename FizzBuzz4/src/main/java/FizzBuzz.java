public class FizzBuzz {
    private final int value;

    public FizzBuzz(int i) {
        this.value = i;
    }

    @Override
    public String toString() {
        if (isDivBy(15)) return "FizzBuzz";
        if (isDivBy(3)) return "Fizz";
        if (isDivBy(5)) return "Buzz";
        return String.valueOf(this.value);
    }

    private boolean isDivBy(int i) {
        return this.value % i == 0;
    }
}
