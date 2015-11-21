package com.kdyzm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * @author kdyzm
 *
 */
public class DateUtils {
	private static String pattern="yyyy-MM-dd HH:mm:ss";
	private static SimpleDateFormat sdf;
	static{
		sdf=new SimpleDateFormat(pattern);
	}
	public static Date stringToDate(String dateString) throws ParseException{
		return sdf.parse(dateString);
	}
	public static String dateToString(Date date){
		return sdf.format(date);
	}
}
