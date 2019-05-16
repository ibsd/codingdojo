import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Executable> rules = Rules.all();
        Game game = new Game(rules);
        game.play(100);
    }
}
