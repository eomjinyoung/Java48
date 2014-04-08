package basic.exam06.jdbc.up2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/* PreparedStatement 사용
 */
public class DeleteTest {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studydb", 
				"study", 
				"study"); 
		
		PreparedStatement stmt = con.prepareStatement(
				"delete from SE_SUBJS where SNO=?"
				);

		Scanner sc = new Scanner(System.in);
		
		stmt.setInt(1, Integer.parseInt(sc.nextLine()));
		
		stmt.executeUpdate();
		
		System.out.println("삭제 성공!");
		
		stmt.close();
		con.close(); 
	}

}












