package chat.up1;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings("serial")
public class ChatServer extends Frame implements ActionListener {
	TextArea msgPane = new TextArea();
	TextField inputMessage = new TextField();
	
	ServerSocket serverSocket;
	Socket socket;
	PrintStream out;
	BufferedReader in;
	
	String friendName;
	
	public ChatServer() {
		super("채팅 서버");
		
		this.add(msgPane, BorderLayout.CENTER);
		this.add(inputMessage, BorderLayout.SOUTH);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {in.close();} catch(Exception ex) {}
				try {out.close();} catch(Exception ex) {}
				try {socket.close();} catch(Exception ex) {}
				try {serverSocket.close();} catch(Exception ex) {}
				
			  System.exit(0);
			}
		});
		
		inputMessage.addActionListener(this);
	}
	
	private void service() throws Exception {
		try {
			serverSocket = new ServerSocket(7777);
			socket = serverSocket.accept();
			
			in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
			out = new PrintStream(socket.getOutputStream());
			
			String message = null;
			do {
				message = in.readLine();
				if (message.startsWith("hello")) {
					processHello(message);
					
				} else if (message.startsWith("goodbye")) {
					out.println("ok");
					msgPane.append("[" + friendName + "]님이 나갔습니다.");
					break;
					
				} else {
					processMessage(message);
				}
			} while (true);
			
		} catch (Exception e) {
			msgPane.append( e.getMessage() );
		}
	}
	
	private void processHello(String message) {
		friendName = message.split(" ")[1];
	  msgPane.append("[" + friendName + "]님이 입장하셨습니다.\n");
	  out.println("hello Bernard");
  }
	
	private void processMessage(String message) {
	  msgPane.append("[" + friendName + "] " + message + "\n");
  }
	
	public void actionPerformed(ActionEvent e) {
	  msgPane.append("[me] " + inputMessage.getText() + "\n");
	  out.println(inputMessage.getText());
	  inputMessage.setText("");
	}
	
	public static void main(String[] args) throws Exception {
		ChatServer chatServer = new ChatServer();
		chatServer.setSize(400, 300);
		chatServer.setVisible(true);
		
		chatServer.service();
	}

}























