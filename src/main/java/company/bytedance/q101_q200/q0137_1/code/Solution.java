package company.bytedance.q101_q200.q0137_1.code;

class Solution {
    public int singleNumber(int[] nums) {
        int one=0, two=0;
        for(int n:nums)
        {
            one = (one ^ n) & (~two);
            two = (two ^ n) & (~one);
        }
        return one;
    }
}