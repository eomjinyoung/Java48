package basic.exam06.jdbc.up7;

import java.util.List;
import java.util.Scanner;

// 1) DBConnectionPool을 준비
// 2) MysqlSubjectDao에 커넥션풀을 주입한다.
public class SubjectMgt {
  static Scanner sc = new Scanner(System.in);
  static SubjectDao dao;

	public static void testInsert() throws Throwable {
		dao.insert(new SubjectVo()
											.setTitle("Java의 신")
											.setDescription("자바의 신을 존경할 수 있을 정도의 실력으로 향상시킴."));
		
		System.out.println("등록 성공!!!");
	}
	
	public static void testList() throws Throwable {
		int pageNo = 1, pageSize = 10;
		
		do {
			List<SubjectVo> list = dao.list(pageNo, pageSize);
			
			System.out.println("[" + pageNo + "]----------------------------");
			for (SubjectVo subject : list) {
				System.out.print(subject.getNo() + ",");
				System.out.println(subject.getTitle());
			}
			
			pageNo = Integer.parseInt(sc.nextLine());
			
		} while(pageNo > 0);
	}
	
	public static void testUpdate() throws Throwable {
		dao.update(new SubjectVo()
											.setNo(106)
											.setTitle("오호라..변경")
											.setDescription("이제 내용도 변경하자!"));
		
		System.out.println("변경 성공!");
	}
	
	public static void testDelete() throws Throwable {
		dao.delete( Integer.parseInt(sc.nextLine()) );
		
		System.out.println("삭제 성공!");
	}
	
	public static void testDetail() throws Throwable {
		SubjectVo subject = dao.detail( Integer.parseInt(sc.nextLine()) );
		
		System.out.println(subject.getNo());
		System.out.println(subject.getTitle());
		System.out.println(subject.getDescription());
	}
	
	public static void main(String[] args) throws Throwable {
		DBConnectionPool dbConnectionPool = new DBConnectionPool();
		
		dao = new MysqlSubjectDao();
		((MysqlSubjectDao)dao).setDBConnectionPool(dbConnectionPool);
		
		String command = null;
		do {
			try { 
				System.out.print("명령>");
				command = sc.nextLine();
				switch(command) {
				case "insert":
					testInsert(); break;
				case "list":
					testList(); break;
				case "update":
					testUpdate(); break;
				case "delete":
					testDelete(); break;
				case "detail":
					testDetail(); break;
				}
			} catch (Throwable e) {}
			
		} while(!"q".equals(command));
		sc.close();	
		dbConnectionPool.closeAll();
	}
}




























