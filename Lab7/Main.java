package ua.khpi.oop.bilyi07;

import java.util.GregorianCalendar;

public class Main {
	
	public static void main(String[] args) {
		AddressBook addressbook = new AddressBook();
		addressbook.add(new Person("Білий Вадим Іванович","+380504949705",new GregorianCalendar(2001,11,2),"c.Berislaw"));
		addressbook.add(new Person("Васильев Кирил Дмитревич","+09216816",new GregorianCalendar(2002,0,2),"c.Berislaw"));
		addressbook.add( new Person("Ким Чен Ын","+18331516135",new GregorianCalendar(1982,1,8),"c.Berislaw"));
		addressbook.add( new Person("Джордж Уокер","+8099118",new GregorianCalendar(1946,3,6),"c.Berislaw"));
		addressbook.add( new Person("Шино Рен","+518181618",new GregorianCalendar(1991,5,22),"c.Berislaw"));
		addressbook.print();
		}
	}
