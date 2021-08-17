package q051_060.q058_1.code;

/**
 *
 *
 */
public class Solution1 {
    //
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int index = 0;
        int temp = 0;
        int p = s.length() - 1;
        while ((p - index >= 0) && s.charAt(p - index) == 32) index++;
        for (int i = p - index; i >= 0; i--) {
            if (s.charAt(i) != 32) {
                temp++;
                continue;
            }
            break;
        }
        return temp;
    }

    public int lengthOfLastWord1(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                len++;
            } else if (len != 0) {
                return len;
            }
        }
        return len;
    }

    public int lengthOfLastWord2(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().lengthOfLastWord1("The first version"));
    }
}