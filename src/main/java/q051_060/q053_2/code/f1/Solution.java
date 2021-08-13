package q051_060.q053_2.code.f1;

/**
 * 贪心法 遍历一次 o(n)
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = nums[0];
        int temp = sum;
        for (int i = 1; i < nums.length; i++) {
            temp = temp + nums[i];
            if (temp >= sum) {
                sum = temp;
            } else if (temp < 0) {
                temp = 0;
            }
            if (nums[i] > sum) {
                temp = nums[i];
                sum = nums[i];
            }
        }
        return sum;
    }

    /*class Solution
    {
        public:
        int maxSubArray(vector<int> &nums)
        {
            //类似寻找最大最小值的题目，初始值一定要定义成理论上的最小最大值
            int result = INT_MIN;
            int numsSize = int(nums.size());
            int sum = 0;
            for (int i = 0; i < numsSize; i++)
            {
                sum += nums[i];
                result = max(result, sum);
                //如果sum < 0，重新开始找子序串
                if (sum < 0)
                {
                    sum = 0;
                }
            }

            return result;
        }
    };
*/
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
