package basic.exam06.jdbc.up2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/* 페이징 처리
 * - 
 */
public class ListTest {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studydb", 
				"study", 
				"study"); 
		
		/*
	 	select sno, title, dest 
		from SE_SUBJS 
		order by sno desc
		limit 페이지 시작 인덱스, 페이지당 출력 개수
	 */
		PreparedStatement stmt = con.prepareStatement(
				"select SNO, TITLE, DEST from SE_SUBJS"
						+ " order by SNO desc"
						+ " limit ?, ?");
		Scanner scanner = new Scanner(System.in);
		ResultSet rs = null;
		int pageNo = 1, pageSize = 10;
		do {
			stmt.setInt(1, (pageNo - 1) * pageSize);
			stmt.setInt(2, pageSize);
			
			rs = stmt.executeQuery();
			
			System.out.println("[" + pageNo + "]----------------------------");
			while(rs.next()) {
				System.out.print(rs.getInt("SNO") + ",");
				System.out.print(rs.getString("TITLE") + ",");
				System.out.println(rs.getString("DEST"));
			}
			rs.close();
			
			pageNo = Integer.parseInt(scanner.nextLine());
			
		} while(pageNo > 0);
		
		
		stmt.close();
		con.close(); 
	}

}












