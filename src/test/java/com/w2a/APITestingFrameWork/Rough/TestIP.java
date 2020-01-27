package com.w2a.APITestingFrameWork.Rough;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestIP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("http://"+InetAddress.getLocalHost().getHostAddress()+":8080/job/APITestingFrameWork/Extent_20Report/");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
