package wc1;

import java.io.*;
import java.util.*;

public class Count {
 	 
	
	
	private static final char[] chars = null;
	private static final char[] words = null;
	private static final char[] lines = null;

	public static void CountAll(String sc,String sc2){	 
     BufferedReader reader = null;
	try {
		reader = new BufferedReader(new FileReader(new File(sc2)));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
     String word = null;
     int lines = 0, words = 0, chars = 0, blanklines = 0, notelines = 0, codelines = 0;
     boolean flag = true;
     try {
		   while((word = reader.readLine()) != null)
			 {   if(flag)
			       {   if(word.length() < 1)
			               blanklines++; 
			           else if(word.startsWith("//"))
			               notelines++;
			           else if(word.startsWith("/*") && word.endsWith("*/"))
			               notelines++;
			           else if(word.startsWith("/*") && !word.endsWith("*/"))
			              {   notelines++;
			                  flag = false;
			              }
			           else codelines++;
			        }
			 	  else if(!word.startsWith("/*") && word.endsWith("*/"))
			 	    {   notelines++;
                        flag = true;
                     }
			 	  else notelines++;	     
			      words = words + word.split("[ \\,?.]").length;
			      chars = chars + word.length();  			     
			      lines++;
			 } 
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
     try {
		reader.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     switch (sc)
	    {   case "-c": System.out.println("字符数为：" + chars); break;
	        case "-s": System.out.println("词数为：" + words); break;
	        case "-l": System.out.println("行数为：" + lines); break;
	        case "-a": System.out.println("代码行数为：" + codelines + "\n" + "空行数为：" + blanklines + "\n" + "注释行数为：" + notelines); break;
	    }
    }
	
public static void main(String[] args) throws IOException {
	 Scanner sc = new Scanner(System.in); 
	 String a = sc.nextLine();
	 String[] b = a.split(" ");
	 System.out.println(b[0]+" "+b[1]);
	 CountAll(b[0],b[1]);
}
}