package company.bytedance.q101_q200.q0149_1.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 解决方法：暴力法
 * 算法实现：
 * 利用斜率公式k = (y₂-y₁)/(x₁-x₂)判断是否在一条直线上，以k为key存储到Map结构中，遇到相等的k则使value+1。
 * 当k存在时至少有两点在一条直线上，所以key:k,value:2，value的初始值为2；或者初始值为1，最后求最大值时value+1。
 * 因为题目条件1 <= points.length <= 300，所以最少1个点在直线上。
 *
 * points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 */
public class Solution1 {
    public int maxPoints(int[][] ps) {
        int n = ps.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>(16);
            // 由当前点 i 发出的直线所经过的最多点数量
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                int x1 = ps[i][0], y1 = ps[i][1], x2 = ps[j][0], y2 = ps[j][1];
                int a = x1 - x2, b = y1 - y2;
                // 找最大公约数
                int k = gcd(a, b);
                String key = (a / k) + "_" + (b / k);
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            ans = Math.max(ans, max + 1);
        }
        return ans;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        int maxPoints = new Solution1().maxPoints(points);
        System.out.println(maxPoints);
    }
}