package q001_010.q006_Z字形变换.code;

import java.util.ArrayList;
import java.util.List;

/**
 *题目理解：
 * 1、字符串 s 是以 Z 字形为顺序存储的字符串，目标是按行打印。
 * 2、设 numRows 行字符串分别为 s1,s2,....sn，则容易发现：按顺序遍历字符串 s 时，每个字符 c 在 Z 字形中对应的 行索引 先从 s1
 * 增大至sn，再从 sn 减小至 s1…… 如此反复。
 * 3、因此，解决方案为：模拟这个行索引的变化，在遍历 s 中把每个字符填到正确的行 res[i] 。
 *
 *算法流程： 按顺序遍历字符串 s；
 * 1、res[i] += c： 把每个字符 c 填入对应行 si；
 * 2、i += flag： 更新当前字符 c 对应的行索引；
 * 3、flag = - flag： 在达到 Z 字形转折点时，执行反向。
 *
 *复杂度分析：
 * 时间复杂度 O(N) ：遍历一遍字符串 s；
 * 空间复杂度 O(N) ：各行字符串共占用 O(N) 额外空间。
 *
 */
public class Solution1 {
    public String convert(String s, int numRows) {
        if (numRows < 2)
            return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        // 初始化numRows个数组
        for (int i = 0; i < numRows; i++)
            rows.add(new StringBuilder());

        int i = 0, flag = -1; // 非常巧妙的设计，控制是往上走还是往下走
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            // i =0/numRows - 1的时候 走到了N的折点了，需要重新回来
            if (i == 0 || i == numRows - 1)
                flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows)
            res.append(row);
        return res.toString();
    }
}
