package ua.khpi.oop.bilyi02;
import java.util.Random;
public class Main {
 public static void main(String[] args) {
 Random random = new Random(); // ��������� �����
 Main mn = new Main(); 
 int rn = random.nextInt();
 for (int i = 0; i< 10; i++) {
	 rn = random.nextInt();
 System.out.println("\n�����: "+rn+"\n���������: " + mn.findTheBigesNum(rn));
 }
 }
 int findTheBigesNum(int num) {// ���������� ���������� �����
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
 
static int findCount(int num) { // ���������� ������� 
	 int count = 0;
	 while(num>0) {
		 num = num / 10;
		 count++;
	 }
	 
	 return count;
 }
}
