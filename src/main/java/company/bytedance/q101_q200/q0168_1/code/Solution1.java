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

    /**
     *  171. Excel 表列序号
     * @param columnTitle
     * @return
     */
    public int TitleToNumber(String columnTitle) {
        int res = 0;
        int length = columnTitle.length();
        for(int i = 0; i< length; i++) {
            char c = columnTitle.charAt(i);
            res = res * 26 + (c - 'A') + 1;
        }
        return res;
    }

    public static void main(String[] args) {

        int s = new Solution1().TitleToNumber("AB");
        System.out.println(s);

//        String s = new Solution1().convertToTitle(28);
//        System.out.println(s);
    }
}