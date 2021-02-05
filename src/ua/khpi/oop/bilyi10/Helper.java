package ua.khpi.oop.bilyi10;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Helper {
	static <T extends Person> void sort(MyCollection<T> collection, ESort choose) {
		boolean przEnd = true;
		while (przEnd) {
			przEnd = false;
			for (int i = 0; i < collection.getSize() - 1; i++) {
				switch (choose) {
				case FIRSTNAME:

					if (collection.get(i).getFirstName().compareTo(collection.get(i + 1).getFirstName()) > 0) {
						collection.swap(i, i + 1);
						przEnd = true;
					}
					break;
				case LASTNAME:
					if (collection.get(i).getLastName().compareTo(collection.get(i + 1).getLastName()) > 0) {
						collection.swap(i, i + 1);
						przEnd = true;
					}
					break;
				case BIRTHDAY:
					if (collection.get(i).getDateOfBirthday()
							.compareTo(collection.get(i + 1).getDateOfBirthday()) > 0) {
						collection.swap(i, i + 1);
						przEnd = true;
					}
					break;
				case LASTREDACTION:
					if (collection.get(i).getDateOfLastRedaction()
							.compareTo(collection.get(i + 1).getDateOfLastRedaction()) > 0) {
						collection.swap(i, i + 1);
						przEnd = true;
					}
					break;
				default:
					break;
				}
			}
		}
	}

	enum ESort {
		FIRSTNAME, LASTNAME, BIRTHDAY, LASTREDACTION
	}

	static void saveToFile(String filename, String str) throws IOException {

		FileWriter file = new FileWriter(filename);
		file.write(str);
		file.close();
	}

	static String readFromFile(String filename) throws IOException {
		FileReader file = new FileReader(filename);
		String str = new String();

		int c = 0;
		while ((c = file.read()) != -1) {
			str += new String(new char[] { (char) c });
		}
		file.close();
		return str;
	}

	static MyCollection<Person> parsingPerson(String str) {
		MyCollection<Person> array = new MyCollection<Person>();
		String name = new String();
		String telephone = new String();
		String birthday = new String();
		String address = new String();
		String redaction = new String();
		while (str.indexOf("Name: ") >= 0 && str.length() > 0) {
			name = str.substring(str.indexOf("Name: ") + 6, str.indexOf("Telephone: ") - 1);
			telephone = str.substring(str.indexOf("Telephone: ") + 11, str.indexOf("Date of birthday: ") - 1);
			birthday = str.substring(str.indexOf("Date of birthday: ") + 18, str.indexOf("Adress: ") - 1);
			address = str.substring(str.indexOf("Adress: ") + 8, str.indexOf("Date of last redaction: ") - 1);
			redaction = new String();
			for (int i = str.indexOf("Date of last redaction: ") + 24; str.charAt(i) != '\n' && i < str.length(); i++) {
				redaction += str.charAt(i);
			}

			try {
				array.add(new Person(name, telephone, birthday, address, redaction));

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			str = str.substring(str.indexOf(redaction) + redaction.length() + 1);
		}

		// Name: Білий Вадим
		// Telephone: +380504949705 +518181618 +18331516135
		// Date of birthday: Sun Dec 02 00:00:00 EET 2001
		// Adress: c.Berislaw
		// Date of last redaction: Sun Jan 31 19:12:34 EET 2021
		return array;

	}

	static void Auto() throws IOException {
		MyCollection<Person> collection = parsingPerson(readFromFile("SAVETXT.txt"));
		System.out.println(collection);
		sort(collection, ESort.FIRSTNAME);
		System.out.println("После сортировки: Имя");
		System.out.println(collection);
		sort(collection, ESort.LASTNAME);
		System.out.println("После сортировки: Фамилия");
		System.out.println(collection);
		sort(collection, ESort.BIRTHDAY);
		System.out.println("После сортировки: Дата рождения");
		System.out.println(collection);
		sort(collection, ESort.LASTREDACTION);
		System.out.println("После сортировки: Дата редактировання");
		System.out.println(collection);
	}

	static void Menu() throws IOException {
		MyCollection<Person> collection = new MyCollection<Person>();
		Scanner scan = new Scanner(System.in);
		boolean prz = true;
		String name = new String();
		String telephone = new String();
		String birthday = new String();
		String address = new String();

		while (prz) {
			System.out.println(
					"\n1.Добавить элемент\n2.Удалить элемент\n3.Сортировать\n4.Вывод всех элементов.\n5.Записать в файл\n6.Считать с файла\n0.Выход\nВаш выбор:");

			switch (scan.nextInt()) {
			case 1:
				scan.nextLine();
				System.out.println("Полное имя: ");
				name = scan.nextLine();
				System.out.println("Номер телефона: ");
				telephone = scan.nextLine();
				System.out.println("Дата рождения в формате День.Месяц.Год: ");
				birthday = scan.nextLine();
				System.out.println("Адрес: ");
				address = scan.nextLine();
				try {
					collection.add(new Person(name, telephone, birthday, address));
				} catch (ParseException e) {
					System.out.println("Не удалось коректно считать");
					continue;
				}
				break;
			case 2:
				System.out.println("Номер элемента (начало с 0): ");
				collection.delete(scan.nextInt());
				break;
			case 3:
				System.out.println(
						"Как сортировать?\n1.По имени.\n2.По фамилии.\n3.По дате рождения.\n4.По дате последнего редактирования.\nВаш выбор: ");
				switch (scan.nextInt()) {
				case 1:
					sort(collection, ESort.FIRSTNAME);
					break;
				case 2:
					sort(collection, ESort.LASTNAME);
					break;
				case 3:
					sort(collection, ESort.BIRTHDAY);
					break;
				case 4:
					sort(collection, ESort.LASTREDACTION);
					break;
				default:
					break;
				}

				break;
			case 4:
				System.out.println(collection);
				break;
			case 5:
				scan.nextLine();
				System.out.println("Введите имя файла: ");
				saveToFile(scan.nextLine(), collection.toString());
				break;
			case 6:
				scan.nextLine();
				System.out.println("Введите имя файла: ");
				collection = parsingPerson(readFromFile(scan.nextLine()));
				break;
			case 0:
				prz = false;
				break;
			default:
				break;
			}
		}
		scan.close();
	}

}
