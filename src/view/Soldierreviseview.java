package view;

import java.util.Scanner;

import dao.SoldierDAO;
import dto.SoldierDTO;

public class Soldierreviseview {
	public Soldierreviseview() {
		System.out.println("------병사수정페이지------");
		SoldierDAO Soldierdao = new SoldierDAO();
		Scanner sc = new Scanner(System.in);
		System.out.printf("수정할 병사의 군번을 입력해 주세요 : ");
		String milinum = sc.next();
		System.out.println("수정할 병사 정보를 선택하세요.");
		System.out.println("1. 계급수정\n2. 이름수정\n3. 생년월일수정\n4. 상태수정\n5. 총기번호수정\n6. 소속수정");
		System.out.printf("수정할 번호 : ");
		int choice = sc.nextInt();
		
		System.out.printf("수정할 데이터: ");
		String newData = sc.next();
		
		if(Soldierdao.revise(milinum,choice,newData)) {
			System.out.println("병사 정보 수정을 완료 했습니다.");
		}
		
		else {
			System.out.println("병사 정부 수정 실패 다시 시도해 주세요.");
		}
				
		
		
		
	}
}
