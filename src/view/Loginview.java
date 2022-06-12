package view;

import java.util.Scanner;

import dao.Session;
import dto.ExecutiveDTO;

public class Loginview {
	public Loginview() {
		Scanner sc = new Scanner(System.in);
		
			while(true) {
				System.out.println("------로그인 페이지------");
				System.out.println("1. 간부용\n2. 상담가");
				int choice = sc.nextInt();
			if(choice == 1) {
				new ExecutiveLoginview();
				break;
			}
			else if(choice == 2) {
				new ConsultantLoginview();
				break;
			}
		
				
				
			}
		
	}



}
