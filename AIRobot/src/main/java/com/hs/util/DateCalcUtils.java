package com.hs.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateCalcUtils {
	
	public static List<String> getPastDaysList(int intervals) {
		List<String> pastDaysList = new ArrayList<>();
		for (int i = intervals; i >= 0; i--) {
			pastDaysList.add(getPastDate(i));
		}
		System.out.println(pastDaysList);
		return pastDaysList;
	}
	
	public static List<String> getFetureDaysList(int intervals) {
		List<String> fetureDaysList = new ArrayList<>();
		for (int i = 0; i < intervals; i++) {
			fetureDaysList.add(getFetureDate(i));
		}
		return fetureDaysList;
	}

	/**
	 * 获取过去第几天的日期
	 * 
	 * @param past
	 * @return
	 */
	public static String getPastDate(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String result = format.format(today);
		return result;
	}

	/**
	 * 获取未来 第 past 天的日期
	 * 
	 * @param past
	 * @return
	 */
	public static String getFetureDate(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String result = format.format(today);
		return result;
	}
}
