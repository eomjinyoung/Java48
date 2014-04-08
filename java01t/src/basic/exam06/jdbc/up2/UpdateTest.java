package basic.exam06.jdbc.up2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/* PreparedStatement 사용 
 */
public class UpdateTest {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studydb", // jdbc url 
				"study", // username
				"study"); // password
		
		PreparedStatement stmt = con.prepareStatement(
				"update SE_SUBJS set"
						+ " TITLE=?"
						+ " where SNO=?");
		
		Scanner scanner = new Scanner(System.in);
		
		stmt.setString(1, scanner.nextLine());
		stmt.setInt(2, 1);
		
		stmt.executeUpdate();
		
		System.out.println("변경 성공!");
		
		stmt.close();
		con.close(); 
	}

}












