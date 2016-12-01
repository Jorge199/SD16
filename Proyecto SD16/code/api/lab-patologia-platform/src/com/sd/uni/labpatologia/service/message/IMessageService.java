package com.sd.uni.labpatologia.service.message;

import com.sd.uni.labpatologia.exception.PatologyException;

public interface IMessageService {
	public void sendNotifications() throws PatologyException;
}
