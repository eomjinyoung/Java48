package mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sems.vo.SubjectVo;

public class Test01 {
	public static void main(String[] args) throws Exception {
		String mybatisConfigFile = "mybatis/mybatis.xml";
		InputStream configStream = 
				Resources.getResourceAsStream(mybatisConfigFile);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(configStream);
		SqlSession sqlSession = factory.openSession();
		
		SubjectVo vo = sqlSession.selectOne("test.subject.detail", 87);
		
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


















