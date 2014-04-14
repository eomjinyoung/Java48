package episode;

/* 애노테이션 사용
 * - 사용 위치: 클래스 선언 앞, 변수 선언 앞, 메서드 선언 앞
 * 
 */
//@ClassInfo(value="학생 정보")
//@ClassInfo("학생 정보") // value 속성 값만 줄 때는 value 속성명 생략 가능
// 다른 이름의 속성은 생략 불가!
@ClassInfo(
		value="학생 정보", 
		author={"홍길동","임꺽정"}, 
		createdDate="2014-5-5",
		version=2
)
public class Student {
	String name;
	int age;
	
	// 개발 정보 또는 실행 시에 사용할 정보 
	// - 클래스와 상관없다.
	// - 클래스 정의와 상관없는 정보를 보관할 목적으로 애노테이션 문법이 등장!
	//public static final String author = "홍길동";
	//public static final String createdDate = "2015-5-5";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
