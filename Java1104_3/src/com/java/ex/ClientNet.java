package com.java.ex;

import java.awt.AWTError;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientNet {
	Socket soc = null;
	PrintWriter writer = null;
	BufferedReader reader = null;
	
	public ClientNet() {
		try {
			soc = new Socket("localhost",5000); //포트번호 : 5000
			writer = new PrintWriter(soc.getOutputStream(),true);
			reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			
			String str =null;
			BufferedReader cReader = new BufferedReader(new InputStreamReader(System.in));
			
			while((str = cReader.readLine())!=null) {
				writer.println(str);
				System.out.println("출력된 값: "+ str);
			}
			
			writer.close();
			reader.close();
			cReader.close();
			soc.close();
		}catch (Exception e) {}
	}
	public static void main(String[] args) {
		new ClientNet();	
	}
}
