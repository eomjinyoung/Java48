package basic.exam06.jdbc.up1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/*
 * PreparedStatement 사용
 * - SQL 템플릿을 준비 => 값을 나중에 할당 
 * - 바이너리 데이터를 넣을 수 있다.
 * - 코드가 간결하다.
 * - 반복하여 실행할 때 실행 속도가 빠르다.
 *   SQL 템플릿을 준비할 때 미리 DBMS가 원하는 형식에 맞추어 변환된다.
 *   반복할 때 마다 값만 할당하여 서버에 전달한다.
 *   매번 SQL문을 서버에 보내기 위해 변환하는 방식 보다 속도가 빠르다.
 */
public class InsertTest {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studydb",
				"study", 
				"study"); 
		
		// prepareStatement() : SQL 문을 미리 준비
		// - 입력 값은 ?로 처리
		// - ? : in-parameter
		PreparedStatement stmt = con.prepareStatement(
				"insert SE_SUBJS(TITLE, DEST) values(?, ?)");
		
		for (int i = 0; i < 100; i++) {
			// in-parameter에 값을 넣을 때는 setXXX(인덱스, 값) 호출한다.
			// - XXX는 파라미터의 타입이다.
			stmt.setString(1, "C 기초" + i);
			stmt.setString(2, "C 기초 문법을 배운다.");
			
			// 실행할 때는 SQL문을 주지 않는다.
			stmt.executeUpdate();
		}
		
		System.out.println("입력 성공!");
		
		stmt.close();
		con.close(); 
	}

}












