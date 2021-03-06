package q011_020.q016_最接近的三数之和.code;

import java.util.Arrays;

/**
 *
 *本题与 15. 三数之和 非常类似，可以使用「双指针」的方法来解决。
 *
 * 排序 + 双指针
 * 思路与算法
 *
 * 题目要求找到与目标值 target 最接近的三元组，这里的「最接近」即为差值的绝对值最小。
 * 我们可以考虑直接使用三重循环枚举三元组，找出与目标值最接近的作为答案，时间复杂度为 O(N^3)。然而本题的 N 最大为 10001000，会超出时间限制。
 *
 * 那么如何进行优化呢？
 * 我们首先考虑枚举第一个元素 a，对于剩下的两个元素 b 和 c，我们希望它们的和最接近 target−a。
 * 对于 b 和 c，如果它们在原数组中枚举的范围（既包括下标的范围，也包括元素值的范围）没有任何规律可言，那么我们还是只能使用两重循环来枚举所有的可能情况。
 * 因此，我们可以考虑对整个数组进行升序排序，这样一来：
 *
 * 	假设数组的长度为 n，我们先枚举 a，它在数组中的位置为 i；
 * 	为了防止重复枚举，我们在位置 [i+1, n) 的范围内枚举 b 和 c。
 *
 * 当我们知道了 b 和 c 可以枚举的下标范围，并且知道这一范围对应的数组元素是有序（升序）的，那么我们是否可以对枚举的过程进行优化呢？
 *
 * 借助双指针，我们就可以对枚举的过程进行优化。
 * 我们用 pb和pc分别表示指向 b 和 c 的指针，初始时，pb指向位置 i+1，即左边界；pc指向位置n−1，即右边界。
 * 在每一步枚举的过程中，我们用 a+b+c 来更新答案，并且：
 *
 * 	如果 a+b+c≥target，那么就将 pc向左移动一个位置；
 * 	如果 a+b+c<target，那么就将 pb向右移动一个位置。
 *
 * 这是为什么呢？
 * 我们对 a+b+c≥target 的情况进行一个详细的分析：
 * 如果 a+b+c≥target，并且我们知道 pb到 pc这个范围内的所有数是按照升序排序的，那么如果 pc不变而 pb向右移动，那么 a+b+c 的值就会不断地增加，显然就不会成为最接近 target 的值了。因此，我们可以知道在固定了 pc的情况下，此时的 pb​就可以得到一个最接近 target 的值，那么我们以后就不用再考虑 pc了，就可以将 pc向左移动一个位置。
 *
 * 同样地，在 a+b+c<target 时：
 * 如果 a+b+c<target，并且我们知道 pb到 pc这个范围内的所有数是按照升序排序的，那么如果 pb不变而 pc向左移动，那么 a+b+c的值就会不断地减小，显然就不会成为最接近 target 的值了。因此，我们可以知道在固定了 pb的情况下，此时的 pc就可以得到一个最接近 target 的值，那么我们以后就不用再考虑 pb了，就可以将 pb向右移动一个位置实际上，pb和pc就表示了我们当前可以选择的数的范围，而每一次枚举的过程中，我们尝试边界上的两个元素，根据它们与 target 的值的关系，选择「抛弃」左边界的元素还是右边界的元素，从而减少了枚举的范围。这种思路与 11. 盛最多水的容器 中的双指针解法也是类似的。
 *
 * 优化
 * 1、本题也有一些可以减少运行时间（但不会减少时间复杂度）的小优化。当我们枚举到恰好等于 target 的 a+b+c 时，可以直接返回 target 作为答案，因为不会有再比这个更接近的值了。
 * 2、另一个优化与 15. 三数之和的官方题解 中提到的类似。当我们枚举 a, b, c 中任意元素并移动指针时，可以直接将其移动到下一个与这次枚举到的不相同的元素，减少枚举的次数。
 *
 *
 * 复杂度分析
 *
 * 时间复杂度：O(N 2)，其中 N 是数组 nums 的长度。我们首先需要 O(NlogN) 的时间对数组进行排序，随后在枚举的过程中，使用一重循环 O(N) 枚举 a，双指针 O(N) 枚举 b 和 c，故一共是 O(N^2)。
 *
 * 空间复杂度：O(logN)。排序需要使用 O(logN) 的空间。然而我们修改了输入的数组 nums，在实际情况下不一定允许，因此也可以看成使用了一个额外的数组存储了 nums 的副本并进行排序，此时空间复杂度为 O(N)。
 *
 *
 */

public class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
//        int size = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < nums.length - 2; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = right - 1;
                    // 移动到下一个不相等的元素
                    while (left < k0 && nums[k0] == nums[right]) {
                        --k0;
                    }
                    right = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = left + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < right && nums[j0] == nums[left]) {
                        ++j0;
                    }
                    left = j0;
                }
            }
        }
        return best;
    }
}
