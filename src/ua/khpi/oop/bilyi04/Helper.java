package ua.khpi.oop.bilyi04;
import java.util.ArrayList;


 public class Helper {

 
 private static int mean = 0;
 static ArrayList<StringBuilder> line = new ArrayList<StringBuilder>() ;
 static private void findmean(ArrayList<StringBuilder> line) {
		int m = 0;
		for(int i =0;i<line.size();i++)
		m+=line.get(i).length();
		setMean(m/line.size());
		if(debag)
			System.out.println("Mean: " + mean);
		return;
	}
private static boolean debag = false;
       public static void debagMod(boolean debagMod) {
        	debag = debagMod;
        	System.out.printf("Debag mod ");
        	if (debag) {
        		System.out.printf("on\n");
        	}else
        	{
        		System.out.printf("off\n");
        	}
        }
 	public static void start(StringBuilder ln) {
 		
 		if(debag) {
 			System.out.println("Start line: " + ln);
 		};
 		
		if(ln==null||ln.length()==0) {
			System.out.println("Line is empty");
			return;
		}
		
		clottingSpace(ln);
		line = findArray(ln);
		findmean(line);
		if(getMean() == 0) {
			throw new NullPointerException("Line have`t element or size of line element is zero");
		}
		
	}

 	static private ArrayList<StringBuilder> findArray(StringBuilder ln){
 		ArrayList<StringBuilder> line = new ArrayList<StringBuilder>();
 		ArrayList<Integer> IndexSpace = new ArrayList<Integer>();
 		int length = ln.length();
 		for (int i = 0; i<length;i++) {
 			if(ln.charAt(i)==' ')
 			IndexSpace.add(i);
 		}
 		if(IndexSpace.size() == 0) {
 			line.add(new StringBuilder(ln));
 		}
 		else 
 		{
 		line.add(new StringBuilder(ln.substring(0, IndexSpace.get(0))));
 		IndexSpace.add(length);
 		for(int i=1;i<IndexSpace.size();i++) {
 			
 			if(ln.substring(IndexSpace.get(i-1)+1, IndexSpace.get(i))!="")
 			line.add(new StringBuilder(ln.substring(IndexSpace.get(i-1)+1, IndexSpace.get(i))));
 	 	}
 		}
 		return line;
 	}
 	
 	
	
	
	
	static private StringBuilder clottingSpace(StringBuilder line) {
		
		for(int i = 0; i< line.length()-1;i++)
		{ 
			if(line.charAt(i)==' '&&line.charAt(i+1)==' ') {
				line.deleteCharAt(i+1);
				i--;
			}
		}
		if(line.charAt(line.length()-1)==' ')
			line.deleteCharAt(line.length()-1);
		if(line.charAt(0)==' ')
			line.deleteCharAt(0);
		if(debag)
		System.out.println("Line after clotting space: " + line);
		return line;
	}
	
	
	static public void printline() {	
		if(line.isEmpty()) {
			System.out.println("Line is empty");
			return;
		}
		if(debag)
			System.out.println("Count line: " + line.size());
		System.out.println("Lines are greater than average: ");
		for(StringBuilder n : line) {
			if(n.length() >= mean) {
				System.out.println(n+"\nLine lenght:" + n.length());
			}
		}
		System.out.println("Lines less than average: ");
		for(StringBuilder n : line) {
			if(n.length() < mean) {
				System.out.println(n +"\nLine lenght:" + n.length());
				}
		}
	}
	
	
	public static int getMean() {
		return mean;
	}
	public static void setMean(int mean) {
		Helper.mean = mean;
	}
	
	
	
}
