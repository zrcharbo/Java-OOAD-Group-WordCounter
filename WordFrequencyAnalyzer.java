/*Name - Pragnyasree Tangutoori,Venkata Naga Varsha Kota,Zachery Charbonneau
  Assignment  - Count the frequency of words in a file
  Lab - 5
  description of program -
  When the Java program starts, it analyzes the specified text file. It constructs a summary report regarding 
  each word that occurs in the file and the number of times that word occurs,sorted from most frequently occurring
  word to least frequently occurring.
*/
import java.io.*;
import java.util.*;

public class WordFrequencyAnalyzer
{
    int totalWords = 0;
    private WordFrequencyCollection collection; 
    
    
    //constructor
    public WordFrequencyAnalyzer()
    {
    	collection = new WordFrequencyCollection();
    } 
    
    /*This method takes file as input,and finds the words in the file.
      The delimiters are java white space characters
      We ignore punctuations*/
    
	public void analyzeText(File source_file)throws IOException
	{
    Scanner wordScanner = new Scanner(source_file);
    wordScanner.useDelimiter("[\b\n\r\t\\%%' '*.\"?,']+");
 
    /*Once a word is identified,it is passed as input to addWord method
     of WordFrequencyCollection class where the word is added to map*/
    while (wordScanner.hasNext()) 
    {
        String word = wordScanner.next();
        collection.addWord(word);
        totalWords++;
    }    
    wordScanner.close();
	}
	
	//This method is used to return the object of WordFrequencyCollection class
	public WordFrequencyCollection getResults()
	{
		    return collection;
	}
}
