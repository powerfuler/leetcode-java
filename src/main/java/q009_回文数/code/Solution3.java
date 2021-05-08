package q009_回文数.code;

// 简单粗暴，看看就行
public class Solution3 {
    public boolean isPalindrome(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int str = 2147;
        boolean palindrome = solution.isPalindrome(str);
        System.out.println(palindrome);
    }
}