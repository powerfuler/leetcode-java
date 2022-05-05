package practice.q342_4的幂;

class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && ((n & 0xaaaaaaaa) == 0) && ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfFour(-16));
    }
}