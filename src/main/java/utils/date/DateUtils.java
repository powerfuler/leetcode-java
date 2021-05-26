package utils.date;

import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class DateUtils {
    //取当前时间，只取到小时
    public static final String HOUR_FORMAT_STRING = "yyyy-MM-dd HH";
    private static final String ISO_LOCAL_DATE_PATTERN = "yyyyMMdd";

    public static final DateTimeFormatter ISO_LOCAL_DATE = DateTimeFormatter.ofPattern(ISO_LOCAL_DATE_PATTERN);

    public static Date getCurrentHour() {
        return formatHour(DateHelper.currentGMTTime());
    }

    public static Date formatHour(Date srcDate) {
        SimpleDateFormat format = new SimpleDateFormat(HOUR_FORMAT_STRING);
        // 不要用这个方法来转时间，会错位
//    	Date now = DateHelper.parseDataString(format.format(DateHelper.currentGMTTime()), formatString);
        Date date = null;
        try {
            date = format.parse(format.format(srcDate));
        } catch (Exception e) {
            date = new Date();
        }
        return date;
    }

    public static Timestamp getLaterTime(Timestamp time1, Timestamp time2) {
        if (time1 != null) {
            if (time2 == null) {
                return time1;
            }
            if (time1.after(time2)) {
                return time1;
            }
        }
        return time2;
    }

    public static Timestamp currentTimestamp() {
        return Timestamp.from(Instant.now());
    }

    /**
     * 将不明格式的日期转给指定格式的日期，如果所提供日期不是有效输入，返回null by wentian 2018/3/29
     * @param dateStr 不明格式的日期
     */
    public static String guessDateTimeFormatAndFormatIt(String dateStr, String desired_format) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        // excel的写入和获取没有考虑日期格式问题，以恶心代码来应对恶心代码
        SimpleDateFormat yyyyMMddDash = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat yyyyMMDash = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat yyyyMM = new SimpleDateFormat("yyyy/MM");
        SimpleDateFormat mdyy = new SimpleDateFormat("M/d/yy");
        SimpleDateFormat myy = new SimpleDateFormat("M/yy");
        SimpleDateFormat request = new SimpleDateFormat(desired_format);


        String yyyyMMddDash_ = "^\\d{4}-\\d{2}-\\d{2}$";                 // 2018-02-12
        String yyyyMMdd_ = "^\\d{4}/\\d{2}/\\d{2}$";                // 2018/12/31
        String yyyyMMDash_ = "^\\d{4}-\\d{2}$";                      // 2018-02
        String yyyyMM_ = "^\\d{4}/\\d{2}$";                   // 2018/12
        String mdyy_ = "^\\d{1,2}/\\d{1,2}/\\d{2}$";            // 3/1/18
        String myy_ = "^\\d{1,2}/\\d{2}$";            // 3/18
        Pattern pattern1 = Pattern.compile(yyyyMMddDash_);
        Pattern pattern2 = Pattern.compile(yyyyMMdd_);
        Pattern pattern3 = Pattern.compile(yyyyMMDash_);
        Pattern pattern4 = Pattern.compile(yyyyMM_);
        Pattern pattern5 = Pattern.compile(mdyy_);
        Pattern pattern6 = Pattern.compile(myy_);

        Date q = null;
        String formatted = dateStr;
        try {
            if (pattern1.matcher(dateStr).matches()) {
                q = yyyyMMddDash.parse(dateStr);
            } else if (pattern2.matcher(dateStr).matches()) {
                q = yyyyMMdd.parse(dateStr);
            } else if (pattern3.matcher(dateStr).matches()) {
                q = yyyyMMDash.parse(dateStr);
            } else if (pattern4.matcher(dateStr).matches()) {
                q = yyyyMM.parse(dateStr);
            } else if (pattern5.matcher(dateStr).matches()) {
                q = mdyy.parse(dateStr);
            } else if (pattern6.matcher(dateStr).matches()) {
                q = myy.parse(dateStr);
            } else {
                return null;
            }
            formatted = request.format(q);
            return formatted;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将不明格式的日期转给指定格式的日期，如果所提供日期不是有效输入，返回null by wentian 2018/3/29
     * @param dateStr 不明格式的日期
     */
    public static Calendar guessDateTimeFormatAndParse(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        // excel的写入和获取没有考虑日期格式问题，以恶心代码来应对恶心代码
        SimpleDateFormat yyyyMMddDash = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat yyyyMMDash = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat yyyyMM = new SimpleDateFormat("yyyy/MM");
        SimpleDateFormat mdyy = new SimpleDateFormat("M/d/yy");
        SimpleDateFormat myy = new SimpleDateFormat("M/yy");


        String yyyyMMddDash_ = "^\\d{4}-\\d{2}-\\d{2}$";                 // 2018-02-12
        String yyyyMMdd_ = "^\\d{4}/\\d{2}/\\d{2}$";                // 2018/12/31
        String yyyyMMDash_ = "^\\d{4}-\\d{2}$";                      // 2018-02
        String yyyyMM_ = "^\\d{4}/\\d{2}$";                   // 2018/12
        String mdyy_ = "^\\d{1,2}/\\d{1,2}/\\d{2}$";            // 3/1/18
        String myy_ = "^\\d{1,2}/\\d{2}$";            // 3/18
        Pattern pattern1 = Pattern.compile(yyyyMMddDash_);
        Pattern pattern2 = Pattern.compile(yyyyMMdd_);
        Pattern pattern3 = Pattern.compile(yyyyMMDash_);
        Pattern pattern4 = Pattern.compile(yyyyMM_);
        Pattern pattern5 = Pattern.compile(mdyy_);
        Pattern pattern6 = Pattern.compile(myy_);
        Calendar calendar = Calendar.getInstance();
        Date q = null;
        String formatted = dateStr;
        try {
            if (pattern1.matcher(dateStr).matches()) {
                q = yyyyMMddDash.parse(dateStr);
            } else if (pattern2.matcher(dateStr).matches()) {
                q = yyyyMMdd.parse(dateStr);
            } else if (pattern3.matcher(dateStr).matches()) {
                q = yyyyMMDash.parse(dateStr);
            } else if (pattern4.matcher(dateStr).matches()) {
                q = yyyyMM.parse(dateStr);
            } else if (pattern5.matcher(dateStr).matches()) {
                q = mdyy.parse(dateStr);
            } else if (pattern6.matcher(dateStr).matches()) {
                q = myy.parse(dateStr);
            } else {
                return null;
            }
            calendar.setTime(q);
            return calendar;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getNumber(String c) {
        switch (c) {
            case "一":
                return "01";
            case "二":
                return "02";
            case "三":
                return "03";
            case "四":
                return "04";
            case "五":
                return "05";
            case "六":
                return "06";
            case "七":
                return "07";
            case "八":
                return "08";
            case "九":
                return "09";
            case "十一":
                return "11";
            case "十二":
                return "12";
            case "十":
                return "10";
            default:
                return "";
        }
    }

    public static void main(String[] args) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-01-01 00:00:00");
        Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-12-31 22:45:00");
        int differentDay = DateUtils.differentDays(date1, date2);
        System.out.println(differentDay);
    }


    /**
     * 比较两日期相差的天数
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        boolean hasTransform = false;
        if (year2 < year1) { //设置year2在year1之后
            int year = year2;
            year2 = year1;
            year1 = year;
            int day = day1;
            day1 = day2;
            day2 = day;
            hasTransform = true;
        }
        if (year1 != year2)   //不同一年
        {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)    //闰年
                {
                    timeDistance += 366;
                } else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            if (hasTransform) {
                return -(timeDistance + (day2 - day1));
            } else {
                return timeDistance + (day2 - day1);
            }
        } else    //同年
        {
            //System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2 - day1;
        }
    }

    /**
     * 获取指定日期几天前或后的日期
     * @param date
     * @param days
     * @return
     */
    public static Date dateAfterOrBeforeDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();

    }

    /**
     * 指定时间的当天0点时间
     * @param currentTime
     * @return
     */
    public static Date getStartTimeOfDay(Date currentTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentTime);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取指定日期所在年的开始时间
     * @param date 指定的日期，若为null则以当前时间为准
     * @return
     */
    public static Date getFirstTimeOfYearByDate(Date date){
        Calendar cal = Calendar.getInstance();
        if(date != null){
            cal.setTime(date);
        }
        cal.set(Calendar.DAY_OF_YEAR, cal.getActualMinimum(Calendar.DAY_OF_YEAR));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取指定日期所在年的结束时间
     * @param date 指定的日期，若为null则以当前时间为准
     * @return
     */
    public static Date getLastTimeOfYearByDate(Date date){
        Calendar cal = Calendar.getInstance();
        if(date != null){
            cal.setTime(date);
        }
        cal.set(Calendar.DAY_OF_YEAR, cal.getActualMaximum(Calendar.DAY_OF_YEAR));
        cal.set(Calendar.HOUR_OF_DAY, cal.getActualMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getActualMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getActualMaximum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getActualMaximum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    /**
     * <p>字符串转TimeStamp</p>
     */
    public static Timestamp parseTimeStamp(String time) {
        if (!StringUtils.isEmpty(time)){
            return Timestamp.valueOf(time);
        }
        return null;
    }

    public static Timestamp getBeginningOfDate(Long time) {
        if(time != null) {
            Calendar date = Calendar.getInstance();
            date.setTimeInMillis(time);
            date.set(Calendar.HOUR,0);
            date.set(Calendar.MINUTE,0);
            date.set(Calendar.SECOND,0);
            date.set(Calendar.MILLISECOND,0);
            return new Timestamp(date.getTimeInMillis());
        }
        return null;
    }

    public static Timestamp getEndOfDate(Long time) {
        if(time != null) {
            Calendar date = Calendar.getInstance();
            date.setTimeInMillis(time);
            date.set(Calendar.HOUR_OF_DAY,23);
            date.set(Calendar.MINUTE,59);
            date.set(Calendar.SECOND,59);
            date.set(Calendar.MILLISECOND,999);
            return new Timestamp(date.getTimeInMillis());
        }
        return null;
    }
}
