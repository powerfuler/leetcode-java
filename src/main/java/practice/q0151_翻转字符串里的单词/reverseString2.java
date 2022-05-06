package practice.q0151_翻转字符串里的单词;

class Solution {
    public String reverseWords(String s) {
        // write your code here
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].trim().equals("")) {
                continue;
            }
            sb.append(words[i] + " ");
        }
        return sb.toString().trim();
    }
}