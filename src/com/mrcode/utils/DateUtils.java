package com.mrcode.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.DurationFieldType;
import org.joda.time.format.DateTimeFormat;



/**
 * 
 * @author 羽中
 *
 */
public class DateUtils {
	
	public final static String DEFAULT_YMDHMS_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public final static String DEFAULT_YMD_FORMAT = "yyyy-MM-dd";
	public final static String SOLR_TDATE_FORMATE = "yyyy-MM-dd'T'HH:mm:ss.000'Z'";
	public final static String SOLR_TDATE_RETURN_FORMATE = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	public final static String COMPACT_YMDHMS_FORMAT = "yyyyMMddHHmmss";
	public final static String COMPACT_YMD_FORMAT = "yyyyMMdd";
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf;
	public static void main(String[] args) throws ParseException {
		String pat1 = "yyyy-MM-dd HH:mm:ss" ; 
		/*Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(pat1);
		System.out.println(date);*/
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		System.out.println(currentTime_2);
//		System.out.println(DateUtils.parseDate(dateTime));
		//System.out.println(DateUtils.parseDate(DateUtils.time(now())));
		//System.out.println(createDate.toString());
		/*SimpleDateFormat sdf = new SimpleDateFormat(pat1);
		System.out.println(sdf.parse("2016-3-3 13:30:0"));*/
		//Calendar cal = Calendar.getInstance();
//		System.out.println(now(COMPACT_YMDHMS_FORMAT));
//		System.out.println(time2Str(now()));
//		System.out.println(DateUtils.time(now()).toString("yyyy年MM月dd日HH时mm分ss秒"));
		//System.out.println(DateUtils.time(now()).toString(DEFAULT_YMDHMS_FORMAT));
		/*System.out.println(
                lengthBetween(
                        time("2013-04-20 11:15:15"),
                        time("2013-04-18 11:15:15"),
                        JodaTime.DAY
                )
        );
		System.out.println(time2Str(new Date(), DEFAULT_YMDHMS_FORMAT));
		System.out.println(currentTime());*/
	}

	/**
	 * 获取当前时间的joda-time对象
	 * 
	 * @return
	 */
	public static DateTime currentTime() {
		return new DateTime();
	}

	/**
	 * 将时间字符串直接转换为joda-time对象
	 * 
	 * @param timeStr
	 * @return
	 */
	public static DateTime time(String timeStr) {
		return time(timeStr, DEFAULT_YMDHMS_FORMAT);
	}

	/**
	 * 将时间字符串直接转换为joda-time对象
	 * 
	 * @param timeStr
	 * @param timePattern
	 *            时间格式
	 * @return
	 */
	public static DateTime time(String timeStr, String timePattern) {
		if (null == timeStr || timeStr.equals("")) {
			return null;
		}
		if (null != timePattern && !timePattern.equals("")) {
			// 有指定转换器
			return DateTimeFormat.forPattern(timePattern)
					.parseDateTime(timeStr);
		} else {
			// 没指定转换器
			if (timeStr.length() == 19) {
				return DateTimeFormat.forPattern(DEFAULT_YMDHMS_FORMAT)
						.parseDateTime(timeStr);
			} else if (timeStr.length() == 10) {
				return DateTimeFormat.forPattern(DEFAULT_YMD_FORMAT)
						.parseDateTime(timeStr);
			} else if (timeStr.length() == 24) {
				return DateTimeFormat.forPattern(SOLR_TDATE_FORMATE)
						.parseDateTime(timeStr);
			} else if (timeStr.length() == 20) {
				return DateTimeFormat.forPattern(SOLR_TDATE_RETURN_FORMATE)
						.parseDateTime(timeStr);
			} else {
				return new DateTime(timeStr);
			}
		}
	}

	/**
	 * 将时间转换为归一化的类型，即转换为绝对秒数的字符类型
	 * 
	 * @param timeStr
	 * @return
	 */
	public static String time2Str(String timeStr) {
		DateTime time = time(timeStr);
		if (time == null) {
			return "";
		}
		return String.valueOf(time.getMillis() / 1000);
	}

	/**
	 * 将时间转换为指定格式的字符串
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String time2Str(Date date, String pattern) {
		DateTime dateTime = new DateTime(date);
		return dateTime.toString(pattern);
	}

	/**
	 * 比较一个日期值是否是在两个日期值之间
	 * 
	 * @param min
	 * @param max
	 * @param compareDate
	 * @return
	 */
	public static boolean betweenTwoDate(Date min, Date max, Date compareDate) {
		if (compareDate == null) {
			return false;
		}
		if (min == null && max == null) {
			return false;
		}
		if (min == null && max != null) {
			return max.after(compareDate);
		}
		if (min != null && max == null) {
			return min.before(compareDate);
		}
		return (min.before(compareDate) && max.after(compareDate));
	}

	/**
	 * 比较当前日期值是否是在两个日期值之间
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public static boolean nowBetweenTwoDate(Date min, Date max) {
		return betweenTwoDate(min, max, new Date());
	}

	/**
	 * 获得当前格式化以后的时间（yyyy-MM-dd HH:mm:ss）
	 * 
	 * @param str
	 * @param pattern
	 * @return
	 */
	public static Date parseDate(String str, String pattern) {
		if (StringUtils.isEmpty(str)) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(str);
		} catch (Exception e) {
			throw new RuntimeException("Could not parse date: "
					+ e.getMessage(), e);
		}
	}

	/**
	 * 获得当前格式化以后的时间
	 * 
	 * @param pattern
	 * @return
	 */
	public static String now(String pattern) {
		return currentTime().toString(pattern);
	}
	
	/**
     * 获得当前格式化以后的时间（yyyy-MM-dd HH:mm:ss）
     * @return
     */
    public static String now(){
        return now(DEFAULT_YMDHMS_FORMAT);
    }

	/**
	 * 获得两个时间点之间的时间跨度
	 * 
	 * @param time1
	 *            开始的时间点
	 * @param time2
	 *            结束的时间点
	 * @param timeUnit
	 *            跨度的时间单位 see {@link JodaTime}
	 *            （支持的时间单位有DAY,HOUR,MINUTE,SECOND,MILLI）
	 */
	public static long lengthBetween(DateTime time1, DateTime time2,
			DurationFieldType timeUnit) {
		Duration duration = Days.daysBetween(time1, time2).toStandardDuration();
		if (timeUnit == JodaTime.DAY) {
			return duration.getStandardDays();
		} else if (timeUnit == JodaTime.HOUR) {
			return duration.getStandardHours();
		} else if (timeUnit == JodaTime.MINUTE) {
			return duration.getStandardMinutes();
		} else if (timeUnit == JodaTime.SECOND) {
			return duration.getStandardSeconds();
		} else if (timeUnit == JodaTime.MILLI) {
			return duration.getMillis();
		} else {
			throw new RuntimeException(
					"TimeUnit not supported except DAY,HOUR,MINUTE,SECOND,MILLI");
		}
	}

	/**
	 * 还原回jdk的原生Date对象
	 * 
	 * @return
	 */
	public static Date parseDate(DateTime dateTime) {
		return dateTime.toDate();
	}

	/**
	 * 还原回jdk的原生Calendar对象
	 * 
	 * @return
	 */
	public static Calendar parseCalendar(DateTime dateTime) {
		return dateTime.toCalendar(Locale.getDefault());
	}

	/**
	 * 根据日期获取当天的开始时间字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String startTimeStr(Date date) {

		String dateStr = new DateTime(date.getTime())
				.toString(DEFAULT_YMD_FORMAT) + " 00:00:00";
		return dateStr;
	}
	/**
     * 根据日期获取当天的开始时间
     * @param date
     * @return
     */
    public static Date startTime(Date date){
    	String dateStr = new DateTime(date.getTime()).toString(DEFAULT_YMD_FORMAT) + " 00:00:00";
    	return DateTimeFormat.forPattern(DEFAULT_YMDHMS_FORMAT).parseDateTime(dateStr).toDate();
    }
    /**
     * 根据日期获取当天的结束时间
     * @param date
     * @return
     */
    public static Date endTime(Date date){
    	String dateStr = new DateTime(date.getTime()).toString(DEFAULT_YMD_FORMAT) + " 23:59:59";
    	return DateTimeFormat.forPattern(DEFAULT_YMDHMS_FORMAT).parseDateTime(dateStr).toDate();
    }
    /**
     * 根据日期获取当天的结束时间字符串
     * @param date
     * @return
     */
    public static String endTimeStr(Date date){
    	String dateStr = new DateTime(date.getTime()).toString(DEFAULT_YMD_FORMAT) + " 23:59:59";
    	return dateStr;
    }
    
	/**
	 * 某个日期的几天前或者几天后的当天开始时间
	 * 
	 * @param date
	 *            给定的日期
	 * @param dayOffset
	 *            日期偏移量1标示一天后,-1标示1天前
	 * @return
	 */
	public static long startTimeWithDayOffset(Date date, int dayOffset) {
		if(date == null) date = new Date();
		long time = date.getTime() + Long.valueOf(dayOffset) * (1000 * 60 * 60 * 24);
		return startTime(new Date(time)).getTime();
	}
	/**
	 * 某个日期的几天前或者几天后的当天结束时间
	 * 
	 * @param date
	 *            给定的日期
	 * @param dayOffset
	 *            日期偏移量1标示一天后,-1标示1天前
	 * @return
	 */
	public static long endTimeWithDayOffset(Date date, int dayOffset) {
		if(date == null) date = new Date();
		long time = date.getTime() + Long.valueOf(dayOffset) * (1000 * 60 * 60 * 24);
		return endTime(new Date(time)).getTime();
	}
	public static String nowDate(){
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_YMD_FORMAT);
		return sdf.format(new Date());
	}
	
	public static String formatStr(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_YMD_FORMAT);
		if(date == null){
			return "";
		}
		return sdf.format(date);		
	}
	/**
	 * 根据date,hours，minutes的值得到制定的日期对象
	 * @param date
	 * @param hours
	 * @param minutes
	 * @return
	 */
	public static Date getFormatString(String date, int hours, int minutes)  throws Exception{
		System.out.println("DateUtils.getFormatString()");
		String[] arr = date.split("-");
		if(arr.length!=3){
			throw new Exception("date格式错误");
		}
		TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8"); 
		TimeZone.setDefault(tz);
		int year = Integer.parseInt(arr[0]);
		int month = Integer.parseInt(arr[1]);
		int day = Integer.parseInt(arr[2]);
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month-1);
		c.set(Calendar.DATE, day);
		c.set(Calendar.HOUR_OF_DAY, hours);
		c.set(Calendar.MINUTE, minutes);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
}

/**
 * jodaTime枚举类似类<br/>
 * 
 * @author 羽中
 * 
 */
class JodaTime {
	/**
	 * 时代(1000年)
	 */
	public static DurationFieldType ERA = DurationFieldType.eras();
	/**
	 * 世纪(100年)
	 */
	public static DurationFieldType CENTURY = DurationFieldType.centuries();
	/**
	 * 一年中的第几周
	 */
	public static DurationFieldType WEEK_YEAR = DurationFieldType.weekyears();
	/**
	 * 年
	 */
	public static DurationFieldType YEAR = DurationFieldType.years();
	/**
	 * 月
	 */
	public static DurationFieldType MONTH = DurationFieldType.months();
	/**
	 * 日
	 */
	public static DurationFieldType DAY = DurationFieldType.days();
	/**
	 * 周
	 */
	public static DurationFieldType WEEK = DurationFieldType.weeks();
	/**
	 * 半天
	 */
	public static DurationFieldType HALF_DAY = DurationFieldType.halfdays();
	/**
	 * 时
	 */
	public static DurationFieldType HOUR = DurationFieldType.hours();
	/**
	 * 分
	 */
	public static DurationFieldType MINUTE = DurationFieldType.minutes();
	/**
	 * 秒
	 */
	public static DurationFieldType SECOND = DurationFieldType.seconds();
	/**
	 * 毫秒
	 */
	public static DurationFieldType MILLI = DurationFieldType.millis();
}