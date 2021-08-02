package q041_050.q043_1.code;

/**
 * 时间复杂度：使用 `n` 和 `m` 分别代表两个数的长度。复杂度为 $O(n * m)$
 * 空间复杂度：使用了长度为 `m + n` 的数组存储结果。复杂度为 $O(n + m)$
 *
 */
public class Solution1 {
    public String multiply(String n1, String n2) {
        int n = n1.length(), m = n2.length();
        int[] res = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int a = n1.charAt(i) - '0';
                int b = n2.charAt(j) - '0';
                int r = a * b;
                r += res[i + j + 1];
                res[i + j + 1] = r % 10;
                res[i + j] += r / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n + m; i++) {
            if (sb.length() == 0 && res[i] == 0) continue;
            sb.append(res[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}