package basic.exam06.jdbc.up3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao {
	public void insert(SubjectVo subject) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studydb",
					"study", 
					"study"); 
	
			stmt = con.prepareStatement(
					"insert SE_SUBJS(TITLE, DEST) values(?, ?)");
			
			stmt.setString(1, subject.title);
			stmt.setString(2, subject.description);
			
			stmt.executeUpdate();
			
			
		} catch (Throwable e) {
			throw e;
			
		} finally { // try.. catch 블록을 나가기 전에 반드시 수행되는 블록
			// try 블록에서 준비한 작업을 마무리하는 명령어를 놓는다.
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}
		}
	}
	
	public List<SubjectVo> list(int pageNo, int pageSize) 
			throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studydb", 
					"study", 
					"study"); 
			
			stmt = con.prepareStatement(
					"select SNO, TITLE from SE_SUBJS"
							+ " order by SNO desc"
							+ " limit ?, ?");
			
			stmt.setInt(1, (pageNo - 1) * pageSize);
			stmt.setInt(2, pageSize);
			
			rs = stmt.executeQuery();
			
			ArrayList<SubjectVo> list = new ArrayList<SubjectVo>();
			SubjectVo subject = null;
			
			while(rs.next()) {
				subject = new SubjectVo();
				subject.no = rs.getInt("SNO");
				subject.title = rs.getString("TITLE");
				
				list.add(subject);
			}
			return list;
			
		} catch (Throwable e) {
			throw e;
			
		} finally { 
			try {rs.close();} catch (Throwable e2) {}
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}
		}
	}
	
	public SubjectVo detail(int no) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studydb", 
					"study", 
					"study"); 
			
			stmt = con.prepareStatement(
					"select SNO, TITLE, DEST from SE_SUBJS"
							+ " where SNO=?");
			
			stmt.setInt(1, no);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				SubjectVo subject = new SubjectVo();
				subject.no = rs.getInt("SNO");
				subject.title = rs.getString("TITLE");
				subject.description = rs.getString("DEST");
				
				return subject;
			} else {
				throw new Exception("해당 과목을 찾을 수 없습니다.");
			}
			
		} catch (Throwable e) {
			throw e;
			
		} finally { 
			try {rs.close();} catch (Throwable e2) {}
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}
		}
	}
	
	public void update(SubjectVo subject) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studydb",  
					"study", 
					"study"); 

			stmt = con.prepareStatement(
					"update SE_SUBJS set"
							+ " TITLE=?" 
							+ ", DEST=?"
							+ " where SNO=?");
			
			stmt.setString(1, subject.title);
			stmt.setString(2, subject.description);
			stmt.setInt(3, subject.no);
			
			stmt.executeUpdate();
			
		} catch (Throwable e) {
			throw e;
			
		} finally { 
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}
		}
	}
	
	public void delete(int no) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studydb", 
					"study", 
					"study"); 
			stmt = con.prepareStatement(
					"delete from SE_SUBJS where SNO=?"	);
			stmt.setInt(1, no);
			stmt.executeUpdate();
		} catch (Throwable e) {
			throw e;
		} finally { 
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}
		}
	}
}









