package chat.gui;
import java.util.Scanner;

public class ChatClientApp {

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (name.isEmpty() == false ) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();
		//1. create socket
		//2. connect to server
		//3. get iostream
		//4. join protocol 진행
//		String line = br.readLine(); //요청에 대한 응답받아서 ex)JOIN:OK 
		String line = "JOIN:OK"; //요청에 대한 응답받아서 ex)JOIN:OK 
		if("JOIN:OK".equals(line)) {
			new ChatWindow(name).show();
			return;
		}
		//OK 아닐경우 종료 또는 다시 실행하기
	}

}
