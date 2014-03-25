package basic.exam05.step01;

import java.io.FileInputStream;
import java.io.FileReader;

/* binary 스트림과 character 스트림의 비교
 * 1) binary 스트림 클래스
 * - 바이트단위로 데이터를 읽고 쓴다.
 * - InputStream, OutputStream의 자손 클래스들이다.
 * - 클래스 이름 뒤에 InputStream/OutputStream이 붙는다.
 * 
 * 2) character 스트림 클래스
 * - 문자 단위(Unicode 2byte)로 데이터를 읽고 쓴다.
 * - Reader/Writer의 자손 클래스들이다.
 * - 클래스 이름 뒤에 Reader/Writer가 붙는다.
 * - 쓰기 => Unicode를 운영체제의 기본 인코딩으로 변환하여 출력한다.
 * - 읽기 => 읽은 데이터를 유니코드로 변환하여 리턴한다. 
 * 
 */
public class Episode04 {

	public static void main(String[] args) throws Exception {
		// 텍스트 데이터 읽기를 통한 동작 비교 
		// 문자 스트림으로 읽기
		// 읽어들인 데이터는 유니코드로 변환한다.
		// - 영어는 1바이트 읽어서 2바이트 유니코드로 변환
		// - 한글(UTF-8)은 3바이트 읽어서 2바이트 유니코드로 변환
		// 변환한 유니코드를 리턴한다.
		FileReader in = new FileReader("student4.dat");
		
		int i = 0;
		while ( (i = in.read()) != -1) {
			System.out.println(Integer.toHexString(i));
		}
		in.close();
	}
	
	public static void main01(String[] args) throws Exception {
		// 텍스트 데이터 읽기를 통한 동작 비교 
		// 바이너리 스트림으로 읽기
		// 읽어들인 데이터는 가공하지 않는다. 원래의 바이트 그대로 리턴.
		FileInputStream in = new FileInputStream("student4.dat");
		
		int i = 0;
		while ( (i = in.read()) != -1) {
			System.out.println(Integer.toHexString(i));
		}
		in.close();
	}

}
























