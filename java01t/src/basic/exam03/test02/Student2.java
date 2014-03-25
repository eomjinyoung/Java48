package basic.exam03.test02;

// * Overriding(재정의)
// - 수퍼클래스의 메서드 중에서 서브 클래스에 맞지 않는 메서드를 재정의하기 
// - 문법: 수퍼클래스의 메서드 signature(시그너처)와 동일하게 메서드를 선언한다.
// - method signature = 메서드 이름, 리턴타입, 파라미터 개수 및 타입 
//                      파라미터 이름은 상관없다.

// * 애노테이션 
// - 컴파일러와 JVM에게 전달하는 아주 특별한 주석
public class Student2 /*extends Object*/ {
	String 	name;
	int			kor;
	int			math;
	int			eng;
	
	public Student2(String name, int kor, int math, int eng) {
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}

	/* @Override 애노테이션
	 * - 컴파일러에게 정보를 전달
	 * - 메서드를 오버라이딩 한다는 것을 알림.
	 */
	@Override
  public boolean equals(Object obj) {
	  if (this == obj)
		  return true;
	  if (obj == null)
		  return false;
	  if (getClass() != obj.getClass())
		  return false;
	  Student2 other = (Student2) obj;
	  if (eng != other.eng)
		  return false;
	  if (kor != other.kor)
		  return false;
	  if (math != other.math)
		  return false;
	  if (name == null) {
		  if (other.name != null)
			  return false;
	  } else if (!name.equals(other.name))
		  return false;
	  return true;
  }



	
	
}





















