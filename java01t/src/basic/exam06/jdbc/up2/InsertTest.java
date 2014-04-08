package basic.exam06.jdbc.up2;


/* SubjectDao 사용
 */
public class InsertTest {

	public static void main(String[] args) throws Throwable {
		SubjectVo subject = new SubjectVo();
		subject.title = "Java의 신";
		subject.description = "자바의 신을 존경할 수 있을 정도의 실력으로 향상시킴.";
		
		SubjectDao dao = new SubjectDao();
		dao.insert(subject);
		
		System.out.println("등록 성공!!!");
	}

}












