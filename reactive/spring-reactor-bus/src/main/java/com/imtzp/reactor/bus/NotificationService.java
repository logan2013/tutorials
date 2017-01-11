package com.imtzp.reactor.bus;

public interface NotificationService {

	void initiateNotification(NotificationData notificationData) throws InterruptedException;
}
