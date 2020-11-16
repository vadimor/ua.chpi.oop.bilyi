package ua.khpi.oop.bilyi03;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("Input line: ");
		Helper.start(new StringBuilder(scan.nextLine()));
		scan.close();
		
	}
}
