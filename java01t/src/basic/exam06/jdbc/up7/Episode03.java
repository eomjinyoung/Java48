package basic.exam06.jdbc.up7;

class Patient03 {
	private String 		name;
	private int 			age;
	private int 			weight;
	private int 			height;
	private String 		bloodType;
	
	public Patient03 setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Patient03 setAge(int age) {
		if (age > 0 && age < 120) {
			this.age = age;
		} else {
			this.age = 30;
		}
		return this;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public Patient03 setWeight(int weight) {
		if (weight > 0 && weight < 300) {
			this.weight = weight;
		} else {
			this.weight = 100;
		}
		return this;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public Patient03 setHeight(int height) {
		if (height > 0 && height < 300) {
			this.height = height;
		} else {
			this.height = 180;
		}
		return this;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public Patient03 setBloodType(String bloodType) {
		this.bloodType = bloodType;
		return this;
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

public class Episode03 {
	public static void main(String[] args) {
		System.out.println(new Patient03()
			.setName("홍길동")
			.setAge(-200)
			.setWeight(-90)
			.setHeight(280)
			.setBloodType("O"));

	}

}

















