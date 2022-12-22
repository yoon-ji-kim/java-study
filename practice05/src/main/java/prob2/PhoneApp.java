package prob2;

public class PhoneApp {

	public static void main(String[] args) {
		//MusicPhone을 상속한 SmartPhone Class
		//super. 해보는거
//		부분 재구현
//		음악 들어오면 음악재생
//		다른건 super()
		
		//smart폰은 앱만
		Phone phone = new SmartPhone();

		phone.execute("음악");
		phone.execute("통화");
		phone.execute("앱");
	}
}