# [FizzBuzz](http://codingdojo.org/kata/FizzBuzz/)

## Sprint 3

* [Product backlog](https://en.wikipedia.org/wiki/Scrum_(software_development)#Product_backlog)
  1. 集成测试

## 步骤分解

### 实现主程序

* 创建`Main`类和`main`方法
* `main`方法中调用`Game`类
* 有个变量--操作计数`100`，使用最保险的方法`构造函数`传入，保证`Game`类的封装性
* 调用`play`方法

```java
public class Main {
    public static void main(String[] args) {
        Game game = new Game(100);
        game.play();
    }
}
```

* `Alt+Enter`快速创建`Game`类和`play`方法
* `play`方法中实例化`FizzBuzz`，并调用其`toString`方法

```java
public class Game {
    private int count;

    public Game(int i) {
        this.count = i;
    }

    public void play() {
        for (int i = 0; i < this.count; i++) {
            FizzBuzz item = new FizzBuzz(i);
            System.out.println(item.toString());
        }
    }
}
```

* `Ctrl+Shift+F10`运行，得到符合预期的结果。

### 重构

* `Game`类里面内置了规则，违反了单一职责原则
  * 规则适合在`Game`类创建时指定，构造时传入规则
  * `play`可能被多次调用，计数适合在`play`时传入

```java
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Executable> rules = Rules.all();
        Game game = new Game(rules);
        game.play(100);
    }
}
```

```java
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
```

* `FizzBuzz`的`toString`要得出结果，同时还依赖于规则，所以重命名为`apply`，传入规则`rules`

```java
public String apply(List<Executable> rules) {
    return rules.stream()
            .map(rule -> rule.exec(this.value))
            .filter(value -> !value.isEmpty())
            .distinct()
            .reduce(String::concat)
            .orElse(String.valueOf(this.value));
}
```

* 更新测试代码，调用apply方法

```java
public class FizzBuzzTest {
    @ParameterizedTest(name = "should return {0} given {1}")
    @CsvSource({
            "1, 1",
            "3, Fizz",
            "5, Buzz",
            "15, FizzBuzz",
            "31, Fizz",
            "56, Buzz",
            "53, FizzBuzz",
    })
    void should_play_fizz_buzz(int input, String expected) {
        FizzBuzz item = new FizzBuzz(input);
        assertEquals(expected, item.apply(Rules.all()));
    }
}
```

## 后续变化

目前只实现了一个规则集合的创建方法`Rules.all`，后续需求变化时，可提供新的工厂方法来创建规则集合，由`main`方法传给`Game`类。

## Over