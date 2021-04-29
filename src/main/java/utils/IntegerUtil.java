//@formatter:off
package utils;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;

/**
 * Created by Wentian Wang on 2017/9/28.
 */

public class IntegerUtil {

    public static int convert(Integer value) {
        return value == null ? 0 :value.intValue();
    }

    public static int convert(Integer value, Integer defaultValue) {
        return value == null ? defaultValue :value.intValue();
    }

    public static Integer convert(String value) {
        if(StringUtils.isBlank(value)) {
            return null;
        }
        return Integer.valueOf(value);
    }

    /**
     * 给定一个单精度的数字，获得整数部分(index : 0)和单精度的小数部分(index : 1)
     */
    public static Object[] getIntegerAndFloatPartFromFloat(Float separationTime) {
        Object[] objs = new Object[2];
        String s = separationTime.toString();
        objs[0] = Integer.parseInt(s.substring(0, s.indexOf(".")));
        objs[1] = Float.parseFloat("0" + s.substring(s.indexOf(".")));
        return objs;
    }

    /**
     * 判断一个string是否含有数字
     */

    public static boolean hasDigit(String iden) {
        char[] chars = iden.toCharArray();
        for(char c : chars){
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * 求两个区间的交集大小（不考虑开闭区间），使用迭代也可求多个区间交集，原理一样,
     */
    public static BigDecimal getIntersectionDecimal(BigDecimal start1,BigDecimal end1, BigDecimal start2, BigDecimal end2) {
        BigDecimal minEnd = null;
        if(end1==null && end2!=null){
            minEnd = end2;
        }else if(end1 !=null && end2 == null){
            minEnd = end1;
        }else if(end1 != null && end2!=null){
            minEnd = new BigDecimal(Math.min(end1.doubleValue(),end2.doubleValue()));
        }
        BigDecimal maxStart = null;
        if(start1==null && start2!=null){
            maxStart = start2;
        }else if(start1 !=null && start2 == null){
            maxStart = start1;
        }else if(start1 != null && start2!=null){
            maxStart = new BigDecimal(Math.max(end1.doubleValue(),end2.doubleValue()));
        }

        if(minEnd!=null && maxStart!=null){
            BigDecimal zero = new BigDecimal("0");

            BigDecimal subtract = minEnd.subtract(maxStart);
            if(subtract.compareTo(zero)==1){
                return subtract;
            }
        }
        return new BigDecimal("0");



    }
}
