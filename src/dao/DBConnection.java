package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection conn;			//conn의 객체 생성 
	
	public static Connection getConnection() {
		//싱글톤 패턴 
		//처음에 메소드를 호출 하기 위해서
		//객체 하나만 생성하기 위해서
		if(conn == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");				//드라이버 로딩을 주는 것 
				String url = "jdbc:mysql://localhost:3306/project1";	//목적지의 주소 
				String user = "root";
				String password = "1234";
													//주소,user,비번을 conn객체에 담아서 보내줌
				conn = DriverManager.getConnection(url, user, password);		
			} catch (ClassNotFoundException e) {
				System.out.println("드라이버 로딩 실패 "+e);
			} catch (SQLException e) {
				System.out.println("DB 연결 실패"+e);
			}	
		}
		//아니라면 그냥 conn리턴 
		return conn;
	}
}
