package utils;

import utils.entity.PeriodExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author dingjianmin
 * @date 2019年4月9日 上午9:17:36
 * @Description: TODO
 */
public class ContractUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(ContractUtils.class);

	/**
	 * 邀请码生成器，算法原理：
	 * 1) 获取id: 1111111
	 * 2) 使用自定义进制转为：gpm6
	 * 3) 转为字符串，并在后面加'O'字符：gpm6o
	 * 4）在后面随机产生若干个随机数字字符：gpm6o7
	 * 转为自定义进制后就不会出现o这个字符，然后在后面加个'o'，这样就能确定唯一性。最后在后面产生一些随机字符进行补全。
	 */
	/** 自定义进制(0,1没有加入,容易与o,l混淆) */
	private static final char[] r=new char[]{'Q', 'W', 'E', '8', 'A', 'S', '2', 'D', 'Z', 'X', '9', 'C', '7', 'P', '5', 'I', 'K', '3', 'M', 'J', 'U', 'F', 'R', '4', 'V', 'Y', 'l', 'T', 'N', '6', 'B', 'G', 'H'};

	/** (不能与自定义进制有重复) */
	private static final char b='O';

	/** 进制长度 */
	private static final int binLen=r.length;

	/** 序列最小长度 */
	public static final int CODE_LEN=6;

	/** 用于生成固定随机码id最小长度 */
	public static final int ID_LEN = 7;

	/**
	 * @Desc 获取两个时间之间的间隔天数
	 * @param startTimeStr
	 * @param endTimeStr
	 * @return
	 */
	public static String getBetweenDays(String startTimeStr, String endTimeStr) {
		int betweenDays = 0;
		Date startTime = strToDateLong(startTimeStr);
		Date endTime = strToDateLong(endTimeStr);
		long start = startTime.getTime();
		long end = endTime.getTime();
		betweenDays = (int) (Math.abs(end - start) / (24 * 3600 * 1000));
		return String.valueOf(betweenDays + 1);
	}

	public static Date strToDateLong(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	public static int daysBetweenDate(Date c1, Date c2) {
		long time1 = c1.getTime();
		long time2 = c2.getTime();
		Long betweenDays = Math.abs(time2 - time1) / (1000 * 3600 * 24);
		return betweenDays.intValue() + 1;
	}

	public static BigDecimal calculateFee(int agreedPeriod, int actualPeriod, BigDecimal amount) {
		BigDecimal factor1 = new BigDecimal(actualPeriod);
		BigDecimal factor2 = new BigDecimal(agreedPeriod);
		return amount.multiply(factor1).divide(factor2, 10, BigDecimal.ROUND_FLOOR);
	}

	// 校验list
	public static boolean checkListIsNotNull(List<Object> checkList) {
		return (checkList != null || checkList.size() > 0);
	}

	/**
	 * 得到key切分的segments
	 *
	 * @param key
	 * @return String[] segments
	 */
	public static String[] getDataKeySegments(String key) {
		String[] segments = null;
		List<String> dataKeys = GetKeywordsUtils.getKeywordsWithoutPattern(key, "${", "}");
		if (dataKeys.size() > 0) {
			String dataKey = dataKeys.get(0);
			System.out.println(dataKey);
			segments = dataKey.split("\\.");
		}
		return segments;
	}

	/**
	 * 把long类型时间格式化
	 *
	 * @param longData
	 * @return yyyy年MM月dd日
	 */
	public static String formatLongData(Long longData) {
		if (longData != null) {
			String simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日").format(new Date(longData));
			return simpleDateFormat;
		}
		return "";
	}

	/**
	 * 把timeStamp类型时间格式化
	 *
	 * @param timeStamp
	 * @return yyyy年MM月dd日
	 */
	public static String formatTimeStamp(Timestamp timeStamp) {
		if (timeStamp != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
			return simpleDateFormat.format(new Date(timeStamp.getTime()));
		}
		return "";
	}

	/**
	 * 设置数据精度
	 *
	 * @param number
	 * @param newScale
	 * @param roundingMode
	 * @return
	 */
	public static BigDecimal setScale(BigDecimal number, int newScale, int roundingMode) {
		if (number == null) {
			number = BigDecimal.ZERO;
		}
		return number.setScale(newScale, roundingMode);
	}

	/**
	 * 四舍五入截断double类型数据
	 * @param input
	 * @param scale
	 * @return
	 */
	public static double doubleRoundHalfUp(double input,int scale){
		BigDecimal digit = BigDecimal.valueOf(input);
		return digit.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 数字金额大写转换，思想先写个完整的然后将如零拾替换成零 要用到正则表达式
	 */
	public static String digitUppercase(double num) {
		BigDecimal n = new BigDecimal(String.valueOf(num));

		String fraction[] = { "角", "分" };
		String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		String unit[][] = { { "元", "万", "亿" }, { "", "拾", "佰", "仟" } };

		String head = n.compareTo(BigDecimal.ZERO) < 0 ? "负" : "";
		n = n.abs();

		String s = "";
		for (int i = 0; i < fraction.length; i++) {
			BigDecimal pow = new BigDecimal("10").pow(i);
			BigDecimal v = n.multiply(new BigDecimal("10")).multiply(pow);
			BigDecimal i1 = v.remainder(new BigDecimal("10"));
			String s1 = digit[i1.intValue()] + fraction[i];
			String s2 = (s1).replaceAll("(零.)+", "");
			s += s2;
		}
		if (s.length() < 1) {
			s = "整";
		}

		int integerPart = n.setScale(0, BigDecimal.ROUND_FLOOR).intValue();

		for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
			String p = "";
			for (int j = 0; j < unit[1].length && n.compareTo(BigDecimal.ZERO) > 0; j++) {
				p = digit[integerPart % 10] + unit[1][j] + p;
				integerPart = integerPart / 10;
			}
			s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i] + s;
		}
		return head + s.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "").replaceAll("(零.)+", "零").replaceAll("^整$", "零元整");
	}

	/**
	 * 根据线程名称杀死该线程
	 * @param name
	 * @return
	 */
	public static boolean killThreadByName(String name) {
		ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
		int noThreads = currentGroup.activeCount();
		Thread[] lstThreads = new Thread[noThreads];
		currentGroup.enumerate(lstThreads);
		for (int i = 0; i < noThreads; i++) {
			String nm = lstThreads[i].getName();
			if (nm.equals(name)) {
				lstThreads[i].interrupt();
				return true;
			}
		}
		return false;
	}

	public static Date getPeriodEndDate(String startDateStr, PeriodExpression period, Integer startDay) {
		// int startDay = getDate(startDateStr).get(Calendar.DAY_OF_MONTH);
		if (period.getIntervalDayIndex() == -1) {
			startDay= 31;
		}
		Calendar endDateCalendar = getDate(startDateStr);
		// calendar会自动处理：
		// 1、如果增加某些月的数量，天超过月份中最大的天数时会被减到当月的最大值；
		// 2、如果减少某些天的数量，当减的天数大于月中已有的天数，则月数会减1；
		// 故当增加月份后若结束日期中的天与开始日期的天不一致时，说明结束月天数不够，不需要再减；否则需要减一天；
		// 一般周期都是从某天到下一个周期的该天减1，比如2018-12-24到2019-1-23就是一个周期，其中23是由24-1得来的；
		// 但如果是2018-1-31到2018-2-30，由于日历组件由1月加到2月的时候，会自动减到28(闰年则减到29)，此时由于天数不够故不用减，直接用28/29即可；
		// 所以规律就是：日历组件加上N月之后，如果得到的天还与原来的天一样，则减1天，否则不减。
		endDateCalendar.set(Calendar.DAY_OF_MONTH, 1);
		endDateCalendar.add(Calendar.MONTH, period.getPeriodInterval());
		int maxEndDay = endDateCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		if (startDay >= maxEndDay) {
			endDateCalendar.set(Calendar.DAY_OF_MONTH, maxEndDay);
		} else {
			endDateCalendar.set(Calendar.DAY_OF_MONTH, startDay);
		}
		endDateCalendar.add(Calendar.DAY_OF_MONTH, -1);
		return endDateCalendar.getTime();
	}
	public static Calendar getDate(String dateStr) {
		Date startDate = null;
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid start date, startDateStr=" + dateStr);
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		return calendar;
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

	public static List<String> findDates(String stime, String etime) throws ParseException {
		List<String> allDate = new ArrayList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date dBegin = sdf.parse(stime);
		Date dEnd = sdf.parse(etime);
		allDate.add(sdf.format(dBegin));
		Calendar calBegin = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calEnd.setTime(dEnd);
		// 测试此日期是否在指定日期之后
		while (dEnd.after(calBegin.getTime())) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			allDate.add(sdf.format(calBegin.getTime()));
		}
		return allDate;
	}

	public static void main(String[] args) {
		/*Timestamp timestampByAddThirtyDays = Utils.getTimestampStickToMonthEnd(1519714947000L, 1);
		System.out.println(timestampByAddThirtyDays);*/

		String stime = "2019-05-01";
		String etime = "2019-05-05";
		List<String> dates = null;
		try {
			dates = findDates(stime, etime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for (String time : dates) {
			System.out.println(time);
		}
		System.out.println(dates.size() + "天数");

		String betweenDays = getBetweenDays(stime, etime);
		System.out.println(betweenDays + "天数");
	}

	/**
	 * 根据ID生成六位随机码
	 * @param id ID
	 * @return 随机码
	 */
	public static String toSerialCode(long id) {
		System.out.println("原始id:" + id);
		// 判断id多少位
		String replace = String.format("%-" + ID_LEN + "s", id).replace(' ', '0');
		id = Long.valueOf(replace);
		System.out.println("补位后id:" + id);

		char[] buf=new char[32];
		int charPos=32;

		while((id / binLen) > 0) {
			int ind=(int)(id % binLen);
			buf[--charPos]=r[ind];
			id /= binLen;
		}
		buf[--charPos]=r[(int)(id % binLen)];
		String str=new String(buf, charPos, (32 - charPos));
		// 不够长度的自动随机补全
		if(str.length() < CODE_LEN) {
			StringBuilder sb=new StringBuilder();
			sb.append(b);
			Random rnd=new Random();
			for(int i=1; i < CODE_LEN - str.length(); i++) {
				sb.append(r[rnd.nextInt(binLen)]);
			}
			str+=sb.toString();
		}
		return str;
	}

}
