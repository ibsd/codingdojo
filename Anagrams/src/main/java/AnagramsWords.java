import java.util.*;

public class AnagramsWords {
    Map<Integer, List<AnagramsWord>> words;

    public AnagramsWords() {
        this.words = new HashMap<>();
    }

    public void add(AnagramsWord word) {
        if (this.words.containsKey(word.hashCode())) {
            List<AnagramsWord> old = this.words.get(word.hashCode());
            old.add(word);
            this.words.put(word.hashCode(), old);
        } else {
            List<AnagramsWord> newer = new ArrayList<>();
            newer.add(word);
            this.words.put(word.hashCode(), newer);
        }
    }

    public int count(AnagramsWord word) {
        return this.words.get(word.hashCode()).size();
    }

    public int max() {
        return this.words.values().stream().map(List::size).max(Integer::compareTo).orElse(0);
    }

    public Collection<List<AnagramsWord>> values() {
        return this.words.values();
    }
}
