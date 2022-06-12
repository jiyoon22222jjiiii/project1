package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.ExecutiveDTO;

public class ExecutiveDAO {
	// 다른곳에서 수정 못하도록 private로 만들어줌.
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//다리를 통해서 데이터베이스를 연결
	//executivedao 생성자가 호출되었다면 DB연결
	public ExecutiveDAO() {
		conn = DBConnection.getConnection();
	}

	public boolean checkmilinum(String milinum) {
		//받은 군번으로 가입된 게 있다면 모든정보를 검색.
		String sql = "select * from executive where milinum = ?";
		try {
			//(다리에서 택배차를 준비시킴) sql명령문을  ps에 넣기 
			ps = conn.prepareStatement(sql);
			//첫번째 물음표에 간부의 군번을 넣어줘라.
			ps.setString(1,milinum);
			// select문은 executeQuery를 함.
			// sql문 수행하기 위해서 executeQuery문을 써주고 그 결과를 rs에 담아준다.
			rs = ps.executeQuery();
			
			//행을 바꿔서 검색해보고 없으면 true!
			return !rs.next();
		} catch (SQLException e) {
			
		}
		
		return false;
	}

	public boolean join(ExecutiveDTO newExecutive) {
				//받은 정보를 테이블에 삽입 
				String sql = "insert into executive (milinum,pw,stratum,position,name,birdate,gunnum,belong_to) values(?,?,?,?,?,?,?,?)";
				
				try {
					//(다리에서 택배차를 준비시킴) sql명령문을  ps에 넣기 
					ps = conn.prepareStatement(sql);
					//몇번째 물음표에 간부의 정보를 넣어줘라.
					ps.setString(1,newExecutive.milinum);
					ps.setString(2,newExecutive.pw );
					ps.setString(3,newExecutive.stratum );
					ps.setString(4,newExecutive.position );
					ps.setString(5,newExecutive.name );
					ps.setString(6,newExecutive.birdate );
					ps.setInt(7,newExecutive.gunnum );
					ps.setString(8,newExecutive.belong_to );
					
					//insert는 executeUpdate수행
					//간부의 정보가 행 1개가 추가 되면 트루!
					return ps.executeUpdate() == 1;
					
				} catch (SQLException e) {
					
				}
				
				return false;
		
	}

	public boolean login(String milinum, String pw) {
		//받은 군번,비번 으로 가입된 게 있다면 모든정보를 검색.
				String sql = "select * from executive where milinum = ? and pw = ?";
				try {
					//(다리에서 택배차를 준비시킴) sql명령문을  ps에 넣기 
					ps = conn.prepareStatement(sql);
					//첫번째 물음표에 간부의 군번을 넣어줘라.
					ps.setString(1,milinum);
					ps.setString(2, pw);
					// select문은 executeQuery를 함.
					// sql문 수행하기 위해서 executeQuery문을 써주고 그 결과를 rs에 담아준다.
					rs = ps.executeQuery();
					//행을 바꿔서 검색해보고 있으면 true
					if(rs.next()) {
						ExecutiveDTO Executiveuser = new ExecutiveDTO();
						Executiveuser.milinum=rs.getString("milinum");
						Executiveuser.pw=rs.getString("pw");
						Executiveuser.stratum = rs.getString("stratum");
						Executiveuser.position = rs.getString("position");
						Executiveuser.name = rs.getString("name");
						Executiveuser.birdate = rs.getString("birdate");
						Executiveuser.gunnum = rs.getInt("gunnum");
						Executiveuser.belong_to = rs.getString("belong_to");
						
						//세션 저장.
						Session.setData("Executiveuser",Executiveuser);
						return true;
					}
					
				} catch (SQLException e) {
					
				}
				return false;
	}

	public boolean leavemili(String milinum) {
			String sql = "delete from executive where milinum = ?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, milinum);
				if(ps.executeUpdate()==1) {
					Session.setData("Executiveuser", null);
					return true;
				}
			} catch (SQLException e) {
				
			}
				
		
		return false;
	}

	public boolean modify(String milinum, int choice, String newData) {
		String[] cols = {"","pw","stratum","position","name","birdate","gunnum","belong_to"};
		
		String sql = "update executive set "+cols[choice]+" = ? where milinum = ?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, newData);
			ps.setString(2, milinum);
			
			if(ps.executeUpdate() == 1) {
				sql = "select * from executive where milinum = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, milinum);
		
				rs = ps.executeQuery();
				if(rs.next()) {
					ExecutiveDTO Executiveuser = new ExecutiveDTO();
					Executiveuser.milinum = rs.getString("milinum");
					Executiveuser.pw = rs.getString("pw");
					Executiveuser.stratum = rs.getString("stratum");
					Executiveuser.position = rs.getString("position");
					Executiveuser.name = rs.getString("name");
					Executiveuser.birdate = rs.getString("birdate");
					Executiveuser.gunnum = rs.getInt("gunnum");
					Executiveuser.belong_to = rs.getString("belong_to");
					Session.setData("Executiveuser", Executiveuser);
				}
				return true;
			}
		} 
		catch (SQLException e) {
			
		}
		
		return false;
	}

}
