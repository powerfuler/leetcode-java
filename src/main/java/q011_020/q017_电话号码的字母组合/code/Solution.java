package q011_020.q017_电话号码的字母组合.code;

import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 * 题目大意
 * 给定一个数字串，返回数字上所有字符的所有组合，数字到字符的映射如上图所示。
 * 注意： 尽管上面的结果以字符顺序排列的，你可以以任何顺序返回结果。
 *
 * 解题思路
 * 用一个数组保存数字和字的映射关系，根据数字串的输入，找到对应的字符，组合结果。
 * </pre>
 */
public class Solution {

    private final static String[] S = {
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz",
    };


    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();

        if (digits == null || digits.length() < 1) {
            return result;
        }

        StringBuilder builder = new StringBuilder();
        letterCombinations(digits, 0, builder, result);

        return result;
    }

    private void letterCombinations(String digits, int index, StringBuilder builder, List<String> result) {
        if (index == digits.length()) {
            result.add(builder.toString());
            return;
        }

        String t = S[digits.charAt(index) - '2'];

        for (int i = 0; i < t.length(); i++) {
            builder.append(t.charAt(i));
            letterCombinations(digits, index + 1, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
