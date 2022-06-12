package view;

import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		System.out.println("-------군사 관련 기능프로그램------");
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("1. 회원가입\n2. 로그인\n3. 마음의 편지\n4. 나가기");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
		{
			new Joinview();
			break;
		}
		case 2:
		{
			new Loginview();
			break;
		}
		case 3:
		{
			new Letterview();
			break;
		}
		case 4:
		{
			System.out.println("다음에 또오세욤!!!");
			break;
		}
		
		}
		}
	}

}
