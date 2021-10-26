package OverloadingandDateTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Overloading {

	public static void main(String[] args) throws IOException {

		// Eclipse vs IntelliJ
		// Word Wrap : Alt + Shift + Y (자동 줄 바꿈)

		// [Overloading]

		/*
		  
		  메소드 오버로딩, Method Overloading (면접 질문) - 메소드가 인자 리스트를 다양한 형태로 가질 수 있는 기술 - 같은
		  이름의 메소드를 여러개 만들 수 있는 기술
		 
		  메소드 시그너처
		  
		  메소드 오버로딩 구현 조건 가능 1. 매개변수의 개수 2. 매개변수의 자료형
		  
		  메소드 오버로딩 구현 조건 불가능 1. 매개변수의 이름 2. 반환값의 자료형
		  
		  
		  
		  메소드를 선언하는 중.. 1. public static void test() {} //(o) 2. public static void
		  test() {} //(x) 똑같음 그래서 에러남 1번때문에 에러난 것 3. public static void test(int n) {}
		  //(o) 4. public static void test(int m) {} //(x) 3번 때문에 안됨 5. public static
		  void tset(String s) {} //(o) 6. public static void test(int n, int m) {}
		  //(o) 7. public static int test(int n) {} //(x) 3번 때문에 안됨
		  
		  
		  메소드를 호출하기(이쪽 관점으로 판단) test(); // 강아지 or 고양이??? test(); //1. test(10); //3
		  
		  test(20); //3 test("홍길동"); //5
		  
		  test(10, 20); //6
		  
		  test(10): //3번 int result = test(10); //7번
		  
		  
		  #메소드 오버로딩을 하는 이유? - 성능 향상(x) - 개발자 도움(ㅇ)
		 */

		System.out.println("홍길동");
		System.out.println(20);
		drawLine(); // 기본 라인 -> drawLine

		System.out.println("자바 언어");
		drawLine(); // 기본 라인 -> drawLine

		System.out.println("하하하");
		drawLine("*"); // 특별라인

		// 메소드 오버로딩의 혜택
		// System(클래스)
		// out(필드)
		System.out.println(100);
		System.out.println("홍길동");
		System.out.println(true);
		System.out.print("홍길동");

		// 10개의 메소드 -> 오버로딩 -> println()

		// 메소드 선언
		// - 매개변수로 전달받은 숫자들 중 양수의 개수가 몇개인지 반환하는 메소드
		// - 오버로딩

		// positive(10) -> 1
		// positive(-5) -> 0
		// int count = positive(num1, num2);
		// positive(10, 5) -> 2
		// positive(10, -10) ->1
		// positive(-5, -10) -> 0

		// 도움말
		// java 11 document 구글

		drawLine("#");

		int num1 = inputNumber();
		int count = positive(num1);
		System.out.println("양수의 개수: " + count);

		int num2 = inputNumber();
		count = positive(num1, num2);
		System.out.println("양수의 개수: " + count);

		int num3 = inputNumber();
		count = positive(num1, num2, num3);
		System.out.println("양수의 개수: " + count);

		// int count = positive(num1);

	}// main

	private static int positive(int num1, int num2, int num3) {

		int count = 0;

		count += num1 > 0 ? 1 : 0;
		count += num2 > 0 ? 1 : 0;
		count += num3 > 0 ? 1 : 0;

		return count;
	}

	private static int positive(int num1, int num2) {

		int count = 0;

		count += num1 > 0 ? 1 : 0;
		count += num2 > 0 ? 1 : 0;

		return count;
	}

	private static int positive(int num1) {

		// 넘어온 매개변수 중 양수가 몇 개 있는지?
		int count = 0; // 누적 변수

		count = num1 > 0 ? 1 : 0;

		return count;

	}

	public static int inputNumber() throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("숫자 입력: ");

		String input = reader.readLine();

		// num 메모리 4바이트만큼 메모리를 낭비한다.
		// int num = Integer.parseInt(input);

		int num = Integer.parseInt(input);
		return num;
	}

	public static void println(int n) {

	}

	public static void println(String n) {

	}

	public static void println(boolean n) {

	}

	// 선을 긋는 메소드 x 모양 여러개
	// -> 10개 만들었음 -> 메소드명 x 10개
	public static void drawLine() {
		System.out.println("==============================");
	}

	public static void drawLine(String s) {
		System.out.println(s);
		System.out.println(s);
		System.out.println(s);
		System.out.println(s);
		System.out.println(s);
		System.out.println(s);
		System.out.println(s);
		System.out.println(s);
		System.out.println(s);
		System.out.println(s);
		System.out.println(s);
		System.out.println(s);
		System.out.println(s);
		System.out.println(s);

	}

	public static void drawLinePlus() {
		System.out.println("++++++++++++++++++++++++++++++");
	}

	public static void test() {
		System.out.println("강아지");
	}

	// public static void test() {
	// System.out.println("고양이");
	// }

	public static void test(int n) {
		System.out.println("병아리" + n);

	}

	// public static void test(int n) {
	// System.out.println("병아리" + n);
	// }

}

