package view;

import java.util.Scanner;

import dao.ExecutiveDAO;
import dao.Session;
import dto.ExecutiveDTO;

public class Executivereviseview {
	public Executivereviseview() {
		ExecutiveDTO Executiveuser = (ExecutiveDTO)Session.getData("Executiveuser");
		ExecutiveDAO Executivedao = new ExecutiveDAO();
		Scanner sc = new Scanner(System.in);
		 
			
			System.out.println("------"+Executiveuser.name+"간부 정보------");
			System.out.println("군번 : "+Executiveuser.milinum);
			System.out.println("암호 : "+Executiveuser.pw);
			System.out.println("계급 : "+Executiveuser.stratum);
			System.out.println("직책 : "+Executiveuser.position);
			System.out.println("이름 : "+Executiveuser.name);
			System.out.println("생년월일 : "+Executiveuser.birdate);
			System.out.println("총기번호 : "+Executiveuser.gunnum);
			System.out.println("소속 : "+Executiveuser.belong_to);
			System.out.println("-------------------------------------------");
			System.out.printf("1. 암호수정\n2.계급수정\n3.직책수정\n4.이름수정\n5.생년월일수정\n6.총기번호수정\n7.소속수정\n8.회원탈퇴\n");
			System.out.printf("수정할 정보 번호: ");
			int choice = sc.nextInt();
			if(choice == 8) {
				System.out.printf("암호를 입력해 주세요 : ");
				String pw = sc.next();
				
				if(Executiveuser.pw.equals(pw)) {
					if(Executivedao.leavemili(Executiveuser.milinum)) {
						System.out.println("그동안 고생 많으셨습니다.");
						
					}
				}
			}
			
			else {
				System.out.println("새로운 정보 : ");
				sc = new Scanner(System.in);
				String newData = sc.next();
				if(Executivedao.modify(Executiveuser.milinum,choice,newData)) {
					System.out.println("정보 수정을 완료했습니다.");
				}
				else {
					System.out.println("정보 수정 실패 하여 다시 시도해 주시기 바랍니다.");
					
				}
				
				
			}
		}
		
		
	
}
