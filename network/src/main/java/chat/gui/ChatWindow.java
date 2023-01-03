package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.SocketException;

import chat.ChatServer;

public class ChatWindow {
	private PrintWriter pw = null;
	private BufferedReader br;
	private Socket socket;
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name, Socket socket) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.socket = socket;
	}

	public void show() {
		try {
			// Button
			buttonSend.setBackground(Color.GRAY);
			buttonSend.setForeground(Color.WHITE);
			// 옵저버 패턴: 객체(나 함수)의 상태를 감시하는 listener
			buttonSend.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sendMessage();
				}
			});
//		buttonSend.addActionListener((ActionEvent e) ->{
//		buttonSend.addActionListener((e) ->{
//		});

			// Textfield
			textField.setColumns(80);
			// enter
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					char keyCode = e.getKeyChar();
					if (keyCode == KeyEvent.VK_ENTER) {
						sendMessage();
					}
				}

			});

			// Pannel
			pannel.setBackground(Color.LIGHT_GRAY);
			pannel.add(textField);
			pannel.add(buttonSend);
			frame.add(BorderLayout.SOUTH, pannel);

			// TextArea
			textArea.setEditable(false); // readonly
			frame.add(BorderLayout.CENTER, textArea);

			// Frame
			frame.addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent e) {
					finish();
				}

			});
			frame.setVisible(true);
			frame.pack();
			// IOStream 받아오기
			br = new BufferedReader(new InputStreamReader(this.socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream(), "utf-8"), true);
			// ChatClientThread 생성하고 실행
			new ChatClientThread().start();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void finish() {
		try {
			// quit protocol 구현
			pw.println("quit");
			// clean-up
			// 소켓종료 등등
			if (socket != null & !socket.isClosed()) {
				socket.close();
			}
			// exit java(Application)
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendMessage() {
		String message = textField.getText();
		//quit인 경우
		if (message.equals("quit")) {
			pw.println("quit");
			finish();
		}
		//메세지 보내기
		pw.println("message:" + message);

		textField.setText("");
		// 포커스 주기
		textField.requestFocus();
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n"); // 개행
	}

	private class ChatClientThread extends Thread {

		@Override
		public void run() {
			try {
				// textarea 참조 inner클래스는 outer클래스에 접근 가능
				while (true) {
					String message = br.readLine();
					if (message == null) {
						System.out.println("closed");
						break;
					}
					updateTextArea(message);
				}
			} catch (SocketException e) {
				finish();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
