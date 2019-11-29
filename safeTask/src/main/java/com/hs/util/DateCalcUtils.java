package com.hs.util;

import java.text.ParseException;
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
	/**
	 * @desc: 计算两个日期之间的每一天
	 * @author: kpchen
	 * @createTime: 2019年11月6日 下午8:45:40
	 * @history:
	 * @param start
	 * @param end
	 * @return List<String>
	 */
	public static List<String> getDateList(String start,String end) {
		List<String> dateList = new ArrayList<String>();
		try {
			Date bigtime = new SimpleDateFormat("yyyy-MM-dd").parse(start);
			Date endtime = new SimpleDateFormat("yyyy-MM-dd").parse(end);
			if (bigtime.after(endtime)) {
				return dateList;
			}
			dateList.add(start);
			Calendar calBegin = Calendar.getInstance();
			// 使用给定的 Date 设置此 Calendar 的时间
			calBegin.setTime(bigtime);
			Calendar calEnd = Calendar.getInstance();
			// 使用给定的 Date 设置此 Calendar 的时间
			calEnd.setTime(endtime);
			// 测试此日期是否在指定日期之后
			while (endtime.after(calBegin.getTime()))  {
				// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
				calBegin.add(Calendar.DAY_OF_MONTH, 1);
				String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(calBegin.getTime());
				dateList.add(dateStr);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateList;
	}
	
	public static void main(String[] args) {
		List<String> dateList = getDateList("2019-11-05", "2019-11-05");
		for (String date : dateList) {
			System.out.println(date);
		}
	}
}
