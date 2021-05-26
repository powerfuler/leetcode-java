package utils.date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DateUtil {
    public static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
	/**
     * 变量：日期格式化类型 - 格式:yyyy/MM/dd
     */
	public static final int DEFAULT = 0;
	public static final int YM = 1;

    /**
     * 变量：日期格式化类型 - 格式:yyyy-MM-dd
     * 
     */
    public static final int YMR_SLASH = 11;

    /**
     * 变量：日期格式化类型 - 格式:yyyyMMdd
     * 
     */
    public static final int NO_SLASH = 2;

    /**
     * 变量：日期格式化类型 - 格式:yyyyMM
     * 
     */
    public static final int YM_NO_SLASH = 3;

    /**
     * 变量：日期格式化类型 - 格式:yyyy/MM/dd HH:mm:ss
     * 
     */
    public static final int DATE_TIME = 4;

    /**
     * 变量：日期格式化类型 - 格式:yyyyMMddHHmmss
     * 
     */
    public static final int DATE_TIME_NO_SLASH = 5;

    /**
     * 变量：日期格式化类型 - 格式:yyyy/MM/dd HH:mm
     * 
     */
    public static final int DATE_HM = 6;

    /**
     * 变量：日期格式化类型 - 格式:HH:mm:ss
     * 
     */
    public static final int TIME = 7;

    /**
     * 变量：日期格式化类型 - 格式:HH:mm
     * 
     */
    public static final int HM = 8;
    
    /**
     * 变量：日期格式化类型 - 格式:HHmmss
     * 
     */
    public static final int LONG_TIME = 9;
    /**
     * 变量：日期格式化类型 - 格式:HHmm
     * 
     */
    
    public static final int SHORT_TIME = 10;

    /**
     * 变量：日期格式化类型 - 格式:yyyy-MM-dd HH:mm:ss
     */
    public static final int DATE_TIME_LINE = 12;
	public static String dateToStr(Date date, int type) {
        switch (type) {
        case DEFAULT:
            return dateToStr(date);
        case YM:
            return dateToStr(date, "yyyy/MM");
        case NO_SLASH:
            return dateToStr(date, "yyyyMMdd");
        case YMR_SLASH:
        	return dateToStr(date, "yyyy-MM-dd");
        case YM_NO_SLASH:
            return dateToStr(date, "yyyyMM");
        case DATE_TIME:
            return dateToStr(date, "yyyy/MM/dd HH:mm:ss");
        case DATE_TIME_NO_SLASH:
            return dateToStr(date, "yyyyMMddHHmmss");
        case DATE_HM:
            return dateToStr(date, "yyyy/MM/dd HH:mm");
        case TIME:
            return dateToStr(date, "HH:mm:ss");
        case HM:
            return dateToStr(date, "HH:mm");
        case LONG_TIME:
            return dateToStr(date, "HHmmss");
        case SHORT_TIME:
            return dateToStr(date, "HHmm");
        case DATE_TIME_LINE:
            return dateToStr(date, "yyyy-MM-dd HH:mm:ss");
        default:
            throw new IllegalArgumentException("Type undefined : " + type);
        }
    }
	public static String dateToStr(Date date,String pattern) {
	       if (date == null || date.equals("")) {
               return null;
           }
	       SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	       return formatter.format(date);
    } 

    public static String dateToStr(Date date) {
        return dateToStr(date, "yyyy/MM/dd");
    }
    
    /**
     * 获取时间段所有的日期
     * @param dBegin
     * @param dEnd
     * @return
     */
    public static List<Date> getStartToEndDates(Date dBegin, Date dEnd){
    	List<Date> lDate = new ArrayList<Date>();  
        Calendar calBegin = Calendar.getInstance();  
        // 使用给定的 Date 设置此 Calendar 的时间    
        calBegin.setTime(dBegin);  
        Calendar calEnd = Calendar.getInstance();  
        // 使用给定的 Date 设置此 Calendar 的时间    
        calEnd.setTime(dEnd);  
        
        calBegin.set(Calendar.HOUR_OF_DAY, 0);
        calBegin.set(Calendar.MINUTE, 0);
        calBegin.set(Calendar.SECOND, 0);
        calBegin.set(Calendar.MILLISECOND, 0);
        
        // 测试此日期是否在指定日期之后   
        while (dEnd.after(calBegin.getTime())) {  
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量   
        	lDate.add(calBegin.getTime());  
            calBegin.add(Calendar.DAY_OF_MONTH, 1);  
 
        }
        if(0 == lDate.size()){
            lDate.add(calBegin.getTime());
        }
        return lDate;  
    }

    /**
     * 字符串转换成日期
     * @param str
     * @return date
     */
    public static Date strToDate(String str, String pattern) {

        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static java.sql.Date parseDate(String date) {
        String pattern = null;
        if (date != null) {
            if (date.matches("\\d{4}-\\d{2}-\\d{2}")) {
                pattern = "yyyy-MM-dd";
            } else if (date.matches("\\d{4}/\\d{2}/\\d{2}")) {
                pattern = "yyyy/MM/dd";
            } else if(date.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")){
                pattern = "yyy-MM-dd HH:mm:ss";
            } else if(date.matches("\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}:\\d{2}")){
                pattern = "yyy/MM/dd HH:mm:ss";
            }
        }
        if(null != pattern){
            TemporalAccessor accessor = DateTimeFormatter.ofPattern(pattern).parse(date);
            LocalDate ld = LocalDate.from(accessor);
            return java.sql.Date.valueOf(ld);
        }
        return null;
    }

    public static Timestamp parseTimestamp(String date) {
        try{
            if(date.matches("\\d{4}-\\d{2}-\\d{2}")){
                date = date + " 00:00:00";
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parsedDate = dateFormat.parse(date);
            Timestamp timestamp = new Timestamp(parsedDate.getTime());
            return timestamp;
        }catch(Exception e) {
            return null;
        }
    }

    /**
     * @author wentian
     * 判定两个时间周期是否有重合的情况
     * @param startTime 第一个时间周期的开始
     * @param endTime  第一个时间周期的结束
     * @param startTime1 第二个时间周期的开始
     * @param endTime1 第二个时间周期的结束
     * @return true for 有重合的请开给你，false for 无重合的情况
     */
    public static boolean hasIntersection(Timestamp startTime, Timestamp endTime, Timestamp startTime1, Timestamp endTime1) {
        long maxEnd = Math.max(endTime.getTime(), endTime1.getTime());
        long minStart = Math.min(startTime.getTime(), startTime1.getTime());
        if((maxEnd - minStart) >= (endTime.getTime() - startTime.getTime() + endTime1.getTime() - startTime1.getTime())){
           return false;
        }
        return true;
    }

    public static Timestamp firstDateOfMonth(String monthStr, String format) {
        Calendar calendar = calendarWithoutMonthDay(monthStr, format);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static Timestamp lastDateOfMonth(String monthStr, String format) {
        Calendar cal = calendarWithoutMonthDay(monthStr, format);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return new Timestamp(cal.getTimeInMillis());
    }

    private static Calendar calendarWithoutMonthDay(String monthStr, String format) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            Date date = simpleDateFormat.parse(monthStr);
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            return calendar;
        } catch (ParseException e) {
            LOGGER.error("date format is wrong.must be yyyy-MM");
        }
        return null;
    }
}
