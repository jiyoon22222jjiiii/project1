package view;

import java.util.Scanner;

import dao.SoldierDAO;

public class Soldierdischargeview {
	public Soldierdischargeview() {
		System.out.println("------병사 전역 페이지 입니다.------");
		SoldierDAO Soldierdao = new SoldierDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("전역한 병사 군번 :");
		String milinum = sc.next();
		
		if(Soldierdao.discharge(milinum)) {
			System.out.println("그동안 고생 많으셨습니다!! 전역을 축하드립니다!!");
		}
		
		else {
			System.out.println("병사 전역 실패! 다시 시도해 주세요");
		}
		
	}
}
