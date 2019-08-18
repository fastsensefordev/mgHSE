package com.hs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.mapper.AlarmInfoMapper;

@Service
public class AlarmService {
	@Autowired
	private AlarmInfoMapper alarmInfoMapper;
	public void parseData() {
		
	}

}

	