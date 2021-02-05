package ua.khpi.oop.bilyi09;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String telephone;
	private Calendar dateOfBirthday;
	private String address;
	private Date dateOfLastRedaction;
	
	public String getFirstName() {
		String firstName = new String();
		for(int i = 0; i < name.length();i++)
		{
			if(name.charAt(i) == ' ') {
				return firstName;
			}
			else {
				firstName += name.charAt(i);
			}
		}
		return firstName;
	}
	
	public String getLastName() {
		String lastName = new String();
		int i = getFirstName().length();
		for(;name.charAt(i) == ' ' && i < name.length();i++) {}
		for( ;i < name.length(); i++) {
			if(name.charAt(i) == ' ') {
				return lastName;
			}
			else {
				lastName += name.charAt(i);
			}
		}
		return lastName;
	}
	
	public void setDateOfLastRedaction(Date dateOfLastRedaction) {
		this.dateOfLastRedaction = dateOfLastRedaction;
	}
	public void setName(String name) {
		this.name = name;
		dateOfLastRedaction = new Date();
	}
	public String getName() {
		return name;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
		dateOfLastRedaction = new Date();
	}
	public String getTelephone() {
		return telephone;
	}
	public void setDateOfBirthday(Calendar dateOfBirthday) {
		this.dateOfBirthday = dateOfBirthday;
		dateOfLastRedaction = new Date();
	}
	public Calendar getDateOfBirthday() {
		return dateOfBirthday;
	}
	public void setAddress(String address) {
		this.address = address;
		dateOfLastRedaction = new Date();
	}
	public String getAddress() {
		return address;
	}
	public Date getDateOfLastRedaction() {
		return dateOfLastRedaction;
	}
	public void addTelephone(String telephone) {
		this.telephone += " " + telephone;
		dateOfLastRedaction = new Date();
	}
	
	public Person() {
		super();
	}
	public void print() {
		System.out.println("\nName: " + this.getName()+"\nTelephone: "+ this.getTelephone() + "\nDate of birthday: " + this.getDateOfBirthday().getTime()+ "\nAdress: " + this.getAddress()+"\nDate of last redaction: "+ this.getDateOfLastRedaction().toString());		
	}
	
	@Override
	public String toString() {
		return new String("\nName: " + this.getName()+"\nTelephone: "+ this.getTelephone() + "\nDate of birthday: " + this.getDateOfBirthday().getTime()+ "\nAdress: " + this.getAddress()+"\nDate of last redaction: "+ this.getDateOfLastRedaction().toString());
	}
	
	
	Person(String name,String telephone,Calendar dateOfBirthday,String address){
		this.setName(name);
		this.setTelephone(telephone);
		this.setDateOfBirthday(dateOfBirthday);
		this.setAddress(address);
	}
	Person(String name,String telephone,Calendar dateOfBirthday,String address, Date dateOfLastRedaction){ 
		this.setName(name);                                                                 
    	this.setTelephone(telephone);                                                       
    	this.setDateOfBirthday(dateOfBirthday);                                             
    	this.setAddress(address);                 
    	this.setDateOfLastRedaction(dateOfLastRedaction);
    }                                                                                       
}


/*
package ua.khpi.oop.bilyi09;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<String> telephone;
	private Calendar dateOfBirthday;
	private String address;
	private Date dateOfLastRedaction;
	
	public void setDateOfLastRedaction(Date dateOfLastRedaction) {
		this.dateOfLastRedaction = dateOfLastRedaction;
	}
	public void setName(String name) {
		this.name = name;
		dateOfLastRedaction = new Date();
	}
	public String getName() {
		return name;
	}
	public void setTelephone(ArrayList<String> telephone) {
		this.telephone = telephone;
		dateOfLastRedaction = new Date();
	}
	public ArrayList<String> getTelephone() {
		return telephone;
	}
	public void setDateOfBirthday(Calendar dateOfBirthday) {
		this.dateOfBirthday = dateOfBirthday;
		dateOfLastRedaction = new Date();
	}
	public Calendar getDateOfBirthday() {
		return dateOfBirthday;
	}
	public void setAddress(String address) {
		this.address = address;
		dateOfLastRedaction = new Date();
	}
	public String getAddress() {
		return address;
	}
	public Date getDateOfLastRedaction() {
		return dateOfLastRedaction;
	}
	public void addTelephone(String telephone) {
		this.telephone.add(telephone);
		dateOfLastRedaction = new Date();
	}
	
	public Person() {
		super();
	}
	public void print() {
		System.out.println("\nName: " + this.getName()+"\nTelephone: "+ this.getTelephone() + "\nDate of birthday: " + this.getDateOfBirthday().getTime()+ "\nAdress: " + this.getAddress()+"\nDate of last redaction: "+ this.getDateOfLastRedaction().toString());		
	}
	
	@Override
	public String toString() {
		return new String("\nName: " + this.getName()+"\nTelephone: "+ this.getTelephone() + "\nDate of birthday: " + this.getDateOfBirthday().getTime()+ "\nAdress: " + this.getAddress()+"\nDate of last redaction: "+ this.getDateOfLastRedaction().toString());
	}
	
	
	Person(String name,ArrayList<String> telephone,Calendar dateOfBirthday,String address){
		this.setName(name);
		this.setTelephone(telephone);
		this.setDateOfBirthday(dateOfBirthday);
		this.setAddress(address);
	}
	Person(String name,String telephone,Calendar dateOfBirthday,String address){
		this.setName(name);
		ArrayList<String> mass= new ArrayList<>();
		mass.add(telephone);
		this.setTelephone(mass);
		this.setDateOfBirthday(dateOfBirthday);
		this.setAddress(address);
	}
	Person(String name,ArrayList<String> telephone,Calendar dateOfBirthday,String address, Date dateOfLastRedaction){ 
		this.setName(name);                                                                 
    	this.setTelephone(telephone);                                                       
    	this.setDateOfBirthday(dateOfBirthday);                                             
    	this.setAddress(address);                 
    	this.setDateOfLastRedaction(dateOfLastRedaction);
    }                                                                                       
}
*/