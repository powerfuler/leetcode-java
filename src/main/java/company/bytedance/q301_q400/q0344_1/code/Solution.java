package company.bytedance.q301_q400.q0344_1.code;

class Solution {
    public void reverseString(char[] s) {
        int length = s.length;
        int right = length - 1;
        for (int left = 0; left <= right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{};
        new Solution().reverseString(s);
    }
}