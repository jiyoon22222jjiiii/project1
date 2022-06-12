package view;

import java.util.Scanner;

public class Joinview {
	public Joinview() {
		System.out.println("------회원가입 페이지------");
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("1. 간부\n2. 상담가\n3.뒤로가기");	
		int choice = sc.nextInt();
		if(choice == 1) {
			new ExecutiveJoinview();
			break;
		}
		else if(choice == 2 ) {
			new ConsultantJoinview();
			break;
		}
		else if(choice == 3) {
			break;
		}
	
		
		}
		
		}
}
