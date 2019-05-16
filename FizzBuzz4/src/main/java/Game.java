import java.util.List;

public class Game {

    private final List<Executable> rules;

    public Game(List<Executable> rules) {
        this.rules = rules;
    }

    public void play(int count) {
        for (int i = 0; i < count; i++) {
            FizzBuzz item = new FizzBuzz(i);
            System.out.println(item.apply(this.rules));
        }
    }
}
