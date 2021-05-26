package utils.date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateStatisticHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(DateStatisticHelper.class);
	
	/**
	 * 获取当前UTC日期时间。
	 * 
	 * @return 当前UTC日期时间
	 */
	public static Date getCurrentUTCTime()
	{
		Calendar cal = Calendar.getInstance();

		// cal.setTimeInMillis(cal.getTimeInMillis() -
		// TimeZone.getDefault().getRawOffset());

		return cal.getTime();
	}

	/**
	 * 获取当天0点时间 （0时0分0秒）。
	 * 
	 * @return 当前0时0分0秒时间
	 */
	public static Date getCurrent0Hour()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	/**
	 * 获取指定日期往后数（过去）<code>dayCount</code>天的那一天的开始时间（0时0分0秒）
	 * 
	 * @param date 指定日期
	 * @param dayCount 往后数（过去）多少天
	 * @param isInclude 是否包含指定日期当天
	 * @return 开始时间
	 */
	public static Date getStartDateOfLastNDays(Date date, int dayCount, boolean isInclude)
	{
		// 如果包含当天则减少一天
		if (isInclude)
		{
			dayCount--;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int day = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.set(Calendar.DAY_OF_YEAR, (day - dayCount));
		calendar.set(GregorianCalendar.HOUR_OF_DAY, 0);
		calendar.set(GregorianCalendar.MINUTE, 0);
		calendar.set(GregorianCalendar.SECOND, 0);
		calendar.set(GregorianCalendar.MILLISECOND, 0);

		return calendar.getTime();
	}
	
	/**
	 * 格式化日期时间。
	 * 
	 * @param date 要格式化的日期
	 * @return 日期时间的格式化字符串
	 */
	public static String formatDateTime(Date date)
	{
		SimpleDateFormat formater = new SimpleDateFormat(DateStatisticConstants.FORMATE_DATETIME);
		return formater.format(date);
	}

	/**
	 * 格式化日期。
	 * 
	 * @param dateTime 要格式化的long类型日期
	 * @return 日期的格式化字符串
	 */
	public static String formatDateTime(long dateTime)
	{
		Date date = new Date(dateTime);
		SimpleDateFormat formater = new SimpleDateFormat(DateStatisticConstants.FORMATE_DATETIME);
		return formater.format(date);
	}

	/**
	 * 格式化日期。
	 * 
	 * @param date 要格式化的日期
	 * @return 日期的格式化字符串
	 */
	public static String formatDate(Date date)
	{
		SimpleDateFormat formater = new SimpleDateFormat(DateStatisticConstants.FORMATE_DATE);
		return formater.format(date);
	}

	/**
	 * 格式化日期。
	 * 
	 * @param dateTime 要格式化的long类型日期
	 * @return 日期的格式化字符串
	 */
	public static String formatDate(long dateTime)
	{
		Date date = new Date(dateTime);
		SimpleDateFormat formater = new SimpleDateFormat(DateStatisticConstants.FORMATE_DATE);
		return formater.format(date);
	}

	/**
	 * 把日期时间字符串解释成为日期对象
	 * 
	 * @param datetimeStr 日期时间字符串
	 * @return 日期对象
	 * @throws ParseException
	 */
	public static Date parseDateTimeStr(String datetimeStr) throws ParseException
	{
		SimpleDateFormat formater = new SimpleDateFormat(DateStatisticConstants.FORMATE_DATETIME);
		return formater.parse(datetimeStr);
	}

	/**
	 * 把日期字符串:yyyy-MM-dd,解释成为日期对象
	 * 
	 * @param dateStr 日期字符串
	 * @return 日期对象
	 * @throws ParseException
	 */
	public static Date parseDateStr(String dateStr) throws ParseException
	{
		SimpleDateFormat formater = new SimpleDateFormat(DateStatisticConstants.FORMATE_DATE);
		return formater.parse(dateStr);
	}
	
	/**
	 * 把日期字符串:yyyy-MM-dd,解释成为最小日期对象
	 * 
	 * @param dateStr 日期字符串
	 * @return 日期对象
	 * @throws ParseException
	 */
	public static Date parseDateStrToMin(String dateStr) throws ParseException
	{
		SimpleDateFormat formater = new SimpleDateFormat(DateStatisticConstants.FORMATE_DATE);
		Calendar cal = Calendar.getInstance();
		cal.setTime(formater.parse(dateStr));
		cal.set(Calendar.HOUR_OF_DAY, cal.getActualMinimum(Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE, cal.getActualMinimum(Calendar.MINUTE));
		cal.set(Calendar.SECOND, cal.getActualMinimum(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND, cal.getActualMinimum(Calendar.MILLISECOND));
		return cal.getTime();
	}
	
	/**
	 * 把日期字符串:yyyy-MM-dd,解释成为日期对象
	 * 
	 * @param dateStr 日期字符串
	 * @return 日期对象
	 * @throws ParseException
	 */
	public static Date parseDateStrToMax(String dateStr) throws ParseException
	{
		SimpleDateFormat formater = new SimpleDateFormat(DateStatisticConstants.FORMATE_DATE);
		Calendar cal = Calendar.getInstance();
		cal.setTime(formater.parse(dateStr));
		cal.set(Calendar.HOUR_OF_DAY, cal.getActualMaximum(Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE, cal.getActualMaximum(Calendar.MINUTE));
		cal.set(Calendar.SECOND, cal.getActualMaximum(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND, cal.getActualMaximum(Calendar.MILLISECOND));
		return cal.getTime();
	}

	/**
	 * 获取日期的时间部分的毫秒数
	 * E.g. 2018-8-24 15:19:09.230 getDateTimeLong result is: 15*3600*1000+19*60*1000+9*1000+230=55149230
	 * @return Long 毫秒数
	 * */
	public static Long getDateTimeLong(Timestamp planDate) {
		return getDateTimeLong(planDate.getTime());
	}

	/**
	 * 获取日期的时间部分的毫秒数
	 * E.g. 2018-8-24 15:19:09.230 getDateTimeLong result is: 15*3600*1000+19*60*1000+9*1000+230=55149230
	 * @return Long 毫秒数
	 * */
	public static Long getDateTimeLong(Time planDate) {
		return getDateTimeLong(planDate.getTime());
	}

	/**
	 * 获取日期的时间部分的毫秒数
	 * E.g. 2018-8-24 15:19:09.230 getDateTimeLong result is: 15*3600*1000+19*60*1000+9*1000+230=55149230
	 * @return Long 毫秒数
	 * */
	public static Long getDateTimeLong(long time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		return getDateTimeLong(calendar);
	}

	/**
	 * 获取日期的时间部分的毫秒数
	 * E.g. 2018-8-24 15:19:09.230 getDateTimeLong result is: 15*3600*1000+19*60*1000+9*1000+230=55149230
	 * @return Long 毫秒数
	 * */
	private static Long getDateTimeLong(Date time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		return getDateTimeLong(calendar);
	}
	/**
	 * 获取日期的时间部分的毫秒数
	 * E.g. 2018-8-24 15:19:09.230 getDateTimeLong result is: 15*3600*1000+19*60*1000+9*1000+230=55149230
	 * @return Long 毫秒数
	 * */
	private static Long getDateTimeLong(Calendar calendar) {
		Long result = 0L;
		result += calendar.get(Calendar.HOUR_OF_DAY) * 3600 * 1000L;
		result += calendar.get(Calendar.MINUTE) * 60 * 1000L;
		result += calendar.get(Calendar.SECOND) * 1000L;
		result += calendar.get(Calendar.MILLISECOND);
		return result;
	}
	public static Boolean isSameDay(Date d1, Date d2){
		if(null == d1 || null == d2) {
            return false;
        }
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		return df.format(d1).equals(df.format(d2));
	}

	public static java.sql.Date getTheFirstDate(String m) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
		try {
			Date date = df.parse(m);
			c.setTime(date);
			c.add(Calendar.MONTH, 0);
			c.set(Calendar.DAY_OF_MONTH, 1); //  设置为1号,当前日期既为本月第一天
			date = c.getTime();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			return sqlDate;
		} catch (ParseException e) {
			LOGGER.error("transfer format error");
			return null;
		}
	}

	public static java.sql.Date getTheLastDate(String m) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
		try {
			Date date = df.parse(m);
			c.setTime(date);
			c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH)); //  获取当前月最后一天
			date = c.getTime();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			return sqlDate;
		} catch (ParseException e) {
			LOGGER.error("transfer format error");
			return null;
		}
	}

	/**
	 * <p>取这天开始的时间</p>
	 *
	 *
	 * @param calendar  要取时间的日期
	 * @return calendar:这天0点0分0秒0毫秒 <code>null</code> if Exception
	 */
	public static Calendar getDateBeginCalendar(Calendar calendar){
		if (null == calendar) {
			return null;
		}
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		return calendar;
	}

}
