public class FizzBuzz {
    private final int value;

    public FizzBuzz(int i) {
        this.value = i;
    }

    @Override
    public String toString() {
        // FIXME switch to array pipe
        if (ruleFizz() && ruleBuzz()) return "FizzBuzz";
        if (ruleFizz()) return "Fizz";
        if (ruleBuzz()) return "Buzz";
        return String.valueOf(this.value);
    }

    private boolean ruleFizz() {
        return isDivBy(3);
    }

    private boolean ruleBuzz() {
        return isDivBy(5);
    }

    private boolean isDivBy(int i) {
        return this.value % i == 0;
    }
}
