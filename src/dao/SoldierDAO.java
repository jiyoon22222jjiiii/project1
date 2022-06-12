package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.SoldierDTO;

public class SoldierDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public SoldierDAO() {
		conn = DBConnection.getConnection();
	}
	

	public boolean checkmilinum(String milinum) {
		
		String sql = "select * from soldier where milinum = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, milinum);
			
			rs = ps.executeQuery();
			
			return !rs.next();
			}
		catch (SQLException e) {
			}
		return false;
	}


	public boolean enlist(SoldierDTO Soldierdto) {
		
		String sql = "insert into soldier (milinum,stratum,name,birdate,state,gunnum,belong_to) values(?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,Soldierdto.milinum);
			ps.setString(2,Soldierdto.stratum);
			ps.setString(3,Soldierdto.name);
			ps.setString(4,Soldierdto.birdate);
			ps.setString(5,Soldierdto.state);
			ps.setInt(6, Soldierdto.gunnum);
			ps.setString(7,Soldierdto.belong_to);
			
			return ps.executeUpdate() == 1;
			
		} catch (SQLException e) {
			
			
		}
		
		return false;
	}
	
	 public ArrayList<SoldierDTO> search(String belong_to){
		 ArrayList<SoldierDTO> result = new ArrayList<SoldierDTO>();
		String sql = "select * from soldier where belong_to like('%"+belong_to+"%')";
		 try {
			ps = conn.prepareStatement(sql);
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 SoldierDTO Soldierdto = new SoldierDTO();
				 Soldierdto.milinum = rs.getString("milinum");
				 Soldierdto.stratum = rs.getString("stratum");
				 Soldierdto.name = rs.getString("name");
				 Soldierdto.birdate = rs.getString("birdate");
				 Soldierdto.state = rs.getString("state");
				 Soldierdto.gunnum = rs.getInt("gunnum");
				 Soldierdto.belong_to = rs.getString("belong_to");
				 
				 result.add(Soldierdto);
				
			 	}
		 } 
		 catch (SQLException e) {}
		 return result;
	}


	public boolean revise(String milinum,int choice, String newData) {
			String [] cols = {"","stratum","name","birdate","state","gunnum","belong_to"};
			String sql ="update soldier set "+cols[choice]+" = ? where milinum = ?";
			
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, newData);
				ps.setString(2, milinum);
				if(ps.executeUpdate() == 1) {
					sql = "select * from soldier where milinum = ?";
					ps = conn.prepareStatement(sql);
					ps.setString(1, milinum);
					rs = ps.executeQuery();
					if(rs.next()) {
						SoldierDTO Soldierdto = new SoldierDTO();
						Soldierdto.milinum = rs.getString("milinum");
						Soldierdto.stratum = rs.getString("stratum");
						Soldierdto.name = rs.getString("name");
						Soldierdto.birdate = rs.getString("birdate");
						Soldierdto.state = rs.getString("state");
						Soldierdto.gunnum = rs.getInt("gunnum");
						Soldierdto.belong_to = rs.getString("belong_to");
					}
					
					return true;
				}
				
			} 
			catch (SQLException e) {}
			
		return false;
	}


	public boolean discharge(String milinum) {
		String sql = "delete from soldier where milinum = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, milinum);
			return ps.executeUpdate() == 1;
		
		} catch (SQLException e) {
			
		}
		
		return false;
	}
	
	 public ArrayList<SoldierDTO> search2(String milinum){
		 ArrayList<SoldierDTO> result = new ArrayList<SoldierDTO>();
		String sql = "select * from soldier where milinum = ?";
		 try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, milinum);
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 SoldierDTO Soldierdto = new SoldierDTO();
				 Soldierdto.milinum = rs.getString("milinum");
				 Soldierdto.stratum = rs.getString("stratum");
				 Soldierdto.name = rs.getString("name");
				 Soldierdto.birdate = rs.getString("birdate");
				 Soldierdto.state = rs.getString("state");
				 Soldierdto.gunnum = rs.getInt("gunnum");
				 Soldierdto.belong_to = rs.getString("belong_to");
				 
				 result.add(Soldierdto);
				
			 	}
		 } 
		 catch (SQLException e) {}
		 return result;
	}
	 
	 public boolean inspect(String milinum) {
			
			String sql = "select * from soldierlog where milinum = ?";
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, milinum);
				
				rs = ps.executeQuery();
				
				return !rs.next();
				}
			catch (SQLException e) {
				}
			return false;
		}


	public boolean Join(SoldierDTO Soldierdto) {
		String sql = "insert into soldierlog (milinum,pw) values(?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,Soldierdto.milinum);
			ps.setString(2,Soldierdto.pw);
			
			return ps.executeUpdate() == 1;
			
		} catch (SQLException e) {
			
			
		}
		
		return false;
	}


	public boolean certification(String milinum, String pw) {
		String sql = "select * from soldierlog where milinum = ? and pw = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, milinum);
			ps.setString(2, pw);
			
			rs = ps.executeQuery();
			
			return rs.next();
			}
		catch (SQLException e) {
			}
		return false;
			
	}
	 


}
