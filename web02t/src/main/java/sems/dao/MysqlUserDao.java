package sems.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sems.vo.UserVo;

@Repository
public class MysqlUserDao implements UserDao {
	static Logger log = Logger.getLogger(MysqlUserDao.class);
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	public MysqlUserDao() {
		log.debug("MysqlUserDao 생성됨");
	}
	
	@Override
  public UserVo getUser(String email, String password) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			HashMap<String,String> params = new HashMap<String,String>();
			params.put("email", email);
			params.put("password", password);
			
			UserVo vo = sqlSession.selectOne("sems.user.getUser", params);
			
			if (vo != null) {
				return vo;
			} else {
				throw new Exception("아이디와 암호가 일치하는 사용자가 없습니다.");
			}
		} catch (Throwable e) {
			throw new DaoException(e);
			
		} finally { 
			try {sqlSession.close();} catch (Throwable e2) {}
		}
  }

}








