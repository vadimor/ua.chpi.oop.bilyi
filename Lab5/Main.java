package ua.khpi.oop.bilyi05;

import java.util.Iterator;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("Input line: ");
		Helper.start(scan.nextLine());
		scan.close();
		MyCollection collection = new MyCollection();
		collection.add("Первая");
		collection.add("Вторая");
		collection.add("Третья");
		collection.add("Четвертая");
		
		for(var str : collection)
		{
			System.out.println(str);
		}
		Iterator<String> it = collection.iterator(); 
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
}
