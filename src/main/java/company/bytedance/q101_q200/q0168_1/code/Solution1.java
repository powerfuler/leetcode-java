package company.bytedance.q101_q200.q0168_1.code;

/**
 *
 * 进制转换
 */
public class Solution1 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new Solution1().convertToTitle(28);
        System.out.println(s);
    }
}