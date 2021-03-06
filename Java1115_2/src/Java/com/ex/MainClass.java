package Java.com.ex;

import java.util.ArrayList;
import java.util.Scanner;

import Java.com.ex.DB.MemberDAO;
import Java.com.ex.DB.MemberDTO;

public class MainClass {

	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 선택(1.회원 추가, 2.회원 검색,3. 회원 수정, 4.회원 탈퇴) : ");
		int menu = sc.nextInt();
		
		
		if(2==menu) {
			
			ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
			dtos = dao.select(); //뭔가 받아와여ㅑ함
			
			for (int i=1;i<=dtos.size();i++) {
				MemberDTO dto = dtos.get(i);
				
				System.out.println(dto.getId());
				System.out.println(dto.getPw());
				System.out.println(dto.getName());
				System.out.println(dto.getEmail());
			}
		}else if(1==menu){
			System.out.println("id,pw,name,email입력: ");
			String id = sc.next();
			String pw = sc.next();
			String name = sc.next();
			String email = sc.next();
			
			System.out.println("추가 완료");
			
			MemberDTO dto = new MemberDTO(id, pw, name, email);
			dao.insert(dto);
			
		}
		else if(3==menu){
			
		}
		else if(4==menu){
			String id = sc.next();
			dao.delete(id);
			
		}else {
			System.out.println("잘못 입력");
		}
	}
}
