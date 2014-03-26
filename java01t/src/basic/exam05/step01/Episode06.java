package basic.exam05.step01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/* BufferedInputStream/BufferedOutputStream
 * - 파일을 읽을 때 1 바이트씩 읽는 것 보다 왕창 읽는 것이 더 빠르다.
 * - 파일 읽기 시간 = data seek time + data transfer time
 *   => data seek time: HDD 헤더를 움직여 데이터가 있는 트랙으로 이동한 후
 *                          트랙이 돌 때 섹터를 찾는 것 까지의 시간.
 *   예) 1byte 읽는데 걸리는 시간 = data seek time(예: 0.0085초)
 *   																+ data transfer time(예: 0.000000003초)
 */
public class Episode06 {

	public static void main(String[] args) throws Exception {
		// BufferedInputStream의 사용 + buf 사용
		FileInputStream in = new FileInputStream("/home/bit/a.gz");
		BufferedInputStream in2 = new BufferedInputStream(in);
		
		byte[] buf = new byte[1024];
		int len = 0; // 읽어들인 바이트 수
		int count = 0;
		long startTime = System.currentTimeMillis();
		while((len = in2.read(buf)) != -1) {
			if ((++count % 1000) == 0) {
				System.out.print(".");
				count = 0;
			}
		}
		long duration = System.currentTimeMillis() - startTime;
		System.out.println("경과된 시간(밀리초) = " + duration);
		
		in2.close();
		in.close();
	}
	
	public static void main03(String[] args) throws Exception {
		// BufferedInputStream의 사용
		FileInputStream in = new FileInputStream("/home/bit/a.gz");
		BufferedInputStream in2 = new BufferedInputStream(in);
		
		int b;
		int count = 0;
		long startTime = System.currentTimeMillis();
		while((b = in2.read()) != -1) {
			if ((++count % 1000000) == 0) {
				System.out.print(".");
				count = 0;
			}
		}
		long duration = System.currentTimeMillis() - startTime;
		System.out.println("경과된 시간(밀리초) = " + duration);
		
		in2.close();
		in.close();
	}
	
	public static void main02(String[] args) throws Exception {
		// 8192바이트씩 데이터 읽기
		FileInputStream in = new FileInputStream("/home/bit/a.gz");
		
		byte[] buf = new byte[8192]; // 보통 버퍼의 크기를 1024 ~ 8192 정도로 설정.
		int len = 0;
		int count = 0;
		long startTime = System.currentTimeMillis();
		while((len = in.read(buf)) != -1) {
			if ((++count % 100) == 0) {
				System.out.print(".");
				count = 0;
			}
		}
		long duration = System.currentTimeMillis() - startTime;
		System.out.println("경과된 시간(밀리초) = " + duration);
		
		
		in.close();
	}
	
	
	public static void main01(String[] args) throws Exception {
		// 1바이트씩 데이터 읽기
		FileInputStream in = new FileInputStream("/home/bit/a.gz");
		
		int b;
		int count = 0;
		long startTime = System.currentTimeMillis();
		while((b = in.read()) != -1) {
			if ((++count % 1000000) == 0) {
				System.out.print(".");
				count = 0;
			}
		}
		long duration = System.currentTimeMillis() - startTime;
		System.out.println("경과된 시간(밀리초) = " + duration);
		
		
		in.close();
	}

}









