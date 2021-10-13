package company.bytedance.q101_q200.q0118_1.code;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public List<Integer> getRow(int idx) {
        int[][] f = new int[idx + 1][idx + 1];
        f[0][0] = 1;
        for (int i = 1; i < idx + 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                f[i][j] = f[i - 1][j];
                if (j - 1 >= 0) {
                    f[i][j] += f[i - 1][j - 1];
                }
                if (f[i][j] == 0) {
                    f[i][j] = 1;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < idx + 1; i++) {
            ans.add(f[idx][i]);
        }
        return ans;
    }
}