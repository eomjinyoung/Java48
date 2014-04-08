package basic.exam06.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/* update 요청
 * - executeUpdate() 사용
 * 
 * update sql
 * - update 테이블명 set 컬럼명=값, 컬럼명=값, ... where 조건
 */
public class Test04 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studydb", // jdbc url 
				"study", // username
				"study"); // password
		
		Statement stmt = con.createStatement();

		/* update SE_SUBJS set 
		 * 		TITLE='Java Basic'
		 * where SNO=1
		 */
		
		stmt.executeUpdate(
				"update SE_SUBJS set"
				+ " TITLE='Java Basic'"
				+ " where SNO=1");
		
		System.out.println("변경 성공!");
		
		stmt.close();
		con.close(); 
	}

}












