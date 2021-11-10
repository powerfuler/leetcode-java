package company.bytedance.q101_q200.q0187_1.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 滑动窗口 + 哈希表
 */
public class Solution1 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i + 10 <= n; i++) {
            String cur = s.substring(i, i + 10);
            int cnt = map.getOrDefault(cur, 0);
            if (cnt == 1)
                ans.add(cur);
            map.put(cur, cnt + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> resp = new Solution1().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(resp);
    }
}