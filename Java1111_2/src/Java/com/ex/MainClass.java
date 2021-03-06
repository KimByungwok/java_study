package Java.com.ex;		//회원 추가

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		String query1 = "select * from member";
		String query2 = "insert into member values(?,?,?,?)";
		
		System.out.println("<<추가할 회원의 정보 입력>>");
		System.out.print("ID: ");
		String id = sc.next();
		System.out.print("PW: ");
		String pw = sc.next();
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("이메일: ");
		String email = sc.next();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,uid,pwd);
			stmt = con.createStatement();
			
			pstmt = con.prepareStatement(query2);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			int resultQuery = pstmt.executeUpdate();
			if (1 != resultQuery) System.out.println("회원 등록 실패다");
			else System.out.println("회원 등록 성공!");
			
			rs = stmt.executeQuery(query1);
			
			while(rs.next()) {
				String _id = rs.getString("m_id");
				String _pw = rs.getString("m_pw");
				String _name = rs.getString("m_name");
				String _email = rs.getString("m_email");
				
				System.out.println("ID: "+ _id);
				System.out.println("pw: "+ _pw);
				System.out.println("이름: "+ _name);
				System.out.println("이메일: "+ _email);
				System.out.println("================================");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
				if(pstmt != null)pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
	}
}
