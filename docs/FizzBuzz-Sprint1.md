# [FizzBuzz](http://codingdojo.org/kata/FizzBuzz/)

For
> [Kobe Bryant details how Kevin Durant can get even better | 'Detail' Excerpt | ESPN](https://www.youtube.com/watch?v=pddvK5COgHc&t=43s)

## Sprint 1

* [Product backlog](https://en.wikipedia.org/wiki/Scrum_(software_development)#Product_backlog)
  1. 从1至100依次报数，如第1位报“1”，第2位报“2”
  2. 如果碰到被3整除的数则报“Fizz”
  3. 如果碰到被5整除的数则报“Buzz”
  4. 如果同时被3和5整除则报“FizzBuzz”

## 操作分解

下面以3分钟为时限来组织操作，每一组完成一个明确的目标。

### 第1组操作：`创建工程和配置`

* 创建工程
  * 开发环境：`IntelliJ IDEA Community Edition 2019.1.1 x64`
  * 编程语言：`Java8`
  * 构建系统：`Gradle`

* 配置单元测试
  * Junit5

#### Junit5不知道如何配置？

|步骤|动作|结果|用时|
|--|--|--|--|
|1|通过搜索引擎搜索Junit5|找到官方主页`https://junit.org/junit5/`| 10s
|2|浏览主页，寻找文档链接|找到`User Guide`| 10s
|3|浏览文档目录，寻找`Gradle`的配置|找到`4.2.1`节：Running Test -> Build Support -> Gradle `10.1.2`节：JUnit Jupiter | 30s
|4|照文档修改`build.gradle`|修改结果如下|60s|

```gradle
test {
    useJUnitPlatform()
}

dependencies {
    testCompile("org.junit.jupiter:junit-jupiter-api:5.4.2")
    testCompile("org.junit.jupiter:junit-jupiter-params:5.4.2")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.4.2")
}
```

* `Refresh Gradle project`

一般会自动刷新，也可手动刷新：在`Build`和`Gradle`窗口的左上角都有该刷新按钮。

### 第2组操作：`Hello, Junit`

#### 创建测试类/文件

|步骤|动作|结果|用时|
|--|--|--|--|
|1|Alt+1|跳到Project窗口|1s
|2|↓→↑←|定位到`src/test/java`目录|3s
|3|Alt+Ins|弹出Generate或New菜单|1s
|4|选择`Java Class`回车|弹出`Create New Class`对话框|1s
|5|输入类名`FizzBuzzTest`回车|跳到新建的类编辑窗口|5s

#### 验证单元测试可工作

|步骤|动作|结果|用时|
|--|--|--|--|
|1|Alt+Ins|弹出Generate菜单|1s
|2|选择`Test Method`回车|新建一个测试方法，并选择方法名|1s
|3|输入方法名`should_work_ok`回车|进入函数体|3s
|4|开始写第一行代码|输入代码如下|10s
|5|Ctrl+Shift+F10运行该测试方法|在`Run`窗口显示`Test Result`|5s

```java
assertEquals(1, 1);
```

### 第3组操作：实现第1条PBI

#### 为该PBI创建测试方法

借助IDE的代码生成功能，快速完成类和函数的创建。

|步骤|动作|结果|用时|
|--|--|--|--|
|1|Alt+Ins|弹出Generate菜单|1s
|2|选择`Test Method`回车|新建一个测试方法，并选择方法名|1s
|3|输入方法名`should_input_1_return_1`回车|进入函数体|3s
|4|开始写第一行代码|输入代码如下|10s
|5|光标定位在FizzBuzz，按Alt+Enter|弹出Generate对话框|3s
|6|选择`Create Class FizzBuzz`回车|弹出对话框配置包名和路径|1s
|7|包名留空，路径选择main，回车|进入新建的类`FizzBuzz`编辑区|3s
|8|Ctrl+Tab|切换回测试类编辑区|1s
|9|光标定位到FizzBuzz构造函数，按Alt+Enter|弹出Generate对话框|3s
|10|选择`Create constructor`回车|跳到类`FizzBuzz`新建的构造函数|1s
|11|Shift+F10运行上次运行过的测试方法|在`Run`窗口显示`Test Result`|5s
|12|结果测试失败，红色提示

```java
@Test
void should_input_1_return_1() {
    FizzBuzz item = new FizzBuzz(1);
    assertEquals("1", item.toString());
}
```

#### 快速让该测试通过

|步骤|动作|结果|用时|
|--|--|--|--|
|1|在FizzBuzz类编辑区，按Ctrl+O|弹出选择Override方法菜单|1s
|2|选择`toString`方法，回车|跳到toString函数体内|3s
|3|修改代码，让测试通过|代码结果如下|10s
|4|Shift+F10运行上次运行过的测试方法|在`Run`窗口显示`Test Result`|5s
|5|结果测试成功，绿色提示

```java
@Override
public String toString() {
    return "1";
}
```

#### 重构代码

|步骤|动作|结果|用时|
|--|--|--|--|
|1|修改toString实现|代码结果如下`toString`部分|10s
|2|光标定位在value，按Alt+Enter|弹出Generate对话框|3s
|3|选择`Create Field`，回车|跳到新建的成员变量处|1s
|4|在构造函数内为该成员变量赋值|代码结果如下`构造函数`部分|10s
|4|Shift+F10运行测试|仍是绿色，说明重构没出错|5s

```java
@Override
public String toString() {
    return String.valueOf(this.value);
}

public FizzBuzz(int i) {
    this.value = i;
}
```

### 第4组操作：实现第2条PBI

#### 为PBI2创建测试方法

|步骤|动作|结果|用时|
|--|--|--|--|
|1|Ctrl+Tab|切回到测试代码编辑区|1s
|2|选中已有的一个测试方法，按Ctrl+D|复制一份新的测试方法|3s
|3|为新复制的方法改名|代码如下：`仅改函数名`|3s
|4|修改新测试代码以实现PBI2|代码如下：`函数内容`|10s
|5|光标定位到测试方法外，测试类里面，Ctrl+Shift+F10运行测试|**这样可以测试全部方法**，结果是红色|5s

```java
@Test
void should_input_3_return_Fizz() {
    FizzBuzz item = new FizzBuzz(3);
    assertEquals("Fizz", item.toString());
}
```

#### 快速让测试`should_input_3_return_Fizz`通过

>从此处开始省略[Baby Steps](https://en.wikipedia.org/wiki/Baby_Steps)描述。

修改`toString`实现，然后运行测试，绿色。

```java
@Override
public String toString() {
    if (this.value % 3 == 0) return "Fizz";
    return String.valueOf(this.value);
}
```

#### 重构测试代码

使用Junit5的参数化测试方法，可以消除重复的测试方法，然后运行测试，绿色。

```java
@ParameterizedTest(name = "should return {1} given {0}")
@CsvSource({
        "1, 1",
        "3, Fizz",
})
void should_test_sprint_1(int input, String expected) {
    FizzBuzz item = new FizzBuzz(input);
    assertEquals(expected, item.toString());
}
```

### 第5组操作：实现第3条PBI

* 为该PBI添加测试数据，然后运行测试，红色

    测试方法的`CsvSource`内增加一条数据：`"5, Buzz"`

* 快速让测试通过

    `FizzBuzz`类`toString`方法内增加新逻辑，代码如下，然后运行测试，绿色

```java
@Override
public String toString() {
    if (this.value % 3 == 0) return "Fizz";
    if (this.value % 5 == 0) return "Buzz";
    return String.valueOf(this.value);
}
```

* 重构：`提取函数`

`toString`内有2个`if`表达式重复了，可以提取出到1个函数里面，代码如下。

> 从此处开始省略`运行测试`的提示，每次代码改动结束后，都应该运行测试。

```java
@Override
public String toString() {
    if (isDivBy(3)) return "Fizz";
    if (isDivBy(5)) return "Buzz";
    return String.valueOf(this.value);
}

private boolean isDivBy(int i) {
    return this.value % i == 0;
}
```

### 第6组操作：实现第4条PBI

* 为该PBI添加测试数据

    测试方法的`CsvSource`内增加一条数据：`"15, FizzBuzz"`

* 快速让测试通过

    `FizzBuzz`类`toString`方法内增加新逻辑
    将光标移到到`isDivBy(5)`这一行，`Ctrl+C`选中该行，`Ctrl+D`复制选中内容到其之后，然后修改以适合PBI4。

```java
@Override
public String toString() {
    if (isDivBy(3)) return "Fizz";
    if (isDivBy(5)) return "Buzz";
    if (isDivBy(15)) return "FizzBuzz";
    return String.valueOf(this.value);
}
```

* 修复错误

    上述修改没有一次性使测试通过，输入15时，期望得到`FizzBuzz`，结果却是`Fizz`，说明出现了Bug。
    经查代码，可以快速发现该错误是第一条条件语句`if (isDivBy(3)) return "Fizz";`造成，要想正确处理，需要调整这几条条件语句的顺序，修改如下：

```java
@Override
public String toString() {
    if (isDivBy(15)) return "FizzBuzz";
    if (isDivBy(3)) return "Fizz";
    if (isDivBy(5)) return "Buzz";
    return String.valueOf(this.value);
}
```

* 重构：`消灭代码坏味道`

    `toString`方法里已经包含了4个条件判断的逻辑，可以预见后续迭代中，修改都会集中到该方法中，形成`Long Method`过长函数。
    该重构过程需要步骤较多，故单独形成一组操作。

### 第7组操作：重构过长函数

* 观察到4个条件语句具有相同的结构
    输入一个数字，输出一个字符串，只是判断的表达式不一样
* 明确该方法的职责
    该方法最终要返回一个字符串，说明这是其本职，判断逻辑可以委托出去
* 第一条判断逻辑看起来像是后俩条逻辑的组合，有点复杂，所以先动第二条逻辑，尝试委托出去

```java
@Override
public String toString() {
    if (isDivBy(15)) return "FizzBuzz";

    String result1 = ruleFizzResult();
    if (!result1.isEmpty()) return result1;

    if (isDivBy(5)) return "Buzz";

    return String.valueOf(this.value);
}

private String ruleFizzResult() {
    if (isDivBy(3)) return "Fizz";
    return "";
}
```

* 尝试委托第三条逻辑

```java
@Override
public String toString() {
    if (isDivBy(15)) return "FizzBuzz";

    String result1 = ruleFizzResult();
    if (!result1.isEmpty()) return result1;

    String result2 = ruleBuzzResult();
    if (!result2.isEmpty()) return result2;

    return String.valueOf(this.value);
}

private String ruleFizzResult() {
    if (isDivBy(3)) return "Fizz";
    return "";
}

private String ruleBuzzResult() {
    if (isDivBy(5)) return "Buzz";
    return "";
}
```

* 尝试组合实现第一条逻辑

```java
@Override
public String toString() {
    String result1 = ruleFizzResult();
    String result2 = ruleBuzzResult();

    if (!result1.isEmpty() && !result2.isEmpty()) {
        return result1 + result2;
    }

    if (!result1.isEmpty()) return result1;

    if (!result2.isEmpty()) return result2;

    return String.valueOf(this.value);
}
```

* 消除重复的对`resultx`的判断

```java
@Override
public String toString() {
    String result1 = ruleFizzResult();
    String result2 = ruleBuzzResult();

    String result = result1 + result2;

    if (!result.isEmpty()) return result;

    return String.valueOf(this.value);
}
```

* 消除对rule规则结果的重复获取

```java
@Override
public String toString() {

    String[] results = getAllRuleResult();

    String result = String.join("", results);

    if (!result.isEmpty()) return result;

    return String.valueOf(this.value);
}

private String[] getAllRuleResult() {
    String result1 = ruleFizzResult();
    String result2 = ruleBuzzResult();

    return new String[] {result1, result2};
}
```

* 继续理清`toString`的职责
    首先获取了所有`原子规则`的结果，
    接着应用`组合规则`，生成组合的结果，该结果也兼容了`原子规则`，
    最后是`默认规则`，但所有明确的规则都失效后才使用。
    对结果的处理可以`提取函数`为一个独立职责。

```java
@Override
public String toString() {
    String[] results = getAtomicRuleResult();
    return getComponentRuleResult(results);
}

private String getComponentRuleResult(String[] results) {
    String result = String.join("", results);

    if (!result.isEmpty()) return result;

    return String.valueOf(this.value);
}

// `重命名函数`为原则规则的结果
private String[] getAtomicRuleResult() {
    String result1 = ruleFizzResult();
    String result2 = ruleBuzzResult();

    return new String[] {result1, result2};
}
```

* 优化组合规则结果的操作逻辑

    使用[Collection Pipelines](https://martinfowler.com/articles/collection-pipeline/)，代替使用原始的逻辑判断`if`。

```java
private String getComponentRuleResult(String[] results) {
    return Arrays.stream(results)
        .filter(v -> !v.isEmpty())
        .reduce(String::concat)
        .orElse(String.valueOf(this.value));
}
```

* 优化原子规则获取结果操作

    使用`Inline Temp`将临时变量内联化。

```java
private String[] getAtomicRuleResult() {
    return new String[] {ruleFizzResult(), ruleBuzzResult()};
}
```

* 截止目前的重构结果

```java
@Override
public String toString() {
    String[] results = getAtomicRuleResult();
    return getComponentRuleResult(results);
}

private String[] getAtomicRuleResult() {
    return new String[] {ruleFizzResult(), ruleBuzzResult()};
}

private String getComponentRuleResult(String[] results) {
    return Arrays.stream(results)
        .filter(v -> !v.isEmpty())
        .reduce(String::concat)
        .orElse(String.valueOf(this.value));
}

private String ruleFizzResult() {
    if (isDivBy(3)) return "Fizz";
    return "";
}

private String ruleBuzzResult() {
    if (isDivBy(5)) return "Buzz";
    return "";
}

private boolean isDivBy(int i) {
    return this.value % i == 0;
}
```

### 第8组操作：分离`原子规则`职责

使用`Extract Class`提炼类

* 在`getAtomicRuleResult`中添加规则工厂的调用

```java
private String[] getAtomicRuleResult() {
    List<Executable> rules = Rules.all();
    return new String[] {ruleFizzResult(), ruleBuzzResult()};
}
```

* 使用`Alt+Enter`快速生成`Executable`接口、`Rules`类和`all`静态方法
* 使用新的实现替换旧的实现

```java
private String[] getAtomicRuleResult() {
    List<Executable> rules = Rules.all();
    return rules.stream()
            .map(rule -> rule.exec(this.value))
            .toArray(String[]::new);
}
```

* 使用`Alt+Enter`快速生成`Executable`接口的`exec`方法

```java
public interface Executable {
    String exec(int i);
}
```

* 实现`Rules.all`，添加创建规则的工厂类和方法调用

```java
public class Rules {

    public static List<Executable> all() {
        return Arrays.asList(
                DivRule.create(3, "Fizz"),
                DivRule.create(5, "Buzz")
        );
    }
}
```

* 使用`Alt+Enter`快速生成`DivRule`类和`create`方法
* 实现`create`方法和重载的`exec`方法，代码如下

```java
public class DivRule implements Executable {
    private int input;
    private final String output;

    public DivRule(int in, String out) {
        this.input = in;
        this.output = out;
    }

    public static Executable create(int in, String out) {
        return new DivRule(in, out);
    }

    @Override
    public String exec(int i) {
        if (i % this.input == 0) return this.output;
        return "";
    }
}
```

* 删除`FizzBuzz`中不需要的代码，剩余代码如下

```java
@Override
public String toString() {
    String[] results = getAtomicRuleResult();
    return getComponentRuleResult(results);
}

private String[] getAtomicRuleResult() {
    List<Executable> rules = Rules.all();
    return rules.stream()
            .map(rule -> rule.exec(this.value))
            .toArray(String[]::new);
}

private String getComponentRuleResult(String[] results) {
    return Arrays.stream(results)
        .filter(v -> !v.isEmpty())
        .reduce(String::concat)
        .orElse(String.valueOf(this.value));
}
```

* 重构`toString`使用`Inline Method`将函数内联化，消除额外的2个函数

```java
@Override
public String toString() {
    return Rules.all()
        .stream()
        .map(rule -> rule.exec(this.value))
        .filter(v -> !v.isEmpty())
        .reduce(String::concat)
        .orElse(String.valueOf(this.value));
}
```

## Over
