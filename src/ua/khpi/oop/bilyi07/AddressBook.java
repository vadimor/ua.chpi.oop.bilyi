package ua.khpi.oop.bilyi07;

import java.util.ArrayList;

public class AddressBook {
	ArrayList<Person> mass = new ArrayList<Person>();
	public void add(Person person) {
		mass.add(person);
	}
	public void print() {
	for(var person : mass) {
		System.out.println("\nName: "+person.getName()+"\nTelephone: "+ person.getTelephone() + "\nDate of birthday: " +person.getDateOfBirthday().getTime()+ "\nAdress: " +person.getAddress()+"\nDate of last redaction: "+ person.getDateOfLastRedaction().toString());
		}
	}
}
