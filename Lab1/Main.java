package ua.khpi.oop.bilyi01;

public class Main  {
	

	public static void main(String[] args) {
		
		Main mn = new Main();
		int num_of_s = 0x141D12; // ����� ����.
		long num_of_telephone = 38095248954L; // ���. �������
		int num_of_2_last_num = 0b110110; // ��������� ����� (2)
		int num_of_4_last_num = 021372; // ��������� �����	(4) 
		int num = 3; // ����� �� ������
		char ch = 64+3; // 3 ������ 
		mn.oddAndEven(num_of_s);
		mn.oddAndEven(num_of_telephone);
		mn.oddAndEven(num_of_2_last_num);
		mn.oddAndEven(num_of_4_last_num);
		mn.oddAndEven(num);
		mn.oddAndEven((int)ch);
		mn.countOnes(num_of_s);
		mn.countOnes(num_of_telephone);
		mn.countOnes(num_of_2_last_num);
		mn.countOnes(num_of_4_last_num);
		mn.countOnes(num);
		mn.countOnes((int)ch);
	}
	
	void oddAndEven(long i) { // ������� ���������� ������ � �� ������ ����
		var l = i;
		long n = 0;
		long p = 0;
		long np = 0; 
		while(i>0) { 
			n=i%10;
			i=i/10;
			if(n%2==1) 
				np++;
			else
				p++;
			
		}
		System.out.println(l+"\n"+Integer.toBinaryString((int)l));
		System.out.println(String.format("���������� ������: %s\n���������� ��������: %s", p , np));
		return ;
	}
	
	void countOnes(long i) { // ������� ������ ������ � �������� ������������� �����
	    long n = i;
		int count=0;	
		while(i!=0) {
			if(i%2==1) {
				count++;
			}
			i/=2;
		}
		System.out.println(n+"\n"+Integer.toBinaryString((int)n));
		System.out.println("���������� ������: " + count);
		}
}

