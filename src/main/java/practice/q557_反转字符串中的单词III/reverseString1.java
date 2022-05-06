package practice.q557_反转字符串中的单词III;

class Solution {
    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        String[] words = s.split(" ");
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < words.length; ++i) {
            answer.append(String.valueOf(' ') + reverseString(words[i]));
        }
        return answer.toString().trim();
    }

    public String reverseString(String s) {
        String ans = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            ans += String.valueOf(s.charAt(i));
        }
        return ans;
    }
}