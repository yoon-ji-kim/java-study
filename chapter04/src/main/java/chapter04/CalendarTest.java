package chapter04;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); //추상이라서 getInstance
		cal.set(Calendar.YEAR, 2021);
		cal.set(Calendar.YEAR, 11); //12월(Month-1)
		cal.set(Calendar.YEAR, 25);
//		cal.set(2021, 3, 13);
		cal.set(2018, 7, 26);
		cal.set(Calendar.DATE, 1000);
		printDate(cal);
//		System.out.println(cal);
	}

	private static void printDate(Calendar cal) {
		final String[] days = {"일","월","화","수","목","금","토"};
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(year + "년 " + (month+1)+ "월 " 
				+days[day] + "요일 " + hour+ "시 " + minute+"분 "+ second+"초");
	}

}
