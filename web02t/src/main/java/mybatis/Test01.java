package mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sems.vo.SubjectVo;

public class Test01 {
	public static void mainx(String[] args) throws Exception {
		String mybatisConfigFile = "mupdateybatis/mybatis.xml";
		InputStream configStream = 
				Resources.getResourceAsStream(mybatisConfigFile);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(configStream);
		SqlSession sqlSession = factory.openSession(true);
		
		sqlSession.delete("test.subject.delete", 87);
		
		System.out.println("삭제 완료!");
		sqlSession.close();
	}
	
	public static void main04(String[] args) throws Exception {
		String mybatisConfigFile = "mybatis/mybatis.xml";
		InputStream configStream = 
				Resources.getResourceAsStream(mybatisConfigFile);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(configStream);
		
		// autocommit
		// - DML 실행 결과를 즉시 실제 DB에 반영하기
		SqlSession sqlSession = factory.openSession(true);
		
		SubjectVo vo = new SubjectVo()
			.setNo(31)
			.setTitle("xxxxxx")
			.setDescription("ssssss");
		
		sqlSession.update("test.subject.update", vo);
		
		System.out.println("변경 완료!");
		sqlSession.close();
	}
	
	public static void main03(String[] args) throws Exception {
		String mybatisConfigFile = "mybatis/mybatis.xml";
		InputStream configStream = 
				Resources.getResourceAsStream(mybatisConfigFile);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(configStream);
		SqlSession sqlSession = factory.openSession();
		
		SubjectVo vo = sqlSession.selectOne("test.subject.detail", 31);
		
		System.out.format("%1$3d %2$s\n", vo.getNo(), vo.getTitle());
		System.out.println(vo.getDescription());
		
		sqlSession.close();
	}
	
	public static void main02(String[] args) throws Exception {
		String mybatisConfigFile = "mybatis/mybatis.xml";
		InputStream configStream = 
				Resources.getResourceAsStream(mybatisConfigFile);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(configStream);
		SqlSession sqlSession = factory.openSession();
		
		SubjectVo vo = new SubjectVo()
			.setTitle("aaaa2")
			.setDescription("aaaaa2");
		
		sqlSession.insert("test.subject.insert", vo);
		sqlSession.commit();
		System.out.println("입력 완료!");
		
		sqlSession.close();
	}
	
	public static void main01(String[] args) throws Exception {
		String mybatisConfigFile = "mybatis/mybatis.xml";
		InputStream configStream = 
				Resources.getResourceAsStream(mybatisConfigFile);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(configStream);
		SqlSession sqlSession = factory.openSession();
		
		// SqlSession 객체르 통해 데이터베이스에 질의한다.
		// - 파라미터 값은 SQL 파일에 있는 특정 SQL 문의 아이디 값이다.
		List<SubjectVo> list = sqlSession.selectList("test.subject.list");

		for (SubjectVo vo : list) {
			System.out.println(vo.getNo() + "," + vo.getTitle());
		}
		
		sqlSession.close();
	}

}


















