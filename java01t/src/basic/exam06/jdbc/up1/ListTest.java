package basic.exam06.jdbc.up1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/* 
 */
public class ListTest {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studydb", 
				"study", 
				"study"); 
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("select SNO, TITLE, DEST from SE_SUBJS");
		
		while(rs.next()) {
			System.out.print(rs.getInt("SNO") + ",");
			System.out.print(rs.getString("TITLE") + ",");
			System.out.println(rs.getString("DEST"));
		}
		
		rs.close();
		stmt.close();
		con.close(); 
	}

}












