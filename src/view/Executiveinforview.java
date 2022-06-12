package view;

import dao.Session;
import dto.ExecutiveDTO;

public class Executiveinforview {
	public Executiveinforview() {
		ExecutiveDTO Executiveuser = (ExecutiveDTO)Session.getData("Executiveuser");
		System.out.println("------"+Executiveuser.name+"간부 정보------");
		System.out.println("군번 : "+Executiveuser.milinum);
		System.out.println("암호 : "+Executiveuser.pw);
		System.out.println("계급 : "+Executiveuser.stratum);
		System.out.println("직책 : "+Executiveuser.position);
		System.out.println("이름 : "+Executiveuser.name);
		System.out.println("생년월일 : "+Executiveuser.birdate);
		System.out.println("총기번호 : "+Executiveuser.gunnum);
		System.out.println("소속 : "+Executiveuser.belong_to);
		
	}
}
