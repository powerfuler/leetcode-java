package company.bytedance.q101_q200.q0131_1.code;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        dfs(s, new ArrayList<String>(), 0);
        return res;
    }

    public void dfs(String s, List<String> remain, int left) {
        //判断终止条件
        if (left == s.length()) {
            //添加到结果中
            res.add(new ArrayList<String>(remain));
            return;
        }
        //从left开始，依次判断left->right是不是回文串
        for (int right = left; right < s.length(); right++) {
            //判断是否是回文串
            if (isPalindroom(s, left, right)) {
                //添加到当前回文串到list中
                remain.add(s.substring(left, right + 1));
                //从right+1开始继续递归，寻找回文串
                dfs(s, remain, right + 1);
                //回溯，从而寻找更长的回文串
                remain.remove(remain.size() - 1);
            }
        }
    }

    /**
     * 判断是否是回文串
     */
    public boolean isPalindroom(String s, int left, int right) {
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return left >= right;
    }
}