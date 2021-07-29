package company.bytedance.q0169_1.code;

/**
 *摩尔投票法
 *
 * 再来回顾一下题目：寻找数组中超过一半的数字，这意味着数组中**其他数字出现次数的总和都是比不上这个数字出现的次数** 。
 *
 * 即如果把 该众数记为 `+1` ，把其他数记为 `−1` ，将它们全部加起来，和是大于 0 的。
 *
 * 所以可以这样操作：
 *
 * * 设置两个变量  candidate 和 count，**candidate** 用来保存数组中遍历到的某个数字，**count** 表示当前数字的出现次数，一开始 **candidate** 保存为数组中的第一个数字，**count** 为 1
 * * 遍历整个数组
 * * 如果数字与之前 **candidate** 保存的数字相同，则 **count** 加 1
 * * 如果数字与之前 **candidate** 保存的数字不同，则 **count** 减 1
 * * 如果出现次数 **count** 变为 0 ，**candidate** 进行变化，保存为当前遍历的那个数字，并且同时把 **count** 重置为 1
 * * 遍历完数组中的所有数字即可得到结果
 *
 * **时间复杂度**：O(n)
 * **空间复杂度**：O(1)
 */
public class Solution1 {
    public int majorityElement(int[] nums) {
        int candidate = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}