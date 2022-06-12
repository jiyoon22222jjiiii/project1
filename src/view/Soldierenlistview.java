package view;

import java.util.Scanner;

import dao.SoldierDAO;
import dto.SoldierDTO;

public class Soldierenlistview {
	public Soldierenlistview() {
		System.out.println("------병사 입대 뷰------");
		SoldierDAO Soldierdao = new SoldierDAO();
		Scanner sc = new Scanner(System.in);
			
			System.out.printf("병사 군번 : ");
			String milinum = sc.next();
			if(Soldierdao.checkmilinum(milinum)) {
			System.out.printf("병사 계급 :  ");
			String stratum = sc.next();
			System.out.printf("병사 이름 : ");
			String name = sc.next();
			System.out.printf("병사 생년월일 : ");
			String birdate = sc.next();
			System.out.printf("병사 상태 : ");
			String state = sc.next();
			System.out.printf("병사 총기번호 : ");
			int gunnum = sc.nextInt();
			System.out.printf("병사 소속 :  ");
			String belong_to = sc.next();
	
			
			SoldierDTO Soldierdto = new SoldierDTO(milinum,stratum,name,birdate,state,gunnum,belong_to);
			if(Soldierdao.enlist(Soldierdto)) {
				System.out.println("병사의 입대가 완료 되었습니다.");
			}
			else {
				System.out.println("병사의 입대가 실패했습니다. 다시 시도해 주세요");
			}
				
			}
			
			else {
				System.out.println("이미 가입된 병사입니다.");
			}
			
		
		
		
	}
}
