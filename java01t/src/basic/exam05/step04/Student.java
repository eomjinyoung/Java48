package basic.exam05.step04;

public class Student {
	String 		name;
	int 				age;
	String 		tel;
	String 		email;
	String 		address;
	
	public static Student fromCSV(String value) {
		String[] data = value.split(",");
		
		Student obj = new Student();
		obj.name = data[0];
		obj.age = Integer.parseInt(data[1]);
		obj.tel = data[2];
		obj.email = data[3];
		obj.address = data[4];
		
		
		return obj;
	}

	@Override
  public String toString() {
	  return name + "," + age + "," + tel + "," + 
	  				email + "," + address;
  }
	
	
}



















