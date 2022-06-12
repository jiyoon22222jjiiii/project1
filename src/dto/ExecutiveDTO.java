package dto;

public class ExecutiveDTO {
	public String milinum;
	public String pw;
	public String stratum;
	public String position;
	public String name;
	public String birdate;
	public int gunnum;
	public String belong_to;
	
	// 다른곳에서 호출할려고 기본생성자 생성
	public ExecutiveDTO() {}
	
	
	// 사용자에게 입력 받은거를 저장하기 위해서 생성자 생성
	public ExecutiveDTO(String milinum, String pw, String stratum, String position, String name, 
			String birdate,
			int gunnum, String belong_to) {
		this.milinum = milinum;
		this.pw = pw;
		this.stratum = stratum;
		this.position = position;
		this.name = name;
		this.birdate = birdate;
		this.gunnum = gunnum;
		this.belong_to = belong_to;
	}
}
