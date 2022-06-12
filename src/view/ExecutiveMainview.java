package view;

import java.util.Scanner;

import dao.Session;
import dto.ExecutiveDTO;

public class ExecutiveMainview {
	public ExecutiveMainview() {
		System.out.println("------간부용 메인 페이지------");
		Scanner sc = new Scanner(System.in);
		while(true) {
			ExecutiveDTO Executiveuser = (ExecutiveDTO)Session.getData("Executiveuser");
			if(Executiveuser == null) {
				System.out.println("로그인 후 이용해주세요.");
				break;
			}
			System.out.println("1. 개인정보 보기\n2. 개인정보 수정\n3. 병사관리\n4. 종합관리\n5.로그아웃");
			int choice = sc.nextInt();
			
			switch(choice ) {
			case 1:
			{
				new Executiveinforview();
				break;
			}
			case 2:
			{
				new Executivereviseview();
				break;
			}
			case 3:
			{
				new Soldiermanagerview();
				break;
			}
			case 4:
			{
				break;
			}
			case 5:
			{
				System.out.println(Executiveuser.name+"간부님 로그아웃 되었습니다");
				Session.setData("Executiveuser", null);
				break;
				
			}
			
			}
		}
			
		}
}
