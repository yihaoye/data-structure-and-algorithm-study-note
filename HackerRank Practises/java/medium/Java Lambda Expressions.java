/*
This Java 8 challenge tests your knowledge of Lambda expressions!

Write the following methods that return a lambda expression performing a specified action:

1. PerformOperation isOdd(): The lambda expression must return true if a number is odd or false if it is even.
2. PerformOperation isPrime(): The lambda expression must return true if a number is prime or false if it is composite.
3. PerformOperation isPalindrome(): The lambda expression must return true if a number is a palindrome or false if it is not.
Input Format

Input is handled for you by the locked stub code in your editor.

Output Format

The locked stub code in your editor will print T lines of output.

Sample Input

The first line contains an integer, T (the number of test cases).

The T subsequent lines each describe a test case in the form of 2 space-separated integers:
The first integer specifies the condition to check for (1 for Odd/Even, 2 for Prime, or 3 for Palindrome). The second integer denotes the number to be checked.

5
1 4
2 5
3 898
1 3
2 12
Sample Output

EVEN
PRIME
PALINDROME
ODD
COMPOSITE
*/



// other's solution:
import java.io.*;
import java.util.*;
interface PerformOperation {
 boolean check(int a);
}
class MyMath {
 public static boolean checker(PerformOperation p, int num) {
  return p.check(num);
 }
 public static PerformOperation isOdd() {
  return num -> num%2 != 0;
 }
 public static PerformOperation isPrime() {
  return num -> java.math.BigInteger.valueOf(num).isProbablePrime(1);
 }
 public static PerformOperation isPalindrome() {
  return num -> Integer.toString(num).equals(new StringBuilder(Integer.toString(num)).reverse().toString());
 }
}

public class Solution {

 public static void main(String[] args) throws IOException {
  MyMath ob = new MyMath();
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int T = Integer.parseInt(br.readLine());
  PerformOperation op;
  boolean ret = false;
  String ans = null;
  while (T--> 0) {
   String s = br.readLine().trim();
   StringTokenizer st = new StringTokenizer(s);
   int ch = Integer.parseInt(st.nextToken());
   int num = Integer.parseInt(st.nextToken());
   if (ch == 1) {
    op = ob.isOdd();
    ret = ob.checker(op, num);
    ans = (ret) ? "ODD" : "EVEN";
   } else if (ch == 2) {
    op = ob.isPrime();
    ret = ob.checker(op, num);
    ans = (ret) ? "PRIME" : "COMPOSITE";
   } else if (ch == 3) {
    op = ob.isPalindrome();
    ret = ob.checker(op, num);
    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
   }
   System.out.println(ans);
  }
 }
}





/* Thinking in Java 5th 参考链接：https://lingcoder.github.io/OnJava8/#/book/13-Functional-Programming?id=lambda%e8%a1%a8%e8%be%be%e5%bc%8f */
// functional/LambdaExpressions.java
interface Description {
    String brief();
}
  
interface Body {
    String detailed(String head);
}
  
interface Multi {
    String twoArg(String head, Double d);
}
  
public class LambdaExpressions {
  
    static Body bod = h -> h + " No Parens!"; // [1]
  
    static Body bod2 = (h) -> h + " More details"; // [2]
  
    static Description desc = () -> "Short info"; // [3]
  
    static Multi mult = (h, n) -> h + n; // [4]
  
    static Description moreLines = () -> { // [5]
      System.out.println("moreLines()");
      return "from moreLines()";
    };
  
    public static void main(String[] args) {
      System.out.println(bod.detailed("Oh!"));
      System.out.println(bod2.detailed("Hi!"));
      System.out.println(desc.brief());
      System.out.println(mult.twoArg("Pi! ", 3.14159));
      System.out.println(moreLines.brief());
    }
}
/*
我们从三个接口开始，每个接口都有一个单独的方法（很快就会理解它的重要性）。但是，每个方法都有不同数量的参数，以便演示 Lambda 表达式语法。

任何 Lambda 表达式的基本语法是：

1. 参数。

2. 接着 ->，可视为“产出”。

3. -> 之后的内容都是方法体。

    [1] 当只用一个参数，可以不需要括号 ()。 然而，这是一个特例。

    [2] 正常情况使用括号 () 包裹参数。 为了保持一致性，也可以使用括号 () 包裹单个参数，虽然这种情况并不常见。

    [3] 如果没有参数，则必须使用括号 () 表示空参数列表。

    [4] 对于多个参数，将参数列表放在括号 () 中。

    到目前为止，所有 Lambda 表达式方法体都是单行。 该表达式的结果自动成为 Lambda 表达式的返回值，在此处使用 return 关键字是非法的。 这是 Lambda 表达式简化相应语法的另一种方式。

    [5] 如果在 Lambda 表达式中确实需要多行，则必须将这些行放在花括号中。 在这种情况下，就需要使用 return。

Lambda 表达式通常比匿名内部类产生更易读的代码，因此我们将在本书中尽可能使用它们。
*/

/*
递归
递归函数是一个自我调用的函数。可以编写递归的 Lambda 表达式，但需要注意：递归方法必须是实例变量或静态变量，否则会出现编译时错误。 我们将为每个案例创建一个示例。

这两个示例都需要一个接受 int 型参数并生成 int 的接口：
*/
// functional/IntCall.java
interface IntCall {
  int call(int arg);
}
// 整数 n 的阶乘将所有小于或等于 n 的正整数相乘。 阶乘函数是一个常见的递归示例：
// functional/RecursiveFactorial.java
public class RecursiveFactorial {
  static IntCall fact;
  public static void main(String[] args) {
    fact = n -> n == 0 ? 1 : n * fact.call(n - 1);
    for(int i = 0; i <= 10; i++)
      System.out.println(fact.call(i));
  }
}
// 这里，fact 是一个静态变量。 注意使用三元 if-else。 递归函数将一直调用自己，直到 i == 0。所有递归函数都有“停止条件”，否则将无限递归并产生异常。

// 我们可以将 Fibonacci 序列用递归的 Lambda 表达式来实现，这次使用实例变量：
// functional/RecursiveFibonacci.java
public class RecursiveFibonacci {
  IntCall fib;

  RecursiveFibonacci() {
    fib = n -> n == 0 ? 0 :
               n == 1 ? 1 :
               fib.call(n - 1) + fib.call(n - 2);
  }

  int fibonacci(int n) { return fib.call(n); }

  public static void main(String[] args) {
    RecursiveFibonacci rf = new RecursiveFibonacci();
    for(int i = 0; i <= 10; i++)
      System.out.println(rf.fibonacci(i));
  }
}
// 将 Fibonacci 序列中的最后两个元素求和来产生下一个元素。

// 方法引用
// 方法引用组成：类名或对象名，后面跟 :: ，然后跟方法名称。
// functional/MethodReferences.java
import java.util.*;

interface Callable { // [1]
  void call(String s);
}

class Describe {
  void show(String msg) { // [2]
    System.out.println(msg);
  }
}

public class MethodReferences {
  static void hello(String name) { // [3]
    System.out.println("Hello, " + name);
  }
  static class Description {
    String about;
    Description(String desc) { about = desc; }
    void help(String msg) { // [4]
      System.out.println(about + " " + msg);
    }
  }
  static class Helper {
    static void assist(String msg) { // [5]
      System.out.println(msg);
    }
  }
  public static void main(String[] args) {
    Describe d = new Describe();
    Callable c = d::show; // [6]
    c.call("call()"); // [7]

    c = MethodReferences::hello; // [8]
    c.call("Bob");

    c = new Description("valuable")::help; // [9]
    c.call("information");

    c = Helper::assist; // [10]
    c.call("Help!");
  }
}
/*
[1] 我们从单一方法接口开始（同样，你很快就会了解到这一点的重要性）。

[2] show() 的签名（参数类型和返回类型）符合 Callable 的 call() 的签名。

[3] hello() 也符合 call() 的签名。

[4] help() 也符合，它是静态内部类中的非静态方法。

[5] assist() 是静态内部类中的静态方法。

[6] 我们将 Describe 对象的方法引用赋值给 Callable ，它没有 show() 方法，而是 call() 方法。 但是，Java 似乎接受用这个看似奇怪的赋值，因为方法引用符合 Callable 的 call() 方法的签名。

[7] 我们现在可以通过调用 call() 来调用 show()，因为 Java 将 call() 映射到 show()。

[8] 这是一个静态方法引用。

[9] 这是 [6] 的另一个版本：对已实例化对象的方法的引用，有时称为绑定方法引用。

[10] 最后，获取静态内部类中静态方法的引用与 [8] 中通过外部类引用相似。
*/

// 在 Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量。

