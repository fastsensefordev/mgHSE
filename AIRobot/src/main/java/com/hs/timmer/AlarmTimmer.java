package com.hs.timmer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hs.service.AlarmService;

@Component
public class AlarmTimmer {
	@Autowired
	private AlarmService alarmService;
	
    @Scheduled(cron="0 0/1 * * * ?")
	public void execute() {
    	alarmService.parseData();
	}
}

	