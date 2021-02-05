package ua.khpi.oop.bilyi09;
import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.GregorianCalendar;
//import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		MyCollection<Person> addressbook = new MyCollection<Person>();
		Person person = new Person("Білий Вадим","+380504949705",new GregorianCalendar(2001,11,2),"c.Berislaw");
		addressbook.add(person);
		addressbook.add( new Person("Васильев Кирил","+09216816",new GregorianCalendar(2002,0,2),"c.Berislaw"));
		addressbook.add( new Person("Ким Чен Ын","+18331516135",new GregorianCalendar(1982,1,8),"c.Berislaw"));
		addressbook.add( new Person("Джордж Уокер","+8099118",new GregorianCalendar(1946,3,6),"c.Berislaw"));
		addressbook.add( new Person("Шино Рен","+518181618",new GregorianCalendar(1991,5,22),"c.Berislaw"));	
		
		System.out.println(addressbook.find(person));

		System.out.println(addressbook);
		
		addressbook.delete(4);
		
		System.out.println(addressbook);
		
		try {
			addressbook.saveXml("SaveXML.xml");

			addressbook.clear();
			
			System.out.println(addressbook);	
			
			addressbook.downloadXml("SaveXML.xml");	
			
			System.out.println(addressbook);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Массив");
		Person []mass = addressbook.toArray(new Person[addressbook.getSize()]);
		for(Person p : mass) {
		System.out.println(p);
		}

	}	
}
