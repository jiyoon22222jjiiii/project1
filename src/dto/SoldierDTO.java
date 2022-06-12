package dto;

public class SoldierDTO {

public String milinum;
public String stratum;
public String name;
public String birdate;
public String state;
public int gunnum;
public String belong_to;
public String pw;
	
	public SoldierDTO() {}
	
	public SoldierDTO(String milinum, String stratum, String name, String birdate, String state, int gunnum,
			String belong_to) {
		
		this.milinum = milinum;
		this.stratum = stratum;
		this.name = name;
		this.birdate = birdate;
		this.state = state;
		this.gunnum = gunnum;
		this.belong_to = belong_to;
	}
	
	public SoldierDTO(String milinum,String pw) {
		this.milinum = milinum;
		this.pw = pw;
		
	}
	
	
	
}
