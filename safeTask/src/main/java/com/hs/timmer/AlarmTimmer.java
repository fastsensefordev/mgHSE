package com.hs.timmer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hs.service.AlarmService;

@Component
public class AlarmTimmer {
	@Autowired
	private AlarmService alarmService;
	/**
	 * @desc: 每天晚上21:55执行一次
	 * @author: kpchen
	 * @createTime: 2019年10月16日 下午9:55:13
	 * @history: void
	 */
    //@Scheduled(cron= "0 10 00 * * ?")
	public void execute() {
    	alarmService.parseData();
	}
    
//    @Scheduled(cron= "0/2 * * * * ? ")
	public void realTimeTask() {
    	alarmService.realTimeTask();
	}
}

	