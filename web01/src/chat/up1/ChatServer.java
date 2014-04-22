package chat.up1;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatServer extends Frame implements ActionListener {
	TextArea msgPane = new TextArea();
	TextField inputMessage = new TextField();
	
	public ChatServer() {
		super("채팅 서버");
		
		this.add(msgPane, BorderLayout.CENTER);
		this.add(inputMessage, BorderLayout.SOUTH);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			  System.exit(0);
			}
		});
		
		inputMessage.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
	  msgPane.append("[me] " + inputMessage.getText() + "\n");
	  inputMessage.setText("");
	}
	
	public static void main(String[] args) {
		ChatServer chatServer = new ChatServer();
		chatServer.setSize(400, 300);
		chatServer.setVisible(true);
	}

}























