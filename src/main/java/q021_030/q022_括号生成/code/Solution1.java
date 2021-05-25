package q021_030.q022_括号生成.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归
 */
public class Solution1 {
    List<String> res = new ArrayList();
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return res;
        }
        recursion(0, 0, n, "");
        return res;
    }

    public void recursion(int left, int right, int n, String str) {
        if (left == n && right == n) {
            res.add(str);
            return;
        }
        if (left < n) {
            recursion(left + 1, right, n, str + "(");
        }
        if (right < left) {
            recursion(left, right + 1, n, str + ")");
        }
    }
}
