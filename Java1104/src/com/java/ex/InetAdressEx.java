package com.java.ex;

import java.net.InetAddress;
import java.util.Scanner;

public class InetAdressEx {
	Scanner sc;
	public InetAdressEx() {
		System.out.println("Host 입력: ");
		
		sc = new Scanner(System.in);
		try {
			InetAddress inetAdd = InetAddress.getByName(sc.next());
			
			System.out.println("Server 이름 : "+ inetAdd.getHostName());
			System.out.println("Server IP : "+inetAdd.getHostAddress());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
