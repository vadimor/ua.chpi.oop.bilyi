package ua.khpi.oop.bilyi07;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Person {
	private String name;
	private ArrayList<String> telephone;
	private Calendar dateOfBirthday;
	private String address;
	private Date dateOfLastRedaction;
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
	Person(){
		name = null;
		telephone = null;
		dateOfBirthday = null;
		address = null;
		dateOfLastRedaction = new Date();		
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
}
