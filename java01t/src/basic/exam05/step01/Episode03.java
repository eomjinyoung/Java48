package basic.exam05.step01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* Data Processing Stream Class
 * - 중간에서 다른 스트림 객체에게 데이터를 가공하여 전달.
 *   다른 스트림 객체로부터 읽어들인 데이터를 가공하여 리턴.
 * - 직접 파일, 메모리 등으로 입/출력 불가능.
 * 
 * 예) DataInputStream, DataOutputStream
 * - byte, short, int 등의 데이터를 좀 더 쉽게 입/출력할 수 있는 기능 제공
 * 
 */
public class Episode03 {

	public static void main(String[] args) throws Exception {
		// 데이터 읽기
		FileInputStream in = new FileInputStream("student3.dat");
		DataInputStream in2 = new DataInputStream(in);
		
		String name = in2.readUTF();
		int kor = in2.readInt();
		int eng = in2.readInt();
		int math = in2.readInt();
		int sum = in2.readInt();
		
		System.out.println(name);
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(math);
		System.out.println(sum);
		
		in2.close();
		in.close();
	}
	
	
	public static void main01(String[] args) throws Exception {
		// 데이터 출력 
		FileOutputStream out = new FileOutputStream("student3.dat");
		DataOutputStream out2 = new DataOutputStream(out);
		
		String name = "홍길동";
		int kor = 90, eng = 100, math = 80, sum = 270;

		out2.writeUTF(name); 	
		out2.writeInt(kor);			
		out2.writeInt(eng);			
		out2.writeInt(math);	
		out2.writeInt(sum);		
		
		out2.close();
		out.close();
	}

}









