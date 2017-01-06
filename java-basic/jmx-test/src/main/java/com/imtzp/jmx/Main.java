package com.imtzp.jmx;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class Main {

	public static void main(String[] args) {

		MBeanServer server = ManagementFactory.getPlatformMBeanServer();

		ObjectName objectName = null;
		try {
			objectName = new ObjectName("com.imtzp.jmx:type=basic,name=game");
			server.registerMBean(new Game(), objectName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (true) {

		}
	}
}
