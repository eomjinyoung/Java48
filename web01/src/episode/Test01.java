package episode;


public class Test01 {

	public static void main(String[] args) {
		// Student에 설정된 @ClassInfo 애노테이션을 값 추출
		
		Student s = new Student();
		s.setName("홍길동");
		s.setAge(20);

		// 1) 클래스 정보를 다룰 객체를 얻는다.
		//Class clazz = s.getClass();  // 방법1 인스턴스로부터 얻기
		Class clazz = Student.class;   // 방법2. 클래스 변수로부터 얻기 
		
		//Annotation[] annotations = clazz.getAnnotations();
		//ClassInfo ci = (ClassInfo)annotations[0];
		ClassInfo ci = (ClassInfo) clazz.getAnnotation(ClassInfo.class);
		System.out.println(ci.value());
		System.out.println(ci.author());
		System.out.println(ci.createdDate());
		System.out.println(ci.version());
	}
	
	public static void main01(String[] args) {
		Student s = new Student();
		s.setName("홍길동");
		s.setAge(20);

		// 클래스에 대한 부가 정보를 클래스 변수를 통해 추출하는 것은 
		// 바람직하지 않다.
		//System.out.println(Student.author);
		//System.out.println(Student.createdDate);
		
	}

}
