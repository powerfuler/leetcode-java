package q041_050.q041_1.code;

import java.util.HashSet;
import java.util.Set;

/**
 * 方法一：哈希表（空间复杂度不符合要求）
 * 按照刚才我们读例子的思路，其实我们只需从最小的正整数 1 开始，依次判断 2、 3、4直到数组的长度 N 是否在数组中；
 * 如果当前考虑的数不在这个数组中，我们就找到了这个缺失的最小正整数；
 * 由于我们需要依次判断某一个正整数是否在这个数组里，我们可以先把这个数组中所有的元素放进哈希表。接下来再遍历的时候，就可以O(1) 的时间复杂度判断某个正整数是否在这个数组；
 * 由于题目要求我们只能使用常数级别的空间，而哈希表的大小与数组的长度是线性相关的，因此空间复杂度不符合题目要求。
 *
 */
public class Solution3 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int i = 1; i <= len; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }
        return len + 1;
    }
}