package com.hs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hs.model.TblAlarmInfo;

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

	public List<TblAlarmInfo> getWarnList();
	
}

	