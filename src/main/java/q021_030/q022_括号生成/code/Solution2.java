package q021_030.q022_括号生成.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先搜索(DFS)
 * dfs里面循环(StringBuffer字符串,"("出现次数，")"出现次数，题目的n)：
 * 1.剪枝if(r > l || l > n || r > n || l + r > 2 * n) return; （这些都不符合题意）
 * 2.l == n && r == n result.add(s.toString()); 此时加入结果List中
 * 3.l == n 此时"("数量够了，只加")"
 * 4.l == r 此时"("、")"数量相同，只加"("
 * 5.其他,此时"("数量 > ")"数量，"("、")"都可以加
 *
 */
public class Solution2 {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuffer s = new StringBuffer();
        dfs(s, 0, 0, n);
        return result;
    }

    public void dfs(StringBuffer s, int left, int right, int n) {
        if (right > left || left > n || right > n || left + right > 2 * n) {
            return;
        } else if (left == n && right == n) {
            result.add(s.toString());
        } else if (left == n) {
            s.append(")");
            dfs(s, left, right + 1, n);
            s.deleteCharAt(left + right);
        } else if (left == right) {
            s.append("(");
            dfs(s, left + 1, right, n);
            s.deleteCharAt(left + right);
        } else {
            s.append(")");
            dfs(s, left, right + 1, n);
            s.deleteCharAt(left + right);
            s.append("(");
            dfs(s, left + 1, right, n);
            s.deleteCharAt(left + right);
        }
    }
}