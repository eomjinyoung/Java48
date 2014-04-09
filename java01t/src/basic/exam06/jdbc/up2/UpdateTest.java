package basic.exam06.jdbc.up2;


/* SubjectDao 사용
 */
public class UpdateTest {

	public static void main(String[] args) throws Throwable {
		SubjectDao dao = new SubjectDao();
		
		SubjectVo subject = new SubjectVo();
		subject.no = 106;
		subject.title = "오호라..변경";
		subject.description = "이제 내용도 변경하자!";
		
		dao.update(subject);
		
		System.out.println("변경 성공!");
	}

}












