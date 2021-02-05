package ua.khpi.oop.bilyi10;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String telephone;
	private Calendar dateOfBirthday;
	private String address;
	private Calendar dateOfLastRedaction;

	public void setAddress(String address) {
		this.address = address;
		dateOfLastRedaction = new GregorianCalendar();
	}

	public void setName(String name) {
		this.name = name;
		dateOfLastRedaction = new GregorianCalendar();
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
		dateOfLastRedaction = new GregorianCalendar();
	}

	public void setDateOfLastRedaction(String dateOfLastRedaction) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(sdf.parse(dateOfLastRedaction));
		this.dateOfLastRedaction = cal1;
	}

	public void setDateOfBirthday(String dateOfBirthday) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(sdf.parse(dateOfBirthday));
		this.dateOfBirthday = cal1;

		dateOfLastRedaction = new GregorianCalendar();
	}

	public void setDateOfLastRedaction(Calendar dateOfLastRedaction) {
		this.dateOfLastRedaction = dateOfLastRedaction;
	}

	public void setDateOfBirthday(Calendar dateOfBirthday) {
		this.dateOfBirthday = dateOfBirthday;
		dateOfLastRedaction = new GregorianCalendar();
	}

	public String getFirstName() {
		String firstName = new String();
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == ' ') {
				return firstName;
			} else {
				firstName += name.charAt(i);
			}
		}
		return firstName;
	}

	public String getLastName() {
		String lastName = new String();
		int i = getFirstName().length();
		for (; name.charAt(i) == ' ' && i < name.length(); i++) {
		}
		for (; i < name.length(); i++) {
			if (name.charAt(i) == ' ') {
				return lastName;
			} else {
				lastName += name.charAt(i);
			}
		}
		return lastName;
	}

	public String getName() {
		return name;
	}

	public String getTelephone() {
		return telephone;
	}

	public Calendar getDateOfBirthday() {
		return dateOfBirthday;
	}

	public String getAddress() {
		return address;
	}

	public Calendar getDateOfLastRedaction() {
		return dateOfLastRedaction;
	}

	public void addTelephone(String telephone) {
		this.telephone += " " + telephone;
		dateOfLastRedaction = new GregorianCalendar();
	}

	public Person() {
		super();
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
		return new String("\nName: " + this.getName() + "\nTelephone: " + this.getTelephone() + "\nDate of birthday: "
				+ sdf1.format(this.getDateOfBirthday().getTime()) + "\nAdress: " + this.getAddress()
				+ "\nDate of last redaction: " + sdf2.format(this.getDateOfLastRedaction().getTime()));
	}

	Person(String name, String telephone, Calendar dateOfBirthday, String address) {
		this.setName(name);
		this.setTelephone(telephone);
		this.setDateOfBirthday(dateOfBirthday);
		this.setAddress(address);
	}

	Person(String name, String telephone, String dateOfBirthday, String address) throws ParseException {
		this.setName(name);
		this.setTelephone(telephone);
		this.setDateOfBirthday(dateOfBirthday);
		this.setAddress(address);
	}

	Person(String name, String telephone, String dateOfBirthday, String address, String dateOfLastRedaction)
			throws ParseException {
		this.setName(name);
		this.setTelephone(telephone);
		this.setDateOfBirthday(dateOfBirthday);
		this.setAddress(address);
		this.setDateOfLastRedaction(dateOfLastRedaction);
	}

	Person(String name, String telephone, Calendar dateOfBirthday, String address, Calendar dateOfLastRedaction) {
		this.setName(name);
		this.setTelephone(telephone);
		this.setDateOfBirthday(dateOfBirthday);
		this.setAddress(address);
		this.setDateOfLastRedaction(dateOfLastRedaction);
	}
}