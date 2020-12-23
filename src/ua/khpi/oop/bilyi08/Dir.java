package ua.khpi.oop.bilyi08;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;


public class Dir {
	
	public static String directoryForDownload() {
		
		Scanner scan = new Scanner(System.in);
		String path = new String("C:\\Users\\Acer\\eclipse-workspace\\bilyi vadim");
		File dir = new File(path);
		
		String choose = new String();
		do {
			String [] list = dir.list(new FilenameFilter() {
				
				@Override
				public boolean accept(File f, String name)
				  {

				    
				      if(new File(f, name).isDirectory()) 
				    	  return true;
				    else
				      return(name.endsWith("xml"));  
				  
				}
			});
			System.out.println();
		for(String temp : list) {
			System.out.println(temp);
		}
		System.out.println();
		System.out.println("Choose: ");
		choose = scan.nextLine();
		if (choose.equals("quit"))
			break;
		if (choose.equals("..."))
		{
			path = path.substring(0,path.lastIndexOf('\\'));
			  dir = new File(path);
			  continue;
		}
		path = path.concat("\\"+choose);
		dir = new File(path);
		if(!dir.exists())
		{
		  System.out.println("\nNot found: " + choose);
		  path = path.substring(0,path.length()-(choose.length()+1));
		  dir = new File(path);
		  continue;
		}
		
		if(dir.isFile())
		{
		
		
		 return path;
		}
		
		
		}while(true);

		
		return new String("DONTDOWNLOAD");
	}

	public Dir() {
		super();
		// TODO Auto-generated constructor stub
	};
	
	
	
	
}




