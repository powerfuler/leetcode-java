package company.bytedance.q101_q200.q0165_1.code;

public class Solution2 {
    // 使用字符串
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int v1Len = version1.length(), v2Len = version2.length();
        while (i < v1Len || j < v2Len) {
            int a = 0, b = 0;
            while (i < v1Len && version1.charAt(i) != '.') {
                a = a * 10 + version1.charAt(i) - '0';
                i++;
            }
            while (j < v2Len && version2.charAt(j) != '.') {
                b = b * 10 + version2.charAt(j) - '0';
                j++;
            }

            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }

            i++;
            j++;
        }

        return 0;
    }

    public static void main(String[] args) {
        int i = new Solution2().compareVersion("7.52.2.4", "7.51.3");
        System.out.println(i);
    }
}