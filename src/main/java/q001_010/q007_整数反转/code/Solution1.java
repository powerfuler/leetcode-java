package q001_010.q007_整数反转.code;

/**
 * 转成String o(n) 捕获异常判断是否溢出
 * <pre>
 * 原题
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * 题目大意
 * 输入一个整数对其进行翻转
 *
 * 解题思路
 * 通过求余数求商法进行操作。
 * </pre>
 */
public class Solution1 {
    public int reverse(int x) {
        long tmp = x;
        // 防止结果溢出
        long result = 0;
        while (tmp != 0) {
            result = result * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        // 溢出判断
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            result = 0;
        }
        return (int) result;
    }
}
