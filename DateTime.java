package OverloadingandDateTime;

import java.util.Calendar;
import java.util.Date;

public class DateTime {
	
	private static Calendar birthday;
	

	public static void main(String[] args) {
		
		//[DateTime]
		/*
		 자바 자료형
		 - 숫자형, 논리형, 문자형
		 - 문자열, 날짜시간형
		
		 
		 DateTime, 날짜시간 자료형
		 1. Date 클래스(legacy)
		 2. Calendar 클래스 ***
		 3. 추가 클래스
		  
		 1. 시간
		 2. 시각
		 
		 2021년 9월 16일 오전 10시 7분 -> 시간 vs 시각 => 시각
		 
		 8시간 수업 -> 시간 vs 시각 => 시간
		 
		 둘다 성질이 전혀 다른 데이터이다. 공통점이 전혀 없다.
		 
		 시간, 시각 -> 연산
		 
		 시각 + 시각 = (X), 2021년 9월 16일 + 2022년 5월 3일 = ?
		 시각 - 시각 = 시간(O), 2022년 5월 3일  - 2021년 9월 16일 = epoch, tick
		 시간 + 시간 = 시간(O), 8시간 + 2시간 = 10시간
		 시간 - 시간 = 시간(O), 8시간 - 2시간 = 10시간 
		 시각 + 시간 = 시각(O), 2021년 9월 16일 + 100일 = ~
		 시각 - 시간 = 시각(O), 2021년 9월 16일 - 100일 = ~
		 
		 //개인적 의견 : 시간은 구간, 시각은 점 이라고 생각하면 쉬울듯
		 
		 */
		//m1();    // 1번예제
		//m2();    // 2번 예제 
		//m3();    // 3번 예제
		//m4();	   // 4번 예제
		//m5();	   //5번 예제
		//m6();
		//m7();
		
		
	}//main

	private static void m7() {
		
		//현재 시각의 tick?
		
		Calendar now = Calendar.getInstance();
		System.out.println(now.getTimeInMillis());
		
		//현재 시각의 tick값을 반환하는 전용 메소드
		System.out.println(System.currentTimeMillis());
		
		
	}

	private static void m6() {
		
		//연산
		//시각 + 시간 > add()
		//시각 - 시간 > add()
		//시각 - 시각 > tick - tick
		//시간 + 시간 > 산술연산
		//시간 - 시간 > 산술연산
		
		
		//1.  2시간 30분 + 10분 = 2시간 40분
		int hour = 2;
		int min = 30;
		
		min +=10;
		
		System.out.printf("%d시간 %d분\n", hour, min);
		
		//2.  2시간 30분 + 40분 = 3시간 10분
		hour = 2;
		min = 30;
		
		min = min + 40; // 2시간 70분
		hour = hour + (min /60); //3시간, 약간 단위 환산 느낌임, 몫 > 자리올림
		min = min % 60; //10분 > 나머지 > 분
		System.out.printf("%d시간 %d분\n", hour, min);
		
	}
	

	private static void m5() {

		//연산
		//- 시각 - 시각 = 시간
		
		Calendar now = Calendar.getInstance();
		Calendar bithday = Calendar.getInstance();
//		birthday.set(1995, 4, 10, 13, 30, 25);
		
		//now - birthday = 내가 살아온 시간
		//now - birthday; //복합 데이터는 -의 피연산자로 사용 불가능
		
		//산술 연산자는 반드시 피연산자가 숫자형만 올 수 있다.
		
		//tick값
//		System.out.println(birthday.getTimeInMillis()); //800080225799ms 
		
//		long birthdayTick = birthday.getTimeInMillis();
		long nowTick = now.getTimeInMillis();
		
//		System.out.println((nowTick - birthdayTick) / 1000 / 60 /60 /24);
		
		//올해 크리스마스가 며칠 남았는지?
		//크리스마스 - 현재
		Calendar christmas = Calendar.getInstance();
		christmas.set(2021, 11, 25);
		long christmasTick = christmas.getTimeInMillis();
		
		System.out.println((christmasTick - nowTick) /1000 / 60 / 60 /24);
		
		
		now.set(2021, 8, 8);
		nowTick = now.getTimeInMillis();
		
		Calendar endDate = Calendar.getInstance();
		endDate.set(2022, 1, 24);
		long endDateTick = endDate.getTimeInMillis();
		
		System.out.println((endDateTick - nowTick) /1000/ 60/ 60/24);
		
	}
	

	private static void m4() {
		
		int n = 10;
		
		System.out.println(n + 1); //11
		System.out.println(n); // 10
		
		n++;
		System.out.println(n); //11  즉, 자기자신을 건들이는 연산!!
		
		
		//연산
		//-1. 시각 + 시간
		//- 시각 - 시간
		//- void add(int, int) : add라는 메서드는 원본을 건들여서 수정하는 메서드임
		
		
		//1.
		//오늘 만난 커플 > 100일 
		Calendar now = Calendar.getInstance();
		System.out.printf("1일차: %tF\n", now);
		
		//수정하기
		now.add(Calendar.DATE, 100);  //now에다가 날짜를 100 더해라
		System.out.printf("100일차 : %tF\n", now);
		
		//다시 오늘로 초기화
		now.set(2021, 8, 16);
		System.out.printf("오늘: %tF\n", now);
		
		//오늘 태어난 아기 -> 첫돌
		now.add(Calendar.YEAR, 1);
		System.out.printf("첫돌: %tF\n", now);
		
		//다시 오늘로 초기화
		now.set(2021, 8, 16);
		System.out.printf("오늘: %tF\n", now);
	
		//5시간 25분 뒤 비타민 복용
		now.add(Calendar.HOUR, 5);
		now.add(Calendar.MINUTE, 25);
		
		System.out.printf("비타민 먹을 시간: %tT\n", now);
		
		
		//2.
		//다시 오늘로 초기화
		now.set(2021, 8, 16);
		System.out.printf("오늘: %tF\n", now);
		
		//100개월 전
		now.set(Calendar.MONTH, -100);
		System.out.printf("100개월 전: %tF\n", now);
		
		//개강일로 초기화
		now.set(2021, 8, 8);
		now.add(Calendar.DATE, 112);
		System.out.printf("종강일: %tF\n", now);
		
	}

	private static void m3() {
		
		//특정 시각 얻어오기
		//1. 현재시각만들기 -> 2. 그 시각을 원하는 시가으로 수정하기
		
		//내 생일
		// - 1995년 10월 12일 0시 12분 25초  > Calendar 생성하기
		Calendar birthday = Calendar.getInstance();
		
		// ooo,get() : 얻어오기, 읽기 > 메소드
		// ooo,set() : 집어넣기, 쓰기 > 메소드
		
		//수정하기
		// - void set(int 상수, int 값)
		// - void set(int, int, int)
		// - void set(int, int, int, int, int, int)
		
		
		//birthday.set(1995, 9, 12);
		

		birthday.set(1995, 4, 10, 15, 30, 25);
		
		//birthday.set(1995, 4, 10);
//Q06에서 헷갈렸던 부분임 여러번 보기	
//		birthday.set(Calendar.YEAR, 1995);
//		birthday.set(Calendar.MONTH, 9);
//		birthday.set(Calendar.DATE, 12);
//		birthday.set(Calendar.HOUR, 0);
//		birthday.set(Calendar.MINUTE, 12);
//		birthday.set(Calendar.SECOND, 25);
//		
		
		System.out.printf("%tF %tT\n", birthday, birthday);
		
	}

	private static void m2() {
		
		//현재 시각 얻어오기 + 원하는 항목 추출하기 + 형식문자(%tF, %tT, %tA)

		//Calendar 클래스
		
		//현재 시각 얻어오기
		//java.utill.Calendar
		Calendar c1 = Calendar.getInstance(); // =현재 시각, 자바는 무조건 현재 시각부터 계산 시작
		
		//java.util.GregorianCalendar
		//[time=1631756441049,
		//areFieldsSet=true,
		//areAllFieldsSet=true,
		//lenient=true,
		//zone=sun.util.calendar.ZoneInfo
		//[id="Asia/Seoul",
		//offset=32400000,
		//dstSavings=0,
		//useDaylight=false,
		//transitions=30,lastRule=null],
		//firstDayOfWeek=1,
		//minimalDaysInFirstWeek=1,
		//ERA=1,
		//YEAR=2021,
		//MONTH=8,
		//WEEK_OF_YEAR=38,
		//WEEK_OF_MONTH=3,
		//DAY_OF_MONTH=16,
		//DAY_OF_YEAR=259,
		//DAY_OF_WEEK=5,
		//DAY_OF_WEEK_IN_MONTH=3,
		//AM_PM=0,
		//HOUR=10,
		//HOUR_OF_DAY=10,
		//MINUTE=40,
		//SECOND=41,
		//MILLISECOND=49,
		//ZONE_OFFSET=32400000,
		//DST_OFFSET=0]
		
		
		System.out.println(c1);
		
		//Calendar안에 들어있는 여러 데이터 중 원하는 항목만 가져오기
		// - int get(int)
		
		System.out.println();
		
		System.out.println(c1.get(1)); //년도
		System.out.println(c1.get(2)); // ?
		System.out.println(c1.get(3)); // ? 
		System.out.println(c1.get(4)); // ?
		System.out.println(c1.get(5)); // ?

		
		int year = 1;
		System.out.println(c1.get(1));		//가독성 낮음
		System.out.println(c1.get(year));	//가독성 높음

		//자바가 제공하는 Calendar 상수
		System.out.println(Calendar.YEAR);  // 도움말임, 이 년도라는 변수를 자바가 만들어 준 것임
		System.out.println(c1.get(Calendar.YEAR)); //** 실제로 사용하는 구문
		
		//c1
		System.out.println("---------------------------------");
		System.out.println(c1.get(Calendar.YEAR));				//2021. 년도
		System.out.println(c1.get(Calendar.MONTH));				//8	  . 월(0~11) : 8월인 이유
		System.out.println(c1.get(Calendar.DATE));				//16  . 날짜(일)
		System.out.println(c1.get(Calendar.HOUR));				//11  . 시(12H)
		System.out.println(c1.get(Calendar.MINUTE));			//12  . 분
		System.out.println(c1.get(Calendar.SECOND));			//8   . 초
		System.out.println(c1.get(Calendar.MILLISECOND));		//221 . 밀리초(1/1000)
		System.out.println(c1.get(Calendar.AM_PM));				//0   . 오전(0), 오후(1) 
		System.out.println(c1.get(Calendar.DAY_OF_YEAR));		//259 . 일(올해들어 오늘이 며칠째인지)
		System.out.println(c1.get(Calendar.DAY_OF_MONTH));		//16  . 일(이번달 들어서 오늘이 며칠째인지)
		System.out.println(c1.get(Calendar.DAY_OF_WEEK));		//5   . 일(요일) : 이번주 들어서 오늘이 며칠째인지, 일요일부터셈
		System.out.println(c1.get(Calendar.WEEK_OF_YEAR));		//38  . 주(차)  : 올해들어 이번주가 몇주차인지
		System.out.println(c1.get(Calendar.WEEK_OF_MONTH));		//3   . 주(째)  : 이번주가 이번달 들어 몇주째인지
		System.out.println(c1.get(Calendar.HOUR_OF_DAY));		//11  . 시간(째,24H): 오늘 들어 지금이 몇시간째인지
		
		
		//요구사항] 오늘은 '2021년 9월 16일 오전 11시 18분 30초'입니다. 를 출력하시오
		
		System.out.printf("오늘은 '%d년 %d월 %d일 %s %d시 %d분 %d초'입니다.\n",
				c1.get(Calendar.YEAR), 
				c1.get(Calendar.MONTH) + 1, 
				c1.get(Calendar.DATE), 
				c1.get(Calendar.AM_PM) == 0 ? "오전" : "오후" , 
				c1.get(Calendar.HOUR), 
				c1.get(Calendar.MINUTE),
				c1.get(Calendar.SECOND)
				);
		System.out.println();
		
		//printf() - 형식문자 > 날짜시간용
		System.out.printf("%tF\n", c1); //1. 년월일 2021-09-16
		System.out.printf("%d-%d-%d\n"
				, c1.get(Calendar.YEAR)
				, c1.get(Calendar.MONTH)
				, c1.get(Calendar.DATE));
		
		System.out.printf("%tT\n, c1"); //2. 시분초
		System.out.printf("tA\n", c1);  //3. 요일
		
	}

	private static void m1() {
		
		//Date 클래스 맛보기
		
		//java.utill.Date
		Date date = new Date();  // 이 클래스도 import 해야함
		
		//Thu Sep 16 10:36:21 KST 2021
		//현재 시각 - 실행한 당시의 컴퓨터 시각
		System.out.println(date);
		
		
	}

}

