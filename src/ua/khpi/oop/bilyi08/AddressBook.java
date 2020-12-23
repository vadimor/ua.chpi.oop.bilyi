package ua.khpi.oop.bilyi08;

import java.util.ArrayList;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;



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
	
	
	
	
	
	
	public void save(String fileName) throws FileNotFoundException {
		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
		encoder.writeObject(mass);
		encoder.close(); 
		System.out.println("Serialization successful\n");
	}
	
	@SuppressWarnings("unchecked")
	public void download(String fileName) throws FileNotFoundException {
		XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream(fileName)));
		mass = (ArrayList<Person>) d.readObject();
		d.close();
		System.out.println("Serialization successful\n");
	}
	
	void delete(int n) {
		if(n<mass.size())
		mass.remove(n);
		else
			System.out.println("Element don`t exists");
	}
	
	public AddressBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
}
