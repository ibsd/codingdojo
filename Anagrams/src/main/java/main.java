import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        AnagramsWords words = new AnagramsWords();
        BufferedReader br = new BufferedReader(new FileReader("wordlist.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            AnagramsWord word = new AnagramsWord(line);
            words.add(word);
        }

        words.values()
                .stream()
                .filter(anagramsWords -> anagramsWords.size() > 1)
                .forEach(
                anagramsWords -> {
                    anagramsWords.forEach(anagramsWord -> {
                        System.out.print(anagramsWord);
                        System.out.print(" ");
                    });
                    System.out.println();
                }
        );
        System.out.println("Max: " + words.max());
    }
}
