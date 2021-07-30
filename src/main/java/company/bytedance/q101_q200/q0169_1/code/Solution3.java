package company.bytedance.q101_q200.q0169_1.code;

/**
 * ## 解法一：暴力解法
 *
 * 遍历整个数组，同时统计每个数字出现的次数。
 * 最后将出现次数大于一半的元素返回即可。
 */
class Solution3 {
    public int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;
        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }
            if (count > majorityCount) {
                return num;
            }
        }
        return 0;
    }
}