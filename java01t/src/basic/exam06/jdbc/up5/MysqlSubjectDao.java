package basic.exam06.jdbc.up5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// Connection을 작업들 사이에서 공유하기
// - 인스턴스 변수로 저장한다.
// - 문제점: Dao당 Connection 객체를 보유.
//          Dao가 많을 경우 가끔 사용되는 Dao도 하나의 커넥션 점유=> 낭비
// - 치명적인 문제(Critical Issue)
//   작업들이 커넥션을 공유 => 그 중 하나의 작업에서 오류 발생 =>
//   그 작업을 취소(rollback) => 그 작업이 사용하는 커넥션의 모든 작업들도 취소됨.
public class MysqlSubjectDao implements SubjectDao {
	Connection con = null;
	
	public MysqlSubjectDao() throws Throwable {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studydb", "study", "study"); 
	}
	
	public void insert(SubjectVo subject) throws Throwable {
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(
					"insert SE_SUBJS(TITLE, DEST) values(?, ?)");
			stmt.setString(1, subject.title);
			stmt.setString(2, subject.description);
			stmt.executeUpdate();
		} catch (Throwable e) {
			throw e;
		} finally { 
			try {stmt.close();} catch (Throwable e2) {}
		}
	}
	
	public List<SubjectVo> list(int pageNo, int pageSize) 
			throws Throwable {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
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
		}
	}
	
	public SubjectVo detail(int no) throws Throwable {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
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
		}
	}
	
	public void update(SubjectVo subject) throws Throwable {
		PreparedStatement stmt = null;
		try {
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
		}
	}
	
	public void delete(int no) throws Throwable {
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(
					"delete from SE_SUBJS where SNO=?"	);
			stmt.setInt(1, no);
			stmt.executeUpdate();
		} catch (Throwable e) {
			throw e;
		} finally { 
			try {stmt.close();} catch (Throwable e2) {}
		}
	}
	
	public void close() {
		try {con.close();} catch(Exception e) {}
	}
}



















