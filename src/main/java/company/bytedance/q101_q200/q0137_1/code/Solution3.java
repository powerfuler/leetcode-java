package company.bytedance.q101_q200.q0137_1.code;

import java.util.HashMap;
import java.util.Map;

/**
 *  一个朴素的做法是使用「哈希表」进行计数，然后将计数为 $1$ 的数字进行输出。
 *  哈希表以「数值 : 数值出现次数」形式进行存储。
 */
public class Solution3 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int x : map.keySet()) {
            if (map.get(x) == 1) return x;
        }
        return -1;
    }
}