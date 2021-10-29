package OverloadingandDateTime;

import java.util.Calendar;
import java.util.Date;

public class DateTime {
	
	private static Calendar birthday;
	

	public static void main(String[] args) {
		
		//[DateTime]
		/*
		 �ڹ� �ڷ���
		 - ������, ����, ������
		 - ���ڿ�, ��¥�ð���
		
		 
		 DateTime, ��¥�ð� �ڷ���
		 1. Date Ŭ����(legacy)
		 2. Calendar Ŭ���� ***
		 3. �߰� Ŭ����
		  
		 1. �ð�
		 2. �ð�
		 
		 2021�� 9�� 16�� ���� 10�� 7�� -> �ð� vs �ð� => �ð�
		 
		 8�ð� ���� -> �ð� vs �ð� => �ð�
		 
		 �Ѵ� ������ ���� �ٸ� �������̴�. �������� ���� ����.
		 
		 �ð�, �ð� -> ����
		 
		 �ð� + �ð� = (X), 2021�� 9�� 16�� + 2022�� 5�� 3�� = ?
		 �ð� - �ð� = �ð�(O), 2022�� 5�� 3��  - 2021�� 9�� 16�� = epoch, tick
		 �ð� + �ð� = �ð�(O), 8�ð� + 2�ð� = 10�ð�
		 �ð� - �ð� = �ð�(O), 8�ð� - 2�ð� = 10�ð� 
		 �ð� + �ð� = �ð�(O), 2021�� 9�� 16�� + 100�� = ~
		 �ð� - �ð� = �ð�(O), 2021�� 9�� 16�� - 100�� = ~
		 
		 //������ �ǰ� : �ð��� ����, �ð��� �� �̶�� �����ϸ� �����
		 
		 */
		//m1();    // 1������
		//m2();    // 2�� ���� 
		//m3();    // 3�� ����
		//m4();	   // 4�� ����
		//m5();	   //5�� ����
		//m6();
		//m7();
		
		
	}//main

	private static void m7() {
		
		//���� �ð��� tick?
		
		Calendar now = Calendar.getInstance();
		System.out.println(now.getTimeInMillis());
		
		//���� �ð��� tick���� ��ȯ�ϴ� ���� �޼ҵ�
		System.out.println(System.currentTimeMillis());
		
		
	}

	private static void m6() {
		
		//����
		//�ð� + �ð� > add()
		//�ð� - �ð� > add()
		//�ð� - �ð� > tick - tick
		//�ð� + �ð� > �������
		//�ð� - �ð� > �������
		
		
		//1.  2�ð� 30�� + 10�� = 2�ð� 40��
		int hour = 2;
		int min = 30;
		
		min +=10;
		
		System.out.printf("%d�ð� %d��\n", hour, min);
		
		//2.  2�ð� 30�� + 40�� = 3�ð� 10��
		hour = 2;
		min = 30;
		
		min = min + 40; // 2�ð� 70��
		hour = hour + (min /60); //3�ð�, �ణ ���� ȯ�� ������, �� > �ڸ��ø�
		min = min % 60; //10�� > ������ > ��
		System.out.printf("%d�ð� %d��\n", hour, min);
		
	}
	

	private static void m5() {

		//����
		//- �ð� - �ð� = �ð�
		
		Calendar now = Calendar.getInstance();
		Calendar bithday = Calendar.getInstance();
//		birthday.set(1995, 4, 10, 13, 30, 25);
		
		//now - birthday = ���� ��ƿ� �ð�
		//now - birthday; //���� �����ʹ� -�� �ǿ����ڷ� ��� �Ұ���
		
		//��� �����ڴ� �ݵ�� �ǿ����ڰ� �������� �� �� �ִ�.
		
		//tick��
//		System.out.println(birthday.getTimeInMillis()); //800080225799ms 
		
//		long birthdayTick = birthday.getTimeInMillis();
		long nowTick = now.getTimeInMillis();
		
//		System.out.println((nowTick - birthdayTick) / 1000 / 60 /60 /24);
		
		//���� ũ���������� ��ĥ ���Ҵ���?
		//ũ�������� - ����
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
		System.out.println(n); //11  ��, �ڱ��ڽ��� �ǵ��̴� ����!!
		
		
		//����
		//-1. �ð� + �ð�
		//- �ð� - �ð�
		//- void add(int, int) : add��� �޼���� ������ �ǵ鿩�� �����ϴ� �޼�����
		
		
		//1.
		//���� ���� Ŀ�� > 100�� 
		Calendar now = Calendar.getInstance();
		System.out.printf("1����: %tF\n", now);
		
		//�����ϱ�
		now.add(Calendar.DATE, 100);  //now���ٰ� ��¥�� 100 ���ض�
		System.out.printf("100���� : %tF\n", now);
		
		//�ٽ� ���÷� �ʱ�ȭ
		now.set(2021, 8, 16);
		System.out.printf("����: %tF\n", now);
		
		//���� �¾ �Ʊ� -> ù��
		now.add(Calendar.YEAR, 1);
		System.out.printf("ù��: %tF\n", now);
		
		//�ٽ� ���÷� �ʱ�ȭ
		now.set(2021, 8, 16);
		System.out.printf("����: %tF\n", now);
	
		//5�ð� 25�� �� ��Ÿ�� ����
		now.add(Calendar.HOUR, 5);
		now.add(Calendar.MINUTE, 25);
		
		System.out.printf("��Ÿ�� ���� �ð�: %tT\n", now);
		
		
		//2.
		//�ٽ� ���÷� �ʱ�ȭ
		now.set(2021, 8, 16);
		System.out.printf("����: %tF\n", now);
		
		//100���� ��
		now.set(Calendar.MONTH, -100);
		System.out.printf("100���� ��: %tF\n", now);
		
		//�����Ϸ� �ʱ�ȭ
		now.set(2021, 8, 8);
		now.add(Calendar.DATE, 112);
		System.out.printf("������: %tF\n", now);
		
	}

	private static void m3() {
		
		//Ư�� �ð� ������
		//1. ����ð������ -> 2. �� �ð��� ���ϴ� �ð����� �����ϱ�
		
		//�� ����
		// - 1995�� 10�� 12�� 0�� 12�� 25��  > Calendar �����ϱ�
		Calendar birthday = Calendar.getInstance();
		
		// ooo,get() : ������, �б� > �޼ҵ�
		// ooo,set() : ����ֱ�, ���� > �޼ҵ�
		
		//�����ϱ�
		// - void set(int ���, int ��)
		// - void set(int, int, int)
		// - void set(int, int, int, int, int, int)
		
		
		//birthday.set(1995, 9, 12);
		

		birthday.set(1995, 4, 10, 15, 30, 25);
		
		//birthday.set(1995, 4, 10);
//Q06���� �򰥷ȴ� �κ��� ������ ����	
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
		
		//���� �ð� ������ + ���ϴ� �׸� �����ϱ� + ���Ĺ���(%tF, %tT, %tA)

		//Calendar Ŭ����
		
		//���� �ð� ������
		//java.utill.Calendar
		Calendar c1 = Calendar.getInstance(); // =���� �ð�, �ڹٴ� ������ ���� �ð����� ��� ����
		
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
		
		//Calendar�ȿ� ����ִ� ���� ������ �� ���ϴ� �׸� ��������
		// - int get(int)
		
		System.out.println();
		
		System.out.println(c1.get(1)); //�⵵
		System.out.println(c1.get(2)); // ?
		System.out.println(c1.get(3)); // ? 
		System.out.println(c1.get(4)); // ?
		System.out.println(c1.get(5)); // ?

		
		int year = 1;
		System.out.println(c1.get(1));		//������ ����
		System.out.println(c1.get(year));	//������ ����

		//�ڹٰ� �����ϴ� Calendar ���
		System.out.println(Calendar.YEAR);  // ������, �� �⵵��� ������ �ڹٰ� ����� �� ����
		System.out.println(c1.get(Calendar.YEAR)); //** ������ ����ϴ� ����
		
		//c1
		System.out.println("---------------------------------");
		System.out.println(c1.get(Calendar.YEAR));				//2021. �⵵
		System.out.println(c1.get(Calendar.MONTH));				//8	  . ��(0~11) : 8���� ����
		System.out.println(c1.get(Calendar.DATE));				//16  . ��¥(��)
		System.out.println(c1.get(Calendar.HOUR));				//11  . ��(12H)
		System.out.println(c1.get(Calendar.MINUTE));			//12  . ��
		System.out.println(c1.get(Calendar.SECOND));			//8   . ��
		System.out.println(c1.get(Calendar.MILLISECOND));		//221 . �и���(1/1000)
		System.out.println(c1.get(Calendar.AM_PM));				//0   . ����(0), ����(1) 
		System.out.println(c1.get(Calendar.DAY_OF_YEAR));		//259 . ��(���ص�� ������ ��ĥ°����)
		System.out.println(c1.get(Calendar.DAY_OF_MONTH));		//16  . ��(�̹��� �� ������ ��ĥ°����)
		System.out.println(c1.get(Calendar.DAY_OF_WEEK));		//5   . ��(����) : �̹��� �� ������ ��ĥ°����, �Ͽ��Ϻ��ͼ�
		System.out.println(c1.get(Calendar.WEEK_OF_YEAR));		//38  . ��(��)  : ���ص�� �̹��ְ� ����������
		System.out.println(c1.get(Calendar.WEEK_OF_MONTH));		//3   . ��(°)  : �̹��ְ� �̹��� ��� ����°����
		System.out.println(c1.get(Calendar.HOUR_OF_DAY));		//11  . �ð�(°,24H): ���� ��� ������ ��ð�°����
		
		
		//�䱸����] ������ '2021�� 9�� 16�� ���� 11�� 18�� 30��'�Դϴ�. �� ����Ͻÿ�
		
		System.out.printf("������ '%d�� %d�� %d�� %s %d�� %d�� %d��'�Դϴ�.\n",
				c1.get(Calendar.YEAR), 
				c1.get(Calendar.MONTH) + 1, 
				c1.get(Calendar.DATE), 
				c1.get(Calendar.AM_PM) == 0 ? "����" : "����" , 
				c1.get(Calendar.HOUR), 
				c1.get(Calendar.MINUTE),
				c1.get(Calendar.SECOND)
				);
		System.out.println();
		
		//printf() - ���Ĺ��� > ��¥�ð���
		System.out.printf("%tF\n", c1); //1. ����� 2021-09-16
		System.out.printf("%d-%d-%d\n"
				, c1.get(Calendar.YEAR)
				, c1.get(Calendar.MONTH)
				, c1.get(Calendar.DATE));
		
		System.out.printf("%tT\n, c1"); //2. �ú���
		System.out.printf("tA\n", c1);  //3. ����
		
	}

	private static void m1() {
		
		//Date Ŭ���� ������
		
		//java.utill.Date
		Date date = new Date();  // �� Ŭ������ import �ؾ���
		
		//Thu Sep 16 10:36:21 KST 2021
		//���� �ð� - ������ ����� ��ǻ�� �ð�
		System.out.println(date);
		
		
	}

}

