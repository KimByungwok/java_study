package com.java.ex;

public class MainClass {

	public static void main(String[] args) {
		/*TryCatch tc = new TryCatch(10, 2);
		tc.setNum1(5);  // 트라이 캐치
		tc.setNum2(0);
		tc.result();*/
		
		ArrayException ae = new ArrayException();
		ae.printIArr(); //어레이 익셉션
	}
}
