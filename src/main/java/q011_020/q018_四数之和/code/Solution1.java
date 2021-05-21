package q011_020.q018_四数之和.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *思路：
 *
 *  四数之和与前面三数之和的思路几乎是一样。（刚好前些天才写了三数之和的题解）
 *  如果前面的三数之和会做了的话，这里其实就是在前面的基础上多添加一个遍历的指针而已。
 *  会做三数之和的可以不用看下面的了。
 *
 *  使用四个指针(a<b<c<d)。固定最小的a和b在左边，c=b+1,d=_size-1 移动两个指针包夹求解。
 *  保存使得nums[a]+nums[b]+nums[c]+nums[d]==target的解。偏大时d左移，偏小时c右移。c和d相
 *  遇时，表示以当前的a和b为最小值的解已经全部求得。b++,进入下一轮循环b循环，当b循环结束后。
 *  a++，进入下一轮a循环。 即(a在最外层循环，里面嵌套b循环，再嵌套双指针c,d包夹求解)。
 * 准备工作：
 *
 *  因为要使用双指针的方法，排序是必须要做der~。 时间复杂度O(NlogN).
 * 解决重复解：
 *
 *  上面的解法存在重复解的原因是因为移动指针时可能出现重复数字的情况。所以我们要确保移动指针后，
 *  对应的数字要发生改变才行哦。
 * 时间复杂度：
 *
 * a遍历O(N)里嵌套b遍历O(N)再嵌套c,d双指针O(N)--> O(N^3)。 总比暴力法O(N^4)好些吧。
 *
 */
public class Solution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (len < 4) {
            return res;
        }
        // 对数组进行排序
        Arrays.sort(nums);
        // 最外层循环，从第一个元素到袋鼠第四个元素
        for (int first = 0; first <= len - 4; first++) {
            // 排除掉掉与前一个元素重复的元素
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // 第二个指针，从第二个元素开始，到倒数第三个元素结束
            for (int second = first + 1; second <= len - 3; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 第三、第四指针,两边夹
                int third = second + 1;
                int four = len - 1;
                while (third < four) {
                    if (third > second + 1 && nums[third] == nums[third - 1]) {
                        third++;
                        continue;
                    }
                    // 当前四个元素之和
                    int temp = nums[first] + nums[second] + nums[third] + nums[four];
                    if (temp > target) {
                        four--;
                    } else if (temp < target) {
                        third++;
                    } else {
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[first], nums[second], nums[third], nums[four])));
                        third++;
                        four--;
                    }
                }
            }
        }
        return res;
    }
}