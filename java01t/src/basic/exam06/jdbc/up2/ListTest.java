package basic.exam06.jdbc.up2;

import java.util.List;
import java.util.Scanner;

/* SubjectDao 사용
 */
public class ListTest {

	public static void main(String[] args) throws Throwable {
		SubjectDao dao = new SubjectDao();
		Scanner scanner = new Scanner(System.in);
		int pageNo = 1, pageSize = 10;
		
		do {
			List<SubjectVo> list = dao.list(pageNo, pageSize);
			
			System.out.println("[" + pageNo + "]----------------------------");
			for (SubjectVo subject : list) {
				System.out.print(subject.no + ",");
				System.out.println(subject.title);
			}
			
			pageNo = Integer.parseInt(scanner.nextLine());
			
		} while(pageNo > 0);
		
		scanner.close();
	}

}












