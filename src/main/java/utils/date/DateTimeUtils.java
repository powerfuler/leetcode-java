package utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Calendar;

public class DateTimeUtils {

	public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HHmmss");
	public static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyyMM");
	public static final DateTimeFormatter SHORT_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyMMdd");
	public static final DateTimeFormatter SHORT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyMMddHHmmss");
	public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
	public static final String DATE_YYYYMMDD = "yyyy.MM.dd";

	/**
	 * 返回当前的日期
	 * 
	 * @return
	 */
	public static LocalDate getCurrentLocalDate() {
		return LocalDate.now();
	}

	/**
	 * 返回当前时间
	 * 
	 * @return
	 */
	public static LocalTime getCurrentLocalTime() {
		return LocalTime.now();
	}

	/**
	 * 返回当前日期时间
	 * 
	 * @return
	 */
	public static LocalDateTime getCurrentLocalDateTime() {
		return LocalDateTime.now();
	}

	/**
	 * yyyyMMdd
	 * 
	 * @return
	 */
	public static String getCurrentDateStr() {
		return LocalDate.now().format(DATE_FORMATTER);
	}

	/**
	 * yyMMdd
	 * 
	 * @return
	 */
	public static String getCurrentShortDateStr() {
		return LocalDate.now().format(SHORT_DATE_FORMATTER);
	}

	public static String getCurrentMonthStr() {
		return LocalDate.now().format(MONTH_FORMATTER);
	}

	/**
	 * yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static String getCurrentDateTimeStr() {
		return LocalDateTime.now().format(DATETIME_FORMATTER);
	}

	/**
	 * yyMMddHHmmss
	 * 
	 * @return
	 */
	public static String getCurrentShortDateTimeStr() {
		return LocalDateTime.now().format(SHORT_DATETIME_FORMATTER);
	}

	/**
	 * HHmmss
	 * 
	 * @return
	 */
	public static String getCurrentTimeStr() {
		return LocalTime.now().format(TIME_FORMATTER);
	}

	public static String getCurrentDateStr(String pattern) {
		return LocalDate.now().format(DateTimeFormatter.ofPattern(pattern));
	}

	public static String getCurrentDateTimeStr(String pattern) {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
	}

	public static String getCurrentTimeStr(String pattern) {
		return LocalTime.now().format(DateTimeFormatter.ofPattern(pattern));
	}

	public static LocalDate parseLocalDate(String dateStr, String pattern) {
		return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
	}

	public static LocalDateTime parseLocalDateTime(String dateTimeStr, String pattern) {
		return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
	}

	public static LocalTime parseLocalTime(String timeStr, String pattern) {
		return LocalTime.parse(timeStr, DateTimeFormatter.ofPattern(pattern));
	}

	public static String formatLocalDate(LocalDate date, String pattern) {
		return date.format(DateTimeFormatter.ofPattern(pattern));
	}

	public static String formatLocalDateTime(LocalDateTime datetime, String pattern) {
		return datetime.format(DateTimeFormatter.ofPattern(pattern));
	}

	public static String formatLocalTime(LocalTime time, String pattern) {
		return time.format(DateTimeFormatter.ofPattern(pattern));
	}

	public static LocalDate parseLocalDate(String dateStr) {
		return LocalDate.parse(dateStr, DATE_FORMATTER);
	}

	public static LocalDateTime parseLocalDateTime(String dateTimeStr) {
		return LocalDateTime.parse(dateTimeStr, DATETIME_FORMATTER);
	}

	public static LocalTime parseLocalTime(String timeStr) {
		return LocalTime.parse(timeStr, TIME_FORMATTER);
	}

	public static String formatLocalDate(LocalDate date) {
		return date.format(DATE_FORMATTER);
	}

	public static String formatLocalDateTime(LocalDateTime datetime) {
		return datetime.format(DATETIME_FORMATTER);
	}

	public static String formatLocalTime(LocalTime time) {
		return time.format(TIME_FORMATTER);
	}

	/**
	 * 日期相隔天数
	 * 
	 * @param startDateInclusive
	 * @param endDateExclusive
	 * @return
	 */
	public static int periodDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
		return Period.between(startDateInclusive, endDateExclusive).getDays();
	}

	/**
	 * 日期相隔小时
	 * 
	 * @param startInclusive
	 * @param endExclusive
	 * @return
	 */
	public static long durationHours(Temporal startInclusive, Temporal endExclusive) {
		return Duration.between(startInclusive, endExclusive).toHours();
	}

	/**
	 * 日期相隔分钟
	 * 
	 * @param startInclusive
	 * @param endExclusive
	 * @return
	 */
	public static long durationMinutes(Temporal startInclusive, Temporal endExclusive) {
		return Duration.between(startInclusive, endExclusive).toMinutes();
	}

	/**
	 * 日期相隔毫秒数
	 * 
	 * @param startInclusive
	 * @param endExclusive
	 * @return
	 */
	public static long durationMillis(Temporal startInclusive, Temporal endExclusive) {
		return Duration.between(startInclusive, endExclusive).toMillis();
	}

	/**
	 * 是否当天
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(LocalDate date) {
		return getCurrentLocalDate().equals(date);
	}

	public static Long toEpochMilli(LocalDateTime dateTime) {
		return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
	}
	
	public static Calendar parseDate(String date) {
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
			c.add(Calendar.HOUR, 0);
			c.add(Calendar.MINUTE, 0);
			c.add(Calendar.SECOND, 0);
			c.add(Calendar.MILLISECOND, 1);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return c;
	}
}