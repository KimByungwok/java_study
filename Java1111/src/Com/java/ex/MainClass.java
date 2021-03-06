package Com.java.ex;		//회원 삭제

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MainClass {

		static String driver = "org.mariadb.jdbc.Driver";
		static String url = "jdbc:mariadb://Localhost:3308/test";
		static String uid = "root";
		static String pwd = "281471";
		
		public static void main(String[] args) {
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("삭제할 회원 이름 입력: ");
			String delName = sc.next();
			
			String query1 = "select * from member";
			String query2 = "delete from member where m_name='"+delName+"'";
			
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url,uid,pwd);
				stmt = con.createStatement();
				
				int resultQuery = stmt.executeUpdate(query2);
				if (1 != resultQuery) {
					System.out.println("회원 삭제 실패!");
					System.out.println("현재 회원 출력");
					System.out.println("");
				}
				else System.out.println("회원 삭제 성공!!");
				
				rs = stmt.executeQuery(query1);
				
				while(rs.next()) {
					String id = rs.getString("m_id");
					String pw = rs.getString("m_pw");
					String name = rs.getString("m_name");
					String email = rs.getString("m_email");
					
					System.out.println("ID: "+ id);
					System.out.println("pw: "+ pw);
					System.out.println("이름: "+ name);
					System.out.println("이메일: "+ email);
					System.out.println("================================");
				}
			}catch (Exception e) {
				e.printStackTrace();
				sc.close();
			}
		}
}
