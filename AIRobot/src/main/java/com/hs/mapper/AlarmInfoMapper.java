package com.hs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hs.model.AlarmExcelModel;
import com.hs.model.AlarmType;
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
	
}

	