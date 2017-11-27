import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.NoSuchElementException;
class DataReader {
		/* no data needed - this "object" is a procedure */
		public DataReader(String fileName)
		{
			try {
				String myWord;
				/* open the file and initialize a Scanner */
				File file = new File(fileName); 
				Scanner src = new Scanner(file).useDelimiter(",|\r\n|\n| |'|-|\\.|\\*|\\[|\\]|_|\\!|\\?|\\(|\\)|\"|[0..9]|\\!|;|3|:"); //we really threw the kitchen sink in as far as regex is concerned	
				
				HashMap<String,Integer> myHashMap = new HashMap();

				while(src.hasNext()) {
					myWord = src.next();
	
					if(myHashMap.get(myWord.toUpperCase()) == null) { //key does not exist in hashmap
						myHashMap.put(myWord.toUpperCase(),1); //add key with value of 1
					}
					
					else {
						int myValue = myHashMap.get(myWord.toUpperCase()); //key exists
						myHashMap.put(myWord.toUpperCase(), myValue+1); //add one to the value
					}		
				}

				TreeSort theMap = new TreeSort(myHashMap);
			}
			
			catch(FileNotFoundException ex)
			{
				System.err.println("File " + fileName + " not found");  // note use or err instead of out
			}
			catch(IOException ex)
			{
				System.err.println("File read format error");
			}
			catch(NoSuchElementException ex)
			{
				//this is so that if there is a blank line at the end of the file, the program will just treat it like its not there and move on without crashing
			}
		}
}

class TreeSort {
	public TreeSort(HashMap myHashMap) {
		TreeMap<String, Integer> myTreeMap = new TreeMap<String, Integer>();
		myTreeMap.putAll(myHashMap);
		int count = 0;
		
		for(HashMap.Entry<String,Integer> entry : myTreeMap.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			if(count != 0)
			{
				System.out.println(key + " " + value);	
			}
			count++;
			
		}
		//System.out.println(myTreeMap);
	}
}

class HashMapApp {
	public static void main(String[] args) {
		
		String fileName = "dataSets/lincoln2.txt";
		DataReader obj = new DataReader(fileName);
		
	}
}



