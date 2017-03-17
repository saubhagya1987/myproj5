package org.ireslab.notification.service;

import org.ireslab.notification.bean.GcmUser;



public interface GcmService 
{
	public void sendGcm(GcmUser smsUser) throws Exception;
}
