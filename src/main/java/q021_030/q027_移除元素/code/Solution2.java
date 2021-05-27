package q021_030.q027_移除元素.code;

/**
 * 本解法的思路与 26. 删除排序数组中的重复项 中的「通用解法」类似。
 * 先设定变量 idx，指向待插入位置。idx 初始值为 0
 * 然后从题目的「要求/保留逻辑」出发，来决定当遍历到任意元素 x 时，应该做何种决策：
 * 如果当前元素 x 与移除元素 val 相同，那么跳过该元素。
 * 如果当前元素 x 与移除元素 val 不同，那么我们将其放到下标 idx 的位置，并让 idx 自增右移。
 * 最终得到的 idx 即是答案。
 *
 */
public class Solution2 {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int x : nums) {
            if (x != val) {
                nums[idx++] = x;
            }
        }
        return idx;
    }
}
class Solution {
    public int removeElement(int[] nums, int val) {
        int ans = 0;
        for(int num: nums) {
            if(num != val) {
                nums[ans] = num;
                ans++;
            }
        }
        return ans;
    }
}