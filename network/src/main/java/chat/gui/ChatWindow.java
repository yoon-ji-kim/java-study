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

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		// Button   
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		//옵저버 패턴: 객체(나 함수)의 상태를 감시하는 listener 
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("!!버튼 클릭!!");
				sendMessage();
			}
			//컴파일러가 생성해야할 메소드가 1개뿐인 인터페이스 1개라는 것을 알고 있음
		});
//		buttonSend.addActionListener((ActionEvent e) ->{
//		buttonSend.addActionListener((e) ->{
//			//이벤트를 넣어서 블록을 실행할게!
//		});

		// Textfield
		textField.setColumns(80);
		//enter
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
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
		textArea.setEditable(false); //readonly
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
		
		//IOStream 받아오기
		//ChatClientThread 생성하고 실행
	}
	private void finish() {
		//quit protocol 구현
		
		//clean-up
			//소켓종료 등등
		
		//exit java(Application)
		System.exit(0);
	}
	private void sendMessage() {
		String message = textField.getText();
		System.out.println("메세지 보내는 프로토콜 구현하기: "+ message);
		
		textField.setText("");
		//포커스 주기
		textField.requestFocus();
		
		// ChatClientThread에서 서버로 부터 받은 메세지가 있다 생각하고 update 구현한 코드
		updateTextArea("마이콜: "+message);
	}
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");   		//개행
	}
	private class ChatClientThread extends Thread {

		@Override
		public void run() {
			//textarea 참조 inner클래스는 outer클래스에 접근 가능
//			String message = br.readLine();
//			updateTextArea(message); 
			updateTextArea("안녕"); 
		}
		
	}
}
