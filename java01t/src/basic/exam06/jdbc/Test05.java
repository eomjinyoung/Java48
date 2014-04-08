package basic.exam06.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/* delete 요청
 * - executeUpdate() 사용
 * 
 * delete sql
 * - delete from 테이블명 where 조건
 */
public class Test05 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studydb", // jdbc url 
				"study", // username
				"study"); // password
		
		Statement stmt = con.createStatement();

		/* delete from SE_SUBJS where SNO=2
		 */
		
		stmt.executeUpdate(
				"delete from SE_SUBJS where SNO=2");
		
		System.out.println("삭제 성공!");
		
		stmt.close();
		con.close(); 
	}

}












