package company.bytedance.q101_q200.q0166_2.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 就是用哈希表记录所有被除数的下标，如果出现了重复的被除数，则证明出现了循环，把左括号塞到记录的下标位置，右括号放在最后
 *
 */
public class Solution1 {
        public String fractionToDecimal(int numerator, int denominator) {
            StringBuilder sb = new StringBuilder();
            long a = numerator, b = denominator;
            if (a > 0 && b < 0 || a < 0 && b > 0) sb.append('-');
            a = Math.abs(a);
            b = Math.abs(b);
            sb.append(a / b);
            if (a % b == 0) return sb.toString();
            sb.append('.');
            Map<Long, Integer> map = new HashMap<>();
            while ((a = (a % b) * 10) > 0 && !map.containsKey(a)) {
                map.put(a, sb.length());
                sb.append(a / b);
            }
            if (a == 0) return sb.toString();
            return sb.insert(map.get(a).intValue(), '(').append(')').toString();
        }
}