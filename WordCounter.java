

/*Name - Pragnyasree Tangutoori,Venkata Naga Varsha Kota,Zachery Charbonneau
  Assignment  - Count the frequency of words in a file
  Lab - 5
  description of program -
  When the Java program starts, it analyzes the specified text file. It constructs a summary report regarding 
  each word that occurs in the file and the number of times that word occurs,sorted from most frequently occurring
  word to least frequently occurring.
*/

import java.util.*; 
import java.io.*; 

public class WordCounter
{
	public static void main(String args[])throws IOException
	{
		System.out.println("Enter the file name: ");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.nextLine();
		System.out.println("filename:"+fileName);
	    File source_file = new File(fileName);
	    
	    /* If the file exists,we analyze that file and 
	       display the unique words in file with their frequencies
	       (highest to lowest)*/
	    
	    if( source_file.exists())
	     {
		   System.out.println("The file exists.");
		   WordFrequencyAnalyzer analyzer= new WordFrequencyAnalyzer ();
		   analyzer.analyzeText(source_file);
		   WordFrequencyCollection coll = analyzer.getResults();
		   Iterator<String> iterator = coll.iterator(); 
		   
		   while (iterator.hasNext())
			{
				System.out.println(iterator.next());
			} 
		 }
	    
	    /* If the file does not exist,it displays a message */
	    else
	     {
		   System.out.println("The file doesnt exists."); 
		 }
	    scan.close();
	}
}
