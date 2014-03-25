package basic.exam04.step06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Episode01 {
	public static void main(String[] args) {
		// HashMap의 키를 MyKey로 교체
		// - hashCode()와 equals() 재정의
		class MyKey {
			int keyNo;
			
			public MyKey(int keyNo) {
				this.keyNo = keyNo;
			}

			@Override
      public int hashCode() {
	      final int prime = 31;
	      int result = 1;
	      result = prime * result + keyNo;
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
	      MyKey other = (MyKey) obj;
	      if (keyNo != other.keyNo)
		      return false;
	      return true;
      }
		}
		
		MyKey k1 = new MyKey(100);
		
		HashMap<MyKey,String> map = new HashMap<MyKey,String>();
		map.put(k1, "홍길동");
		
		MyKey k2 = new MyKey(100);
		
		if (k1 == k2) System.out.println("인스턴스 같다......");
		if (k1.equals(k2)) System.out.println("equals..ok");
		if (k1.hashCode() == k2.hashCode()) System.out.println("hash...ok");
		
		// 비록 내용은 같지만 hashCode()와 equals()를 재정의하지 않았다.
		System.out.println( map.get(k2) ); // null 리턴 
	}
	
	public static void main07(String[] args) {
		// HashMap의 키를 MyKey로 교체
		class MyKey {
			int keyNo;
			
			public MyKey(int keyNo) {
				this.keyNo = keyNo;
			}
		}
		
		MyKey k1 = new MyKey(100);
		
		HashMap<MyKey,String> map = new HashMap<MyKey,String>();
		map.put(k1, "홍길동");
		
		MyKey k2 = new MyKey(100);
		
		if (k1 == k2) System.out.println("인스턴스 같다......");
		if (k1.equals(k2)) System.out.println("equals..ok");
		if (k1.hashCode() == k2.hashCode()) System.out.println("hash...ok");
		
		// 비록 내용은 같지만 hashCode()와 equals()를 재정의하지 않았다.
		System.out.println( map.get(k2) ); // null 리턴 
	}
	
	public static void main06(String[] args) {
		// HashMap의 키를 Integer로 교체
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		map.put(new Integer(100), "홍길동");
		map.put(200, "임꺽정");
		map.put(300, "장국영");
		map.put(400, "홍길동");
		
		map.put(400, "오호라"); // 기존의 값을 덮어씀.
		
		// Integer 인스턴스 비교 테스트
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		if (i1 == i2) System.out.println("같다......");
		if (i1.equals(i2)) System.out.println("equals..ok");
		if (i1.hashCode() == i2.hashCode()) System.out.println("hash...ok");
				
		System.out.println( map.get(new Integer(100)) );
		System.out.println( map.get(200) );
		System.out.println( map.get(300) );
		System.out.println( map.get(new Integer(400)) );
		
		// 값 목록만 꺼낼 수 있다.
		System.out.println("--------------------------");
		for (String name : map.values()) {
			System.out.println(name);
		}
		
		// 키 목록만 꺼낼 수 있다.
		System.out.println("--------------------------");
		for (Integer key : map.keySet()) {
			System.out.println(key);
		}
		
	}
	
	public static void main05(String[] args) {
		// HashMap 사용
		// - 데이터를 저장할 때 키 객체가 필요함.
		// - 데이터를 꺼낼 때도 키 객체가 필요함.
		// - 값이 중복 저장되는 것은 허용.
		// - 키가 중복되는 것은 허용하지 않는다.
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("100", "홍길동");
		map.put("200", "임꺽정");
		map.put("300", "장국영");
		map.put("400", "홍길동");
		
		map.put("400", "오호라"); // 기존의 값을 덮어씀.
		
		System.out.println( map.get("100") );
		System.out.println( map.get("200") );
		System.out.println( map.get("300") );
		System.out.println( map.get("400") );
		
		// 값 목록만 꺼낼 수 있다.
		System.out.println("--------------------------");
		for (String name : map.values()) {
			System.out.println(name);
		}
		
		// 키 목록만 꺼낼 수 있다.
		System.out.println("--------------------------");
		for (String key : map.keySet()) {
			System.out.println(key);
		}
		
	}
	
	public static void main04(String[] args) {
		// HashSet의 사용3
		// - hashCode() 와 equals()를 재정의 했을 때
		// Local inner class
		class Student {
			String name;
			int age;
			
			public Student(String n, int agHashe) {
				// 로컬변수 이름과 충돌나지 않는다면 this 생략가능.
				/*this.*/name = n;
				this.age = age; // 파라미터 이름과 동일 => this 생략 불가능.
			}
			
			public String toString() {
				return name + "," + age;
			}

			@Override
      public int hashCode() {
	      final int prime = 31;
	      int result = 1;
	      result = prime * result + age;
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
	      Student other = (Student) obj;
	      if (age != other.age)
		      return false;
	      if (name == null) {
		      if (other.name != null)
			      return false;
	      } else if (!name.equals(other.name))
		      return false;
	      return true;
      }
			
			
		}
		
		Student s1 = new Student("홍길동", 18);
		Student s2 = new Student("임꺽정", 20);
		Student s3 = new Student("장국영", 30);
		Student s4 = new Student("홍길동", 18);
		
		if (s1 == s4) System.out.println("s1 == s2");
		if (s1.equals(s4)) System.out.println("s1.equals(s4)");
		if (s1.hashCode() == s4.hashCode()) System.out.println("해시값 같다");
		
		HashSet<Student> list = new HashSet<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		
		for(Student name : list) {
			System.out.println(name);
		}

	}
	
	public static void main03(String[] args) {
		// Local inner class
		class Student {
			String name;
			int age;
			
			public Student(String n, int age) {
				// 로컬변수 이름과 충돌나지 않는다면 this 생략가능.
				/*this.*/name = n;
				this.age = age; // 파라미터 이름과 동일 => this 생략 불가능.
			}
			
			public String toString() {
				return name + "," + age;
			}
		}
		// HashSet의 사용2
		// - 임의로 만든 클래스 저장
		HashSet<Student> list = new HashSet<Student>();
		list.add(new Student("홍길동", 18));
		list.add(new Student("임꺽정", 20));
		list.add(new Student("장국영", 30));
		list.add(new Student("홍길동", 18));
		
		for(Student name : list) {
			System.out.println(name);
		}

	}
	
	public static void main02(String[] args) {
		// HashSet의 사용
		// - 데이터가 중복되지 않는다.
		//   => 인스턴스가 달라도 해시값과 equals() 결과가 같다면 같은 데이터로 취급
		//	 => 중복하여 저장되지 않는다.
		// - 꺼낼 때 순서를 따지지 않는다.
		// - 값을 보관할 때 인스턴스의 해시값으로 라벨을 붙인다.
		HashSet<String> list = new HashSet<String>();
		list.add(new String("홍길동"));
		list.add(new String("임꺽정"));
		list.add(new String("장국영"));
		list.add(new String("홍길동"));
		
		for(String name : list) {
			System.out.println(name);
		}

	}
	
	public static void main01(String[] args) {
		// ArrayList의 사용
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("임꺽정");
		list.add("장국영");
		list.add("홍길동");
		
		for(String name : list) {
			System.out.println(name);
		}

	}

}
