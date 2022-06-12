package view;

import java.util.Scanner;

import dao.ExecutiveDAO;
import dto.ExecutiveDTO;


public class ExecutiveJoinview {
	public ExecutiveJoinview() {
		System.out.println("------간부용 회원가입 페이지------");
		Scanner sc = new Scanner(System.in);
		// 간부dao가 호출이 되면 자동으로 디비 연동
		ExecutiveDAO Executivedao = new ExecutiveDAO();
		System.out.printf("군번 : ");
		String milinum = sc.next();
		// 군번을 executivedao에다가 넘겨줘서 중복된 군번이 있나확인.
		if(Executivedao.checkmilinum(milinum)) {
			System.out.printf("암호 : ");
			String pw = sc.next();
			System.out.printf("계급 : ");
			String stratum = sc.next();
			System.out.printf("직책 : ");
			String position = sc.next();
			System.out.printf("이름 : ");
			String name = sc.next();
			System.out.printf("생년월일 : ");
			String birdate = sc.next();
			System.out.printf("총기번호 : ");
			int gunnum = sc.nextInt();
			System.out.printf("소속 : ");
			String belong_to = sc.next();
			
			// 사용자의 정보를 newExecutive라는 이름으로 객체를 넘겨준다.
			// DTO로 포장 하기 위해서 
			ExecutiveDTO newExecutive = new ExecutiveDTO(milinum,pw,stratum,position,name,
					birdate,gunnum,belong_to);
			//입력 받은거를 포장해서 join에 보냄
			if(Executivedao.join(newExecutive)) {
				System.out.println("회원가입에 성공하였습니다. ");
			}
			else {
				System.out.println("회원가입 실패했습니다. 다시 시도해 주세요.");
			}
			
		}
		else 
		{
			System.out.println("이미 가입된 군번입니다. 다시 한번 확인 부탁드립니다.");
		}
	}
}
