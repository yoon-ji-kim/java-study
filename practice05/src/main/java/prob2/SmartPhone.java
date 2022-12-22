package prob2;

public class SmartPhone extends MusicPhone {

	@Override
	public void execute(String function) {
		if(function.equals("앱")) {
			playapp();
			return;
		}
		super.execute(function);
	}

	private void playapp() {
		System.out.println("앱실행");
	}
	
}
