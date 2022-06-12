package view;

import java.util.Scanner;

import dto.SoldierDTO;



public class Soldiermanagerview {
	public Soldiermanagerview() {
		System.out.println("------병사관리------");
		SoldierDTO Soldierdto = new SoldierDTO();
		Scanner sc = new Scanner(System.in);
		while(true) {
			
			System.out.println("1. 병사입대\n2. 병사목록\n3. 병사 정보수정\n4. 병사 전역\n5. 뒤로가기");
			int choice = sc.nextInt();
			
			if(choice==5) {
				System.out.println("간부뷰로");
				break;
			}
			
			else if(choice == 1) {
				new Soldierenlistview();
				break;
				
			}
			else if(choice == 2) {
				new Soldierinforview();
				break;
			}
			else if(choice == 3) {
				new Soldierreviseview();
			}
			else if(choice == 4) {
				new Soldierdischargeview();
			}
		}
		
		
	}
}
