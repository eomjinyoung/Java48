package basic.exam06.jdbc.up6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 1) DB 커넥션 풀 사용
// 2) DI(Dependency Injection): 의존객체를 외부에서 주입받기
//			- 의존 객체를 주입할 setXXX() 메서드를 준비한다.
//			- setXXX() : 셋터(setter)
public class MysqlSubjectDao implements SubjectDao {
	DBConnectionPool dbConnectionPool;

	// 외부에서 DBConnectionPool 객체를 주입할 수 있도록 함
	public void setDBConnectionPool(DBConnectionPool dbConnectionPool) {
		this.dbConnectionPool = dbConnectionPool;
	}
	
	public void insert(SubjectVo subject) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dbConnectionPool.getConnection();
			stmt = con.prepareStatement(
					"insert SE_SUBJS(TITLE, DEST) values(?, ?)");
			stmt.setString(1, subject.title);
			stmt.setString(2, subject.description);
			stmt.executeUpdate();
		} catch (Throwable e) {
			throw e;
		} finally { 
			try {stmt.close();} catch (Throwable e2) {}
			dbConnectionPool.returnConnection(con);
		}
	}
	
	public List<SubjectVo> list(int pageNo, int pageSize) 
			throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = dbConnectionPool.getConnection();
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
			dbConnectionPool.returnConnection(con);
		}
	}
	
	public SubjectVo detail(int no) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = dbConnectionPool.getConnection();
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
			dbConnectionPool.returnConnection(con);
		}
	}
	
	public void update(SubjectVo subject) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dbConnectionPool.getConnection();
			stmt = con.prepareStatement(
					"update SE_SUBJS set"
							+ " TITLE=?" 
							+ ", DEST=SubjectVo?"
							+ " where SNO=?");
			stmt.setString(1, subject.title);
			stmt.setString(2, subject.description);
			stmt.setInt(3, subject.no);
			stmt.executeUpdate();
		} catch (Throwable e) {
			throw e;
		} finally { 
			try {stmt.close();} catch (Throwable e2) {}
			dbConnectionPool.returnConnection(con);
		}
	}
	
	public void delete(int no) throws Throwable {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dbConnectionPool.getConnection();
			stmt = con.prepareStatement(
					"delete from SE_SUBJS where SNO=?"	);
			stmt.setInt(1, no);
			stmt.executeUpdate();
		} catch (Throwable e) {
			throw e;
		} finally { 
			try {stmt.close();} catch (Throwable e2) {}
			dbConnectionPool.returnConnection(con);
		}
	}
}



















