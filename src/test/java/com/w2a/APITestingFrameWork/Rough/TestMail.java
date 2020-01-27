package com.w2a.APITestingFrameWork.Rough;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.w2a.APITestingFrameWork.Utilities.MonitoringMail;
import com.w2a.APITestingFrameWork.Utilities.TestConfig;

public class TestMail {
	static String  messageBody;
	
	public static void main(String[] args) {
		MonitoringMail mail=new MonitoringMail();
		
		
		try {
			 messageBody="http://"+InetAddress.getLocalHost().getHostAddress()+":8080/job/APITestingFrameWork/Extent_20Report/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
