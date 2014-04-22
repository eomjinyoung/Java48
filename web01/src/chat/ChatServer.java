package chat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
	static PrintStream out2;
	static String friendName; 
	static Scanner scanner;

	public static void main(String[] args) throws Exception {
		scanner = new Scanner(System.in);
		
		ServerSocket serverSocket = new ServerSocket(7777);
		
		Socket socket = serverSocket.accept();
		
		// 클라이언트가 보낸 데이터를 읽는다.
		InputStream in = socket.getInputStream();
		// 바이트 => 유니코드
		InputStreamReader in2 = new InputStreamReader(in);
		// 라인으로 만들어서 리턴한다.
		BufferedReader in3 = new BufferedReader(in2);
		
		// 클라이언트로 바이트를 출력
		OutputStream out = socket.getOutputStream();
		// 문자열 => 바이트 배열 
		out2 = new PrintStream(out);
		
		String line = null;
		do {
			line = in3.readLine();
			if (line.startsWith("hello")) {
				processHello(line);
				
			} else if (line.startsWith("goodbye")) {
				out2.println("ok");
				break;
				
			} else {
				processMessage(line);
			}
		} while (true);
		
		in3.close();
		in2.close();
		in.close();
		out2.close();
		out.close();
		socket.close();
		serverSocket.close();
	}

	private static void processMessage(String message) {
	  System.out.println("[" + friendName + "] " + message);
	  
	  System.out.print("입력>");
	  String input = scanner.nextLine();
	  out2.println(input);
  }

	private static void processHello(String line) {
		String[] values = line.split(" ");
	  friendName = values[1];
	  System.out.println(friendName + "님이 입장하셨습니다.");
	  
	  out2.println("hello Bernard");
  }

}


















