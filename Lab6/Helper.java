package ua.khpi.oop.bilyi06;

public class Helper {

 
 private static int mean = 0;
 	public static void start(String ln) {
		if(ln == null) {
			throw new NullPointerException("line is null");
		}
		ln = clottingSpace(new StringBuilder(ln));
		MyCollection line = findArray(ln);
		
		findmean(line);
		if(getMean() == 0) {
			throw new NullPointerException("Line have`t element or size of line element is zero");
		}
		printline(line);
	}

 	static private MyCollection findArray(String ln){
 		MyCollection line = new MyCollection();
 		StringBuilder strB = new StringBuilder();
 		for(int i = 0; i < ln.length();i++ ) {
 			
 			if(ln.charAt(i)==' ') {
 				line.add(strB.toString());
 				strB = new StringBuilder();
 			}
 			else 
 				strB.append(ln.charAt(i));
 		}
 		line.add(strB.toString());
 		
 		
// 		ArrayList<Integer> IndexSpace = new ArrayList<Integer>();
// 		int length = ln.length();
// 		for (int i = 0; i<length;i++) {
// 			if(ln.charAt(i)==' ')
// 			IndexSpace.add(i);
// 		}
// 		if(IndexSpace.size() == 0) {
// 			line.add(new String(ln));
// 		}
// 		else 
// 		{
// 		line.add(new String(ln.substring(0, IndexSpace.get(0))));
// 		IndexSpace.add(length);
// 		for(int i=1;i<IndexSpace.size();i++) {
// 			
// 			if(ln.substring(IndexSpace.get(i-1)+1, IndexSpace.get(i))!="")
// 			line.add(new String(ln.substring(IndexSpace.get(i-1)+1, IndexSpace.get(i))));
// 	 		}
// 		}
 		return line;
 	}
 	
 	
	static private void findmean(MyCollection line) {
		int m = 0;
		for(int i =0;i<line.size();i++)
		m+=line.get(i).length();
		setMean(m/line.size());
		return;
	}
		
	
	
	static private String clottingSpace(StringBuilder line) {
		
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
		return line.toString();
	}
	
	
	static private void printline(MyCollection line) {
		
		System.out.println("Lines are greater than average: ");
		for(var n : line) {
			if(n.length() >= mean) {
				System.out.println(n+"\nLine lenght:" + n.length());
				
			}
		}
		System.out.println("Lines less than average: ");
		for(var n : line) {
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
