package com.sd.uni.labpatologia.service.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.service.message.IMessageService;

@Service
@Transactional
@EnableScheduling
public class MessageCron {
	@Autowired
	private IMessageService messageService;
	
	@Scheduled(cron = "${cron.secondPeriod}")
    public void sendNotification(){
		try {
			messageService.sendNotifications();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}