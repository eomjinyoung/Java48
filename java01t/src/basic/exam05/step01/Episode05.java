package basic.exam05.step01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* ObjectInputStream / ObjectOutputStream
 * - 인스턴스의 데이터를 바이트 배열로 변환하여 출력
 * - 바이트 배열을 인스턴스 변수에 저장 
 */

class Student implements Serializable {
	// 바이트 배열로 출력할 때 현재 클래스의 버전을 기록한다.
	// => 읽는 쪽에서 버전에 맞추어 읽을 수 있다.
  private static final long serialVersionUID = 1L;

  String name;
	int kor;
	int eng;
	int math;
	int sum;
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = kor + eng + math;
	}
	
	@Override
	public String toString() {
	  return name + "," + kor + "," + eng + "," + math + "," + sum;
	}
}

public class Episode05 {

	public static void main(String[] args) throws Exception {
		// ObjectInputStream을 사용하여 읽기
		FileInputStream in = new FileInputStream("student5.dat");
		ObjectInputStream in2 = new ObjectInputStream(in);
		
		// 바이트 배열 -> 인스턴스 생성 및 값 할당 : deserialize
		Student s1 = (Student)in2.readObject();
		Student s2 = (Student)in2.readObject();
		Student s3 = (Student)in2.readObject();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		in2.close();
		in.close();
	}
	
	
	public static void main01(String[] args) throws Exception {
		// ObjectOutputStream
		// - 인스턴스의 클래스 정보와 데이터가 함께 출력된다.
		// - Serialize가 허용된 인스턴스의 경우 출력 가능.
		//    => 허용되지 않은 인스턴스를 출력하려 한다면
		//    => NotSerializableException 발생 
		// - 해결 방법: 클래스에 Serialize를 허용한다고 선언할 것.
		//   문법: class 클래스명 implements Serializable {...}
		FileOutputStream out = new FileOutputStream("student5.dat");
		ObjectOutputStream out2 = new ObjectOutputStream(out);
		
		Student s1 = new Student("홍길동", 90, 90, 100);
		Student s2 = new Student("임꺽정", 100, 100, 100);
		Student s3 = new Student("전봉준", 80, 80, 80);

		// Serialize
		out2.writeObject(s1); // 인스턴스 데이터를 바이트 배열로 변환한다.
		out2.writeObject(s2);
		out2.writeObject(s3);
		
		out2.close();
		out.close();
	}

}









