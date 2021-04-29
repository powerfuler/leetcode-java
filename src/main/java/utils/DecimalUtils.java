//@formatter:off
package utils;

import java.math.BigDecimal;

/**
 * Created by Wentian Wang on 2018/5/29.
 */

public class DecimalUtils {
    private static final BigDecimal zero = new BigDecimal("0");
    public static BigDecimal negativeValueFilter(BigDecimal amountReceivable) {
        if(amountReceivable == null) {
            return new BigDecimal("0");
        }
        if(amountReceivable.compareTo(zero) == -1){
            return new BigDecimal("0");
        }
        return amountReceivable;
    }
}
