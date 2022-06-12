package view;

import java.util.Scanner;

import dao.ExecutiveDAO;
import dao.Session;
import dto.ExecutiveDTO;

public class ExecutiveLoginview {
	ExecutiveLoginview() {
		Scanner sc = new Scanner(System.in);
		ExecutiveDAO Executivedao = new ExecutiveDAO();
		System.out.printf("군번 :");
		String milinum = sc.next();
		System.out.printf("비번 : ");
		String pw = sc.next();
		
		if(Executivedao.login(milinum,pw)) {
			//간부 메인뷰 부르기
			String Executivename = ((ExecutiveDTO)Session.getData("Executiveuser")).name;
			System.out.println(Executivename+"님 어서오세요~");
			new ExecutiveMainview();
		}
		else
			System.out.println("로그인 실패 / 아이디 혹은 비밀번호를 확인해주세요.");
		
	}
}
