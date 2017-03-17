package org.ireslab.notification;

import org.ireslab.notification.bean.MailUser;
import org.ireslab.notification.bean.SmsUser;
import org.ireslab.notification.service.MailService;
import org.ireslab.notification.service.SmsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// TODO: Auto-generated Javadoc
/**
 * The Class TestMail.
 */
public class TestNotification {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// Create the application context
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");

		// Send SMS
		sendSms(context);

		// Send Email
		sendMail(context);
	}

	public static void sendSms(ApplicationContext context) throws Exception {
		SmsService smsSend = (SmsService) context.getBean("smsServiceClickaTell");
		SmsUser smsUser = new SmsUser();
		smsUser.setUserMobileNumber("918527007350");
		smsUser.setTextMessage("Your OTP is : 89654");
		smsSend.sendSms(smsUser);

	}

	public static void sendMail(ApplicationContext context) {
		// Get the mailer instance
		MailService mailer = (MailService) context.getBean("mailService");

		// create user bean

		MailUser user = new MailUser();
		user.setUserName("pramoj");
		user.setEmailAddress("pramojkumar.prusty@ireslab.com");
		user.setTemplateName("mailTemplet.html");
		user.setSubject("Test eMail services ( spring + velocity )");

		// Send a composed mail
		mailer.sendEmail(user);

	}
}
