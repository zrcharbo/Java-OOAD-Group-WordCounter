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

public class WordFrequencyCollection implements Iterable<String>
{
	Map<String, Integer> word_frequency;
	
	//constructor
	public WordFrequencyCollection()
	{
		word_frequency= new HashMap<String, Integer>();
	}

	
	/*This method is used to add word to hashmap.If the does not exist,it is 
	   added to map.If it is already existing,then it replaces its value.*/
	public void addWord(String word)
	{
		if(!word_frequency.containsKey(word))
		{
            word_frequency.put(word,1);
		}
        else 
        {    // Increment existing count by 1.
            int count = getFrequency(word)+ 1;
            word_frequency.put(word,count);
        }
    }

	
	//This method returns the frequency of any word
	public int getFrequency(String word)
	{
		return word_frequency.get(word);
	}
	
	/*In this method,we sort the values in hashmap and place them in a list.
	  Words and their frequencies are sorted in the order of frequencies,with
	  highest frequency first.If two words have same frequency,then words are 
	  sorted with respect to their ASCII values.
	 */
	public Iterator<String> iterator()
	{
	   List<Map.Entry<String, Integer>> entries = 
			   new LinkedList<Map.Entry<String, Integer>>(word_frequency.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() 
        {
              public int compare(Map.Entry<String, Integer> ent1, Map.Entry<String, Integer> ent2)
                {
                     return (ent1.getValue() == ent2.getValue())
                      ?  ent1.getKey().compareTo(ent2.getKey()):
                    		  ent2.getValue().compareTo(ent1.getValue());
                }
         });
       
        /*we create a new collection where words and their frequencies
          from the previous list(entries) are stored into a new 
          collection(wordIterator)in the form of word:frequency*/
        Collection<String> wordIterator = new ArrayList<String>();
 	   
 	    for (Map.Entry<String, Integer> entry : entries)
          {
            String word = entry.getKey()+":	"+getFrequency(entry.getKey());
     	    wordIterator.add(word);
          }
 	
        return wordIterator.iterator();
	}
}


	


