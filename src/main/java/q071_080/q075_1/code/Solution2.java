package q071_080.q075_1.code;

public class Solution2 {
    //双指针解决
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            while (nums[i] == 2 && i <= p2) {
                if(nums[i] != nums[p2]){
                    swap(nums, i, p2);
                }
                --p2;
            }
            if (nums[i] == 0) {
                if(nums[i] != nums[p0]) {
                    swap(nums, i, p0);
                }
                ++p0;
            }
        }
    }

    public static void swap(int nums[], int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 1};
        new Solution2().sortColors(nums);
        System.out.println();
    }
}