package ua.khpi.oop.bilyi08;
import java.io.FileNotFoundException;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
//		addressbook.add( new Person("Білий Вадим Іванович","+380504949705",new GregorianCalendar(2001,11,2),"c.Berislaw"));
//		addressbook.add( new Person("Васильев Кирил Дмитревич","+09216816",new GregorianCalendar(2002,0,2),"c.Berislaw"));
//		addressbook.add( new Person("Ким Чен Ын","+18331516135",new GregorianCalendar(1982,1,8),"c.Berislaw"));
//		addressbook.add( new Person("Джордж Уокер","+8099118",new GregorianCalendar(1946,3,6),"c.Berislaw"));
//		addressbook.add( new Person("Шино Рен","+518181618",new GregorianCalendar(1991,5,22),"c.Berislaw"));
//		Dir.directoryForDownload();
	    try {
			Menu();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	public static void Menu() throws FileNotFoundException {
		AddressBook addressbook = new AddressBook();
		boolean prz = true;
		Scanner scan = new Scanner(System.in);
		
		String name = "name";
		String telephone = "telephone";
		int year = 0;
		int month = 0;
		int day = 0;
		String city = "city";
		String temp;
		
		while(prz){
		System.out.println("1.Add element\n2.Show data\n3.Save\n4.Download\n5.Delete\n0.End\nInput command id: ");
		switch (scan.nextInt()) {
		case 1:
			System.out.println("Enter name: ");
			scan.nextLine();
			name = scan.nextLine();
			System.out.println("Enter number of telephone: ");
			telephone =  scan.nextLine();
			System.out.println("Enter year of birth: ");
			year = scan.nextInt();
			System.out.println("Enter month of birth: ");
			month = scan.nextInt();
			System.out.println("Enter day of birth: ");
			day = scan.nextInt();
			System.out.println("Enter city: ");
			scan.nextLine();
			city = scan.nextLine();
			addressbook.add(new Person(name,telephone,new GregorianCalendar(year,month-1,day),city));
			break;
		case 2: 
			addressbook.print(); 
			break;
		case 3: 
			temp = Dir.directoryForDownload();
			
			if(temp.equals("DONTDOWNLOAD")) {
				System.out.println("You don`t choose file");
				break;
			}
			addressbook.save(temp);
			
			scan.nextLine();
			break;
		case 4:
			temp = Dir.directoryForDownload();
			
			if(temp.equals("DONTDOWNLOAD")) {
				System.out.println("You don`t choose file");
				break;
				}
			addressbook.download(temp);
			scan.nextLine();
			break;
		case 5:
			System.out.println("Enter index: ");
			addressbook.delete(scan.nextInt());
			
			break;
			default:
					System.out.println("End program");
					prz = false;
					
			break;
			}
		}
		scan.close();
	}
	
	
	
	}
