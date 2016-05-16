/*
There are two main differences between Recursion and an Iterative Version of the same algorithm.

First of all, some times it is almost better to understand a recursive algorithm than an iterative one (At least if you are experienced programmer) So it does increase expressivity and in some cases readability (It might also lead to the exact opposite in other cases)

Expresivity is a huge deal on programming languages and be able to write the same code in 5 lines instead of 20 is a huge deal.

On the downside, it decreases the performance of your code. Recursive functions have to keep the function records in memory and jump from one memory address to another to be invoked to pass parameters and return values. That makes them very bad performance wise.

Sum Up:

Iterative Algorithms = Fast Performance but hard to write (sometimes hard to read too)

Recursive Algorithms = Fast to write but Bad performance wise (Sometimes easier to understand too)
*/

//Take this example:

public static long fib(long n) {
    if (n <= 1) return n;
    else return fib(n-1) + fib(n-2);
}

//vs

    if ((n == 1) || (n == 2)) {
        return 1;
    } else {
        long prev = 1, current = 1, next = 0;
        for (long i = 3; i <= n; i++) {
            next = prev + current;
            prev = current;
            current = next;
        }
        return next;
    }









/*
递归指一个函数（或者一个过程）引用他自身。想学会递归，你先要学会递归…… <--不好意思这是个错误示范，因为这个过程要调用自身无限次并导致爆栈。

迭代指重复地将一个函数输出的结果作为输入再启动这个函数，你会很明显看到代码中有循环。

例如，用两种方法实现阶乘功能。
*/

//递归写法：
int f(int n)
{
if (n==1) return 1;
else return f(n-1)*n; //递归
}

//迭代写法：
int f(int n)
{
int result = 1;
for(int k=1;k<=n;++k)
result = result * k;//迭代
return result;
}

//更多时候，两者各有使用领域，并不能互相替代。

//递归允许在函数里多次引用自身，例如快速排序算法要用递归来实现：
void qsort(int* array, int start,int end)
{
if (end-start<=1) return;
//任意选定一个单元x，将小于x的单元移动到x左边，大于x的单元移动到x右边，x最终移动到位置middle
qsort(array, start, middle); //递归调用第一次
qsort(array, middle, end); //递归调用第二次
}

//又例如，斐波那契数列是用递归来定义的：
f(0)=0;
f( 1)=1;
f(n)=f(n-1)+f(n-2)
//但如果你写成递归，那n比较大时会发生悲剧（思考题：为什么？），一般要把这个函数写成迭代：
int f(int n)
{
int a[100];
a[0]=0;
a[1]=1;
for (int k=2;k<=n;k++)
a[k]=a[k-1]+a[k-2]; //迭代
return a[n];
}






/*
递归就是在定义的时候引用自己。比如说  f:= g(f)
迭代就是在使用的时候重复。比如说    f(f(f(f(x))))
一般迭代都可以写成递归。
*/