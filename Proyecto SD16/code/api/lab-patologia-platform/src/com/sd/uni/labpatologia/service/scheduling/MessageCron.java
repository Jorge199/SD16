package com.sd.uni.labpatologia.service.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.service.message.IMessageService;

@Service
@Transactional
public class MessageCron {
	@Autowired
	private IMessageService messageService;
	
	@Scheduled(initialDelay=5000, fixedRate=60000)
    public void sendNotification() {
		messageService.sendNotifications();
    }

}