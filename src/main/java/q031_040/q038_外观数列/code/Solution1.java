package q031_040.q038_外观数列.code;

/**
 * 比较字符串的当前位 i 与上一位 i - 1 是否相等，StringBuffer对象res表示描述结果，
 * 以“区间”表示每一段由连续相同字符组成的字符串：
 * 1、相等：计数器num加1。特殊情况：若已到达字符串最后一位，此时还需将num和当前字符加入res。
 * 2、不相等：说明上一段区间已遍历完成，需要把上一段区间的num和字符加入res。特殊情况：若已到达字符串最后一位，
 * 还需把最后一位字符加入res。
 *
 *
 */
public class Solution1 {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 0;i < n - 1;i++){
            s = describe(s);
        }
        return s;
    }
    public String describe(String s){
        StringBuffer res = new StringBuffer();
        if(s.length() == 1){
            res.append('1');
            res.append(s);
        }
        int num = 1;
        for(int i = 1;i < s.length();i++){
            if(s.charAt(i) == s.charAt(i - 1)){
                num += 1;
                if(i == s.length() - 1){
                    res.append(num);
                    res.append(s.charAt(i - 1));
                }
            }
            else{
                res.append(num);
                res.append(s.charAt(i - 1));
                num = 1;
                if(i == s.length() - 1){
                    res.append(1);
                    res.append(s.charAt(i));
                }
            }
        }
        return res.toString();
    }
}