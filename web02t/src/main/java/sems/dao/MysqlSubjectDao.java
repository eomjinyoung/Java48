package sems.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sems.vo.SubjectVo;

@Component
public class MysqlSubjectDao implements SubjectDao {
	@Autowired
	SqlSessionFactory sqlSessionFactory;

	public void insert(SubjectVo subject) throws Throwable {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.insert("sems.subject.insert", subject);
			sqlSession.commit();
		} catch (Throwable e) {
			throw e;
			
		} finally { 
			try {sqlSession.close();} catch (Throwable e2) {}
		}
	}
	
	public List<SubjectVo> list(int pageNo, int pageSize) 
			throws Throwable {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			HashMap<String,Integer> params = new HashMap<String,Integer>();
			params.put("startIndex", (pageNo - 1) * pageSize);
			params.put("pageSize", pageSize);

			return sqlSession.selectList("sems.subject.list", params);
			
		} catch (Throwable e) {
			throw e;
			
		} finally { 
			try {sqlSession.close();} catch (Throwable e2) {}
		}
	}
	
	public SubjectVo detail(int no) throws Throwable {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			SubjectVo vo = sqlSession.selectOne("sems.subject.detail", no);
			if (vo == null) {
				throw new Exception("해당 과목을 찾을 수 없습니다.");
			}
			return vo;
			
		} catch (Throwable e) {
			throw e;
			
		} finally { 
			try {sqlSession.close();} catch (Throwable e2) {}
		}
	}
	
	public void update(SubjectVo subject) throws Throwable {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.update("sems.subject.update", subject);
			sqlSession.commit();
			
		} catch (Throwable e) {
			throw e;
			
		} finally { 
			try {sqlSession.close();} catch (Throwable e2) {}
		}
	}
	
	public void delete(int no) throws Throwable {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.delete("sems.subject.delete", no);
			sqlSession.commit();
			
		} catch (Throwable e) {
			throw e;
			
		} finally { 
			try {sqlSession.close();} catch (Throwable e2) {}
		}
	}
}



















