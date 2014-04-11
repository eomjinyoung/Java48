package basic.exam06.jdbc.up7;

class Patient02 {
	// 인스턴스 변수, 클래스 변수 = Field(필드) = Attribute(속성)
	private String 		name;
	private int 			age;
	private int 			weight;
	private int 			height;
	private String 		bloodType;
	
	// setter/getter = Property(프로퍼티)
	// if (셋터만 있다) = write only 프로퍼티
	// if (겟터만 있다) = read only 프로퍼티
	
	// 프로퍼티 이름 => set/get을 빼고 난 다음의 이름에서 첫 알파벳을 소문자로 한 것.
	// 예) setCreatedDate()/getCreatedDate() => createdDate
	
	// 필드의 값을 설정하는 메서드: setter
	public void setName(String name) {
		this.name = name;
	}
	
	// 필드의 값을 꺼내는 메서드: getter
	public String getName() {
		return this.name;
	}
	
	public void setAge(int age) {
		// setter를 사용하면 중간에서 유효 값을 필더링 할 수 있다.
		// 나중에 필터링의 기준이 바뀌더라도 이 메서드만 변경하면 된다.
		if (age > 0 && age < 120) {
			this.age = age;
		} else {
			this.age = 30;
		}
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setWeight(int weight) {
		if (weight > 0 && weight < 300) {
			this.weight = weight;
		} else {
			this.weight = 100;
		}
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public void setHeight(int height) {
		if (height > 0 && height < 300) {
			this.height = height;
		} else {
			this.height = 180;
		}
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	
	public String getBloodType() {
		return this.bloodType;
	}

	@Override
  public String toString() {
	  return "Patient02 [name=" + name + 
	  		", age=" + age + 
	  		", weight=" + weight
	      + ", height=" + height + 
	      ", bloodType=" + bloodType + "]";
  }
}

public class Episode02 {
	public static void main(String[] args) {
		Patient02 p1 = new Patient02();
		p1.setName("홍길동");
		p1.setAge(-200);
		p1.setWeight(-90); 
		p1.setHeight(280);
		p1.setBloodType("O");
		
		System.out.println(p1);

	}

}

















