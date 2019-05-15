import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramsTest {

    @Test
    void words_of_anagram_should_equal() {
        AnagramsWord word1 = new AnagramsWord("ab");
        AnagramsWord word2 = new AnagramsWord("ba");
        assertEquals(word1, word2);
    }

    @Test
    void anagram_words_group_should_count() {
        AnagramsWord word1 = new AnagramsWord("abc");
        AnagramsWord word2 = new AnagramsWord("bac");
        AnagramsWord word3 = new AnagramsWord("cba");
        AnagramsWords words = new AnagramsWords();
        words.add(word1);
        words.add(word2);
        words.add(word3);
        assertEquals(3, words.count(word1));
    }

    @Test
    void should_get_max() {
        AnagramsWord word1 = new AnagramsWord("abc");
        AnagramsWord word2 = new AnagramsWord("bac");
        AnagramsWord word3 = new AnagramsWord("cba");
        AnagramsWords words = new AnagramsWords();
        words.add(word1);
        words.add(word2);
        words.add(word3);

        AnagramsWord word4 = new AnagramsWord("ab");
        AnagramsWord word5 = new AnagramsWord("ba");
        words.add(word4);
        words.add(word5);

        assertEquals(3, words.max());
    }
}
