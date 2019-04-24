public class FizzBuzz {
    public static String play(int actual) {
        String result = "";
        if (multyBy(actual, 3) || isContains(actual, "3")) {
            result += "Fizz";
        }
        if (multyBy(actual, 5) || isContains(actual, "5")) {
            result += "Buzz";
        }
        if (result.isEmpty()) {
            result += actual;
        }
        return result;
    }

    private static boolean isContains(int actual, String expected) {
        return String.valueOf(actual).contains(expected);
    }

    private static boolean multyBy(int actual, int i) {
        return actual % i == 0;
    }
}
