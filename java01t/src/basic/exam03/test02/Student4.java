package basic.exam03.test02;

// * hashCode() 재정의
// - hash code: 인스턴스를 구분하는 식별자 (32비트)
// - 같은 콘텐츠를 가진 인스턴스에 대해 같은 식별자를 부여하도록 재정의
public class Student4 /*extends Object*/ {
	String 	name;
	int			kor;
	int			math;
	int			eng;
	
	public Student4(String name, int kor, int math, int eng) {
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}

	@Override
  public int hashCode() {
	  final int prime = 31;
	  int result = 1;
	  result = prime * result + eng;
	  result = prime * result + kor;
	  result = prime * result + math;
	  result = prime * result + ((name == null) ? 0 : name.hashCode());
	  return result;
  }

	@Override
  public boolean equals(Object obj) {
	  if (this == obj)
		  return true;
	  if (obj == null)
		  return false;
	  if (getClass() != obj.getClass())
		  return false;
	  Student4 other = (Student4) obj;
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





















