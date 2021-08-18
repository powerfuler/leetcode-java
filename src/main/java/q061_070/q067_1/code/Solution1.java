package q061_070.q067_1.code;

/**
 *整体思路是将两个字符串较短的用 00 补齐，使得两个字符串长度一致，然后从末尾进行遍历计算，得到最终结果。
 *
 * 本题解中大致思路与上述一致，但由于字符串操作原因，不确定最后的结果是否会多出一位进位，所以会有 2 种处理方式：
 *
 * 第一种，在进行计算时直接拼接字符串，会得到一个反向字符，需要最后再进行翻转
 * 第二种，按照位置给结果字符赋值，最后如果有进位，则在前方进行字符串拼接添加进位
 * 时间复杂度：O(n)
 *
 */
public class Solution1 {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        // 记录进位
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String s = new Solution1().addBinary("11011", "101");
        System.out.println(s);
    }

}