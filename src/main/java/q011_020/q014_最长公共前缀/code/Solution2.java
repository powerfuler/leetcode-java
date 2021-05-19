package q011_020.q014_最长公共前缀.code;

/**
 * 水平扫描 o(n)
 */
public class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String pre = "";
        int i = 0;
        while (true) {
            if (strs[0].length() == i) {
                return pre;
            }
            char temp = strs[0].charAt(i);
            for (int k = 1; k < strs.length; k++) {
                if (strs[k].length() == i || temp != strs[k].charAt(i)) {
                    return pre;
                }
            }
            pre += temp;
            i++;
        }
    }

    public static void main(String[] args) {
        String[] s = new String[]{"abedef3","abcdef2222323", "abcdef3"};
        System.out.println(new Solution2().longestCommonPrefix(s));
    }
}
