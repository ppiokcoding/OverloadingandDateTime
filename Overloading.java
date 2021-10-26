package OverloadingandDateTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Overloading {

	public static void main(String[] args) throws IOException {

		// Eclipse vs IntelliJ
		// Word Wrap : Alt + Shift + Y (�ڵ� �� �ٲ�)

		// [Overloading]

		/*
		  
		  �޼ҵ� �����ε�, Method Overloading (���� ����) - �޼ҵ尡 ���� ����Ʈ�� �پ��� ���·� ���� �� �ִ� ��� - ����
		  �̸��� �޼ҵ带 ������ ���� �� �ִ� ���
		 
		  �޼ҵ� �ñ׳�ó
		  
		  �޼ҵ� �����ε� ���� ���� ���� 1. �Ű������� ���� 2. �Ű������� �ڷ���
		  
		  �޼ҵ� �����ε� ���� ���� �Ұ��� 1. �Ű������� �̸� 2. ��ȯ���� �ڷ���
		  
		  
		  
		  �޼ҵ带 �����ϴ� ��.. 1. public static void test() {} //(o) 2. public static void
		  test() {} //(x) �Ȱ��� �׷��� ������ 1�������� ������ �� 3. public static void test(int n) {}
		  //(o) 4. public static void test(int m) {} //(x) 3�� ������ �ȵ� 5. public static
		  void tset(String s) {} //(o) 6. public static void test(int n, int m) {}
		  //(o) 7. public static int test(int n) {} //(x) 3�� ������ �ȵ�
		  
		  
		  �޼ҵ带 ȣ���ϱ�(���� �������� �Ǵ�) test(); // ������ or �����??? test(); //1. test(10); //3
		  
		  test(20); //3 test("ȫ�浿"); //5
		  
		  test(10, 20); //6
		  
		  test(10): //3�� int result = test(10); //7��
		  
		  
		  #�޼ҵ� �����ε��� �ϴ� ����? - ���� ���(x) - ������ ����(��)
		 */

		System.out.println("ȫ�浿");
		System.out.println(20);
		drawLine(); // �⺻ ���� -> drawLine

		System.out.println("�ڹ� ���");
		drawLine(); // �⺻ ���� -> drawLine

		System.out.println("������");
		drawLine("*"); // Ư������

		// �޼ҵ� �����ε��� ����
		// System(Ŭ����)
		// out(�ʵ�)
		System.out.println(100);
		System.out.println("ȫ�浿");
		System.out.println(true);
		System.out.print("ȫ�浿");

		// 10���� �޼ҵ� -> �����ε� -> println()

		// �޼ҵ� ����
		// - �Ű������� ���޹��� ���ڵ� �� ����� ������ ����� ��ȯ�ϴ� �޼ҵ�
		// - �����ε�

		// positive(10) -> 1
		// positive(-5) -> 0
		// int count = positive(num1, num2);
		// positive(10, 5) -> 2
		// positive(10, -10) ->1
		// positive(-5, -10) -> 0

		// ����
		// java 11 document ����

		drawLine("#");

		int num1 = inputNumber();
		int count = positive(num1);
		System.out.println("����� ����: " + count);

		int num2 = inputNumber();
		count = positive(num1, num2);
		System.out.println("����� ����: " + count);

		int num3 = inputNumber();
		count = positive(num1, num2, num3);
		System.out.println("����� ����: " + count);

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

		// �Ѿ�� �Ű����� �� ����� �� �� �ִ���?
		int count = 0; // ���� ����

		count = num1 > 0 ? 1 : 0;

		return count;

	}

	public static int inputNumber() throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("���� �Է�: ");

		String input = reader.readLine();

		// num �޸� 4����Ʈ��ŭ �޸𸮸� �����Ѵ�.
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

	// ���� �ߴ� �޼ҵ� x ��� ������
	// -> 10�� ������� -> �޼ҵ�� x 10��
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
		System.out.println("������");
	}

	// public static void test() {
	// System.out.println("�����");
	// }

	public static void test(int n) {
		System.out.println("���Ƹ�" + n);

	}

	// public static void test(int n) {
	// System.out.println("���Ƹ�" + n);
	// }

}

