# [FizzBuzz](http://codingdojo.org/kata/FizzBuzz/)

## Sprint 2

* [Product backlog](https://en.wikipedia.org/wiki/Scrum_(software_development)#Product_backlog)
  1. 如果碰到包含“3”的数，则报“Fizz”
  2. 如果碰到包含“5”的数，则报“Buzz”
  3. 如果碰到包含“3”和“5”的数，则报“FizzBuzz”

## 操作分解

### 第1组操作：实现PBI1

* 为该PBI添加测试数据

    测试方法的`CsvSource`内增加一条数据：`"31, Fizz"`

* 快速让测试通过

    此时`toString`本身的职责已经被确认为是：规则的执行者，并返回执行结果。
    规则的变化不会再引起该方法的修改。

    需要寻找新的会被引起变化的地方，`Rules.all`是个地方，适合添加一条新的规则，如下：

```java
public static List<Playable> all() {
    return Arrays.asList(
            DivRule.create(3, "Fizz"),
            DivRule.create(5, "Buzz"),
            HasRule.create(3, "Fizz")
    );
}
```

    使用`Alt+Enter`快速生成`HasRule`类和`create`方法
    实现`create`方法和重载的`exec`方法，代码如下：

```java
public class HasRule implements Playable {
    private int input;
    private final String output;

    public HasRule(int in, String out) {
        this.input = in;
        this.output = out;
    }

    public static HasRule create(int in, String out) {
        return new HasRule(in, out);
    }

    @Override
    public String play(int i) {
        if (String.valueOf(i).contains(String.valueOf(this.input))) return this.output;
        return "";
    }
}
```

    此时运行测试，仍然不能通过，或者你不去运行也知道还不足以通过测试，但也要去运行一下，给下一步做什么提供明确指示，谓之-TDD。
    错误如下：
    `expected: <Fizz> but was: <FizzFizz>`

    可以看出这是第二条测试数据`3 Fizz`，同时满足2条规则，然后组合后生成的；
    所以在组合规则时，需要添加一个先去重的逻辑，然后再进行拼接。

```java
public class FizzBuzz {
    private final int value;

    public FizzBuzz(int i) {
        this.value = i;
    }

    @Override
    public String toString() {
        return Rules.all()
                .stream()
                .map(rule -> rule.exec(this.value))
                .filter(value -> !value.isEmpty())
                .distinct()  // 新增去重逻辑
                .reduce(String::concat)
                .orElse(String.valueOf(this.value));
    }
}
```

* 重构

    目前没有坏味道，无需重构

* 总结

    新增规则，该规则属于`原子规则`，类`HasRule`是新建的；
    在规则工厂`Rules.all`中添加**一行**代码加入；
    原有的`组合规则`被测试数据破坏，需要新增一条逻辑，由于使用[Collection Pipelines](https://martinfowler.com/articles/collection-pipeline/)来实现了逻辑的组合，只需再加**一行**代码`distinct`即可实现。

### 第2组操作：实现PBI2

* 为该PBI添加测试数据

    测试方法的`CsvSource`内增加一条数据：`"56, Buzz"`

* 快速让测试通过

    `Rules.all`中添加一条新的规则，如下：

```java
public static List<Playable> all() {
    return Arrays.asList(
            DivRule.create(3, "Fizz"),
            DivRule.create(5, "Buzz"),
            HasRule.create(3, "Fizz"),
            HasRule.create(5, "Buzz")
    );
}
```

* 无需重构
* 总结

    新增规则，该`原子规则`已被实现，只是实例参数不同，再规则工厂中加入即可；
    其余部分没有被破坏。

### 第3组操作：实现PBI3

* 为该PBI添加测试数据

    测试方法的`CsvSource`内增加一条数据：`"53, Buzz"`

* 快速让测试通过

    没有让测试失败，该测试数据已包含在之前的组合规则中。

* 无需重构
* 总结

    该测试数据没有破坏已有逻辑。

## Over
