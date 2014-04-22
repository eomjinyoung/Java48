package http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyWebServer {
	public static void main(String[] args) throws Exception {
		// 클라이언트의 요청을 받는 역할 수행.
	  ServerSocket serverSocket = new ServerSocket(9898);
	  
	  // 대기열에서 하나를 꺼내고, 데이터를 주고 받을 수 있는 도구를 리턴한다.
	  Socket socket = serverSocket.accept();
	  
	  InputStream in = socket.getInputStream();
	  InputStreamReader in2 = new InputStreamReader(in);
	  BufferedReader in3 = new BufferedReader(in2);
	  
	  OutputStream out = socket.getOutputStream();
	  PrintStream out2 = new PrintStream(out);
	  
	  // 요청 헤더 정보 출력
	  String line = null;
	  do {
	  	line = in3.readLine();
	  	System.out.println(line);
	  } while (line.length() != 0);
	  
	  // 메시지 바디 출력 
	  int count = 0;
	  for (int i = 0; i < 5395; i++) {
	  	System.out.print((char)in3.read());
	  	//System.out.println(++count);
	  }
	  
	  out2.println("HTTP/1.1 200 OK");
	  out2.println("Server: Apache-Coyote/1.1");
	  out2.println("Content-Type: text/html;charset=UTF-8");
	  out2.println("Content-Length: 5");
	  out2.println();
	  out2.println("Hello");
	  
	  out2.close();
	  in3.close();
	  in2.close();
	  socket.close();
	  serverSocket.close();
  }
}














