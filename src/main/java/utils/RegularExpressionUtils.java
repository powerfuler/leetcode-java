//@formatter:off
package utils;

import java.util.regex.Pattern;

/**
 * Created by Wentian Wang on 2018/4/10.
 */

public class RegularExpressionUtils {
//    static String chinesePhoneRegex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0-9])|(17[0-9]))\\d{8}$";
    //新电话号码校验 fixed issue-60154 mqx
    static String chinesePhoneRegex = "^1[3456789]\\d{9}$";
    public static final boolean isValidChinesePhone(String phoneNum){
        Pattern pattern = Pattern.compile(chinesePhoneRegex);
        return pattern.matcher(phoneNum).matches();
    }
}
