package practice.q069_x的平方根;

/**
 * 牛顿迭代法
 * 下面这种方法可以很有效地求出根号 a 的近似值：
 * 首先随便猜一个近似值 x，然后不断令 x 等于 x 和 a/x 的平均数，迭代个六七次后 x 的值就已经相当精确了。
 */
public class Solution1 {
    public int mySqrt(int x) {
        long n = x;
        while (n * n > x) {
            n = (n + x / n) >> 1;
        }
        return (int) n;
    }
}