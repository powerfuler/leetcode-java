package company.bytedance.q101_q200.q0165_1.code;

/**
 *
 *
 */
public class Solution1 {
    // 使用spilt切分切分字符串
    public int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");

        for (int n = 0; n < Math.max(a1.length, a2.length); n++) {
            int i = (n < a1.length ? Integer.valueOf(a1[n]) : 0);
            int j = (n < a2.length ? Integer.valueOf(a2[n]) : 0);
            if (i < j) {
                return -1;
            } else if (i > j) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = new Solution1().compareVersion("7.5.2.4", "7.5.3");
        System.out.println(i);
    }
}