package practice.q367_有效的完全平方数;

/**
 *
 *
 */
class Solution1 {
    public boolean isPerfectSquare1(int num) {
        for (int i = 0; i <= num; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
        // 超时，数值比较大溢出
        // 时间复杂度：O(n)
    }

    public boolean isPerfectSquare2(int num) {
        if (num == 0 || num == 1) return true;
        int left = 0;
        int right = num;
        int mid;
        int sqrt;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            // 考虑溢出 mid * mid *会溢出 /、% 不会溢出
            sqrt = num / mid;
            if (sqrt == mid && num % mid == 0) {
                return true;
            } else if (mid < sqrt) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return false;
//         时间复杂度：O(log{n})
//         空间复杂度：O(1)
    }

    public boolean isPerfectSquare3(int num) {
        // 等差数列 n^2 = 1+3+5+..+2n-1 = n(a1+an)/2 = n(1+2n-1)/2
        int n = 1;
        while (num > 0) {
            // 依次递减
            num -= n;
            n += 2;
        }
        return num == 0;
        // 时间复杂度：O(n)
    }


    public static void main(String[] args) {
        System.out.println(new Solution1().isPerfectSquare2(5));
        double sqrt = Math.sqrt(808201);
        System.out.println(sqrt);
    }
}