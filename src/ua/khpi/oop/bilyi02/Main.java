package ua.khpi.oop.bilyi02;
import java.util.Random;
public class Main {
 public static void main(String[] args) {
 Random random = new Random(); // случайное число
 Main mn = new Main(); 
 int rn = 0;
 for (int i = 0; i< 10; i++) {
	 rn = random.nextInt();
	 System.out.println("--------------------------------");
	 System.out.println("|Число                Результат|");
	 System.out.print("|"+ rn);
	 int temp = rn;
	 if (temp<0) {
		 temp = temp * (-1);
		 temp = 28 - findCount(temp);
	 }
	 else 
		 temp = 29 - findCount(temp);
	 for(int j = 0;j<temp;j++) {
		 System.out.print(' ');
	 }
	 System.out.print(mn.findTheBigesNum(rn)+"|\n");
	 System.out.println("--------------------------------");
	 }
 }
 int findTheBigesNum(int num) {// нахождение найбольшей цифры
	 if(num<0)
		 num = num*(-1);
	 int count = findCount(num);
	 int max = 0;
	 for(int i =1; i <= count;i++) {
		 if(max<((num/(int)Math.pow(10,(count-i)))%10)) {
			 max = (num/(int)Math.pow(10,(count-i)))%10;
		 }
	 }
	 return max;
 }
 
static int findCount(int num) { // нахождения разряда 
	 int count = 0;
	 while(num>0) {
		 num = num / 10;
		 count++;
	 }
	 
	 return count;
 }
}
