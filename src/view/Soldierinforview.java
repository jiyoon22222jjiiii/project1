package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.SoldierDAO;
import dto.SoldierDTO;



public class Soldierinforview {
	public Soldierinforview() {
		SoldierDAO Soldierdao = new SoldierDAO();
		Scanner sc = new Scanner(System.in);
		SoldierDTO Soldierdto = new SoldierDTO();
		System.out.println("------병사 정보 페이지------");
		System.out.printf("사단 : ");
		String belong_to = sc.next();
		
		ArrayList<SoldierDTO> result = Soldierdao.search(belong_to);
		if(result.size()==0) {
			System.out.println("사단에 병사 목록이 없습니다.");
		}
		else {
			for(SoldierDTO s : result) {
				System.out.printf("군번 : %s\n계급 : %s\n이름 : %s\n생년월일 : %s\n상태 : %s\n총기 : %d\n소속 : %s\n",
						s.milinum,s.stratum,s.name,s.birdate,s.state,s.gunnum,s.belong_to);
				
			}
		}
		
	}
}
