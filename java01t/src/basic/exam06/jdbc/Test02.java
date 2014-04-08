package basic.exam06.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test02 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studydb",
				//"jdbc:mysql://localhost:3306/studydb?useUnicode=true&characterEncoding=UTF-8", // jdbc url 
				"study", // username
				"study"); // password
		
		Statement stmt = con.createStatement();
		
		/*
		 * insert SE_SUBJS(TITLE, DEST) values('Java기초', '자바 기초 문법 강의') 
		 */
		stmt.executeUpdate(
				"insert SE_SUBJS(TITLE, DEST)"
				+ " values('Java고급', '자바 스레트, 네트워킹 프로그래밍')");
		
		System.out.println("입력 성공!");
		
		stmt.close();
		con.close(); 
	}

}












