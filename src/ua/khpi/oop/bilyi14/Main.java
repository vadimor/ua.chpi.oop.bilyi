package ua.khpi.oop.bilyi14;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {

		for (var str : args) {
			if (str.equals("-auto")) {
				try {
					Helper.Auto();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
		}
		try {
			Helper.Menu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		addressbook.add( new Person("����� �����","+380504949705 +518181618 +18331516135",new GregorianCalendar(2001,11,2),"c.Berislaw"));
//		addressbook.add( new Person("���� ���","+518181618",new GregorianCalendar(1991,5,22),"c.Berislaw"));
//		addressbook.add( new Person("�������� �����","+09216816",new GregorianCalendar(2002,0,2),"c.Berislaw"));
//		addressbook.add( new Person("��� ���","+18331516135",new GregorianCalendar(1982,1,8),"c.Berislaw"));
//		addressbook.add( new Person("������ �����","+8099118 +518181618",new GregorianCalendar(1946,3,6),"c.Berislaw"));
	}

}
