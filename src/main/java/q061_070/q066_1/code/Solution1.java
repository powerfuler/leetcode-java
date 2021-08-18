package q061_070.q066_1.code;

/**
 *
 *
 */
public class Solution1 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        //从数组末尾开始向前遍历
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                digits[i]++;
                //没有进位，直接返回
                return digits;
            }
            //产生进位，需要将该位赋值为 0
            digits[i] = 0;
        }
        //整体产生了进位，数组长度需要变化加 1
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }

    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] A = new int[]{9, 9, 9, 9, 9};
        int[] ints = new Solution1().plusOne1(A);
        System.out.println(ints);
    }
}