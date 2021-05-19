package q011_020.q014_最长公共前缀.code;

/**
 * 思路
 * 标签：链表
 * 当字符串数组长度为 0 时则公共前缀为空，直接返回
 * 令最长公共前缀 ans 的值为第一个字符串，进行初始化
 * 遍历后面的字符串，依次将其与 ans 进行比较，两两找出公共前缀，最终结果即为最长公共前缀
 * 如果查找过程中出现了 ans 为空的情况，则公共前缀不存在直接返回
 * 时间复杂度：O(s)，s 为所有字符串的长度之和
 *
 */

class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if(ans.equals("")) {
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] s = new String[]{"abedef3","abcdef2222323", "abcdef3"};
        System.out.println(new Solution1().longestCommonPrefix(s));
    }
}