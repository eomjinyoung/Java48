package sems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import sems.annotations.Component;
import sems.vo.UserVo;

@Component
public class MysqlUserDao implements UserDao {
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
  public UserVo getUser(String email, String password) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(
					"select UNO, NAME, EMAIL, TEL"  
					+ " from SE_USERS"
					+ " where EMAIL=? and PWD=?");

			stmt.setString(1, email);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return new UserVo()
										.setNo(rs.getInt("UNO"))
										.setName(rs.getString("NAME"))
										.setEmail(rs.getString("EMAIL"))
										.setTel(rs.getString("TEL"));
			} else {
				throw new Exception("아이디와 암호가 일치하는 사용자가 없습니다.");
			}
		} catch (Throwable e) {
			throw new DaoException(e);
			
		} finally { 
			try {rs.close();} catch (Throwable e2) {}
			try {stmt.close();} catch (Throwable e2) {}
			try {con.close();} catch (Throwable e2) {}
		}
  }

}








