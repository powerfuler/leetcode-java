package company.bytedance.q0169_1.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表法
 *
 * 这个问题可以视为查找问题，对于查找问题往往可以使用时间复杂度为 O(1) 的 **哈希表**，通过以空间换时间的方式进行优化。
 * 直接遍历整个 **数组** ，将每一个数字（num）与它出现的次数（count）存放在 **哈希表** 中，同时判断该数字出现次数是否是最大的，动态更新 maxCount，最后输出 maxNum。
 *
 * **时间复杂度**：O(n)
 * **空间复杂度**：O(n)
 */
public class Solution2 {
    public int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    // maxNum 表示元素，maxCount 表示元素出现的次数,找到了出现最多的字符
    int maxNum = 0, maxCount = 0;
    for (int num: nums) {
      int count = map.getOrDefault(num, 0) + 1;
      map.put(num, count);
      if (count > maxCount) {
        maxCount = count;
        maxNum = num;
      }
    }
    return maxNum;
  }
}