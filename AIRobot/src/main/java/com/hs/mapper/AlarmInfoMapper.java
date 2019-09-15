package com.hs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hs.model.AlarmExcelModel;
import com.hs.model.AlarmType;
import com.hs.model.TaskErrorLog;
import com.hs.model.TblAlarmInfo;
import com.hs.model.TotalCalcInfo;
import com.hs.model.TotalInfo;
import com.hs.request.GetWarnListRequest;

public interface AlarmInfoMapper {
	/**
	 * @desc: 批量保存数据
	 * @author: kpchen
	 * @createTime: 2019年8月18日 上午9:29:51
	 * @history:
	 * @param list
	 * @return int
	 */
	public int batchSaveAlarmInfo(@Param("list") List<TblAlarmInfo> list);

	public int dealAlarmById(@Param("id") Integer id);

	public int batchAlarms(@Param("idList") List<Integer> idList);
	/**
	 * @desc: 报警列表
	 * @author: kpchen
	 * @createTime: 2019年8月20日 下午10:37:58
	 * @history:
	 * @return List<TblAlarmInfo>
	 */
	public List<TblAlarmInfo> getWarnList(GetWarnListRequest request);
	/**
	 * @desc: 获取报警名称列表
	 * @author: kpchen
	 * @createTime: 2019年8月20日 下午10:37:19
	 * @history:
	 * @return List<TblAlarmInfo>
	 */
	public List<TblAlarmInfo> getAlarmList();

	public List<TotalInfo> getEchartsByAid(@Param("alarmId") String alarmId);

	public List<TotalCalcInfo> getTotalChart(@Param("alarmIdList") List<String> idList);

	public void saveAlarmType(AlarmType saveAlarmModel);

	public AlarmType getAlarmType(@Param("alarmNameEn") String alarmNameEn);

	public List<AlarmExcelModel> getAllWarnList(GetWarnListRequest request);
	/**
	 * @desc: 删除今天数据
	 * @author: kpchen
	 * @createTime: 2019年9月15日 下午6:55:04
	 * @history:
	 * @param string
	 * @return int
	 */
	public int dealAlarmsByDate(@Param("date") String date);

	public void saveErrorLog(TaskErrorLog errorLog);

	/**
	 * @desc: 获取今天的定时任务是否有异常
	 * @author: kpchen
	 * @createTime: 2019年9月15日 下午7:14:48
	 * @history:
	 * @param string
	 * @return String
	 */
	public String getErrorLog(@Param("date") String date);
	/**
	 * @desc: 删除当天异常日志记录
	 * @author: kpchen
	 * @createTime: 2019年9月15日 下午7:18:39
	 * @history:
	 * @param date
	 * @return int
	 */
	public int deleteErrorLog(@Param("date") String date);
	
}

	