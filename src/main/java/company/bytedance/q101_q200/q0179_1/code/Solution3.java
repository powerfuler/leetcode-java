package company.bytedance.q101_q200.q0179_1.code;

import java.util.Arrays;

class Solution3 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = "" + nums[i];
        }
        // 这里排序精髓
        Arrays.sort(ss, (a, b) -> {
            String sa = a + b, sb = b + a;
            return sb.compareTo(sa);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : ss) {
            sb.append(s);
        }
        int len = sb.length();
        int k = 0;
        while (k < len - 1 && sb.charAt(k) == '0') {
            k++;
        }
        return sb.substring(k);
    }

    public static void main(String[] args) {
//        int[] nums = {3, 30, 34, 5, 9};
        int[] nums = {0, 0, 0, 0, 0};
        String s = new Solution3().largestNumber(nums);
        System.out.println(s);
    }
}