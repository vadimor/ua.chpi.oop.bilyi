package ua.khpi.oop.bilyi06;
import java.io.IOException;
import java.util.Scanner;
import ua.khpi.oop.yampolskyi03.*;


public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
		
		//Menu();
	}
	public static void Menu() {
		boolean prz = true;
		Scanner scan = new Scanner(System.in);
		MyCollection collection = new MyCollection();
		MyCollection temp = new MyCollection();
		while(prz){
			System.out.println("1.Enter word\n2.Show data\n3.Start\n4.Start method other student\n5.Save\n6.Download\n7.Sorting\n8.Find\n9.Compare with saving\n0.End\nInput command id: ");
		switch (scan.nextInt()) {
		case 1:
			System.out.println("Enter word: ");
			scan.nextLine();
			collection.add(scan.nextLine());
			break;
		case 2: 
			System.out.println(collection.toString());
			break;
		case 3: 
			Helper.start(collection.toString());
			break;
		case 4:
			VowelsOrConsonants.splitTextInSentenses(new StringBuffer(collection.toString()));
			break;
		case 5:
			System.out.println("Enter file name: ");
			scan.nextLine();
			try {
				collection.Save(scan.nextLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 6:
			System.out.println("Enter file name: ");
			scan.nextLine();
			try {
				collection.Download(scan.nextLine());
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 7:
			collection.sort();
			break;
		case 8:
			scan.nextLine();
			System.out.println("Enter data:");
			int index = collection.find(scan.nextLine());
			if(index==-1)
				System.out.println("Element don`t found");
			else
				System.out.println("Element index in mass: "+index);
			break;
		case 9:
			System.out.println("Enter file name: ");
			scan.nextLine();
			try {
				temp.Download(scan.nextLine());
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(collection.equals(temp))
				System.out.println("Are equal");
			else 
				System.out.println("Not equal");
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
