package basic.exam03.test02;

// * toString() 재정의
// - 인스턴스의 내용을 간단히 조사하고자 할 때 toString() 호출
// - System.out.println()에서도 이 메서드를 호출한다.
public class Student3 /*extends Object*/ {
	String 	name;
	int			kor;
	int			math;
	int			eng;
	
	public Student3(String name, int kor, int math, int eng) {
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
	  Student3 other = (Student3) obj;
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

	@Override
	public String toString() {
	  return "[" + this.name + ":" + this.kor + "," + this.eng + "," + this.math + "]";
	}

	
	
}





















