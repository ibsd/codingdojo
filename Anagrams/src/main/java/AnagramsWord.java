import java.util.Arrays;

public class AnagramsWord {
    private final String value;

    public AnagramsWord(String str) {
        this.value = str;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public int hashCode() {
        char[] origin = this.value.toCharArray();
        Arrays.sort(origin);

        int result = 1;
        for (char element : origin)
            result = 31 * result + element;

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }
}
