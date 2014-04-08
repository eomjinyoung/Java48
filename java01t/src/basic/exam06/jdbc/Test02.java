package basic.exam06.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;



public class Test02 {

	public static void main(String[] args) throws Exception {
		// 1) java.jdbc.Driver 구현체를 로딩 => JDBC 드라이버 관리자에 등록   
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2) DB 커넥션 객체 가져오기
		// - Driver로부터 직접 Connection 객체를 얻지 않는다.
		// => DriverManager에게 요청 => Driver의 connect() 호출
		// => Driver는 Connection 객체를 리턴 => DriverManager는 받은 걸 리턴.
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.200.71:3306/studydb", // jdbc url 
				"study", // username
				"study"); // password
		
		System.out.println("오호라..연결되었다!");
		
		con.close(); // 서버에 연결 종료를 요청한다.
		// 만약, close()를 호출하지 않으면 서버는 타임아웃 될 때까지 연결을 유지한다.

	}

}












