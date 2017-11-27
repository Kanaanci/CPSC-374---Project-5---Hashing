//Kanaan Irwin and Lilly Reynolds
///Used sample code from classes for assistance
import java.util.*;
import java.io.*;

class hashThings{
	public hashThings(){
		try{
			String holdMe;
			int holdMeVal;
			String fileName = "dataSets/alice.txt"; //setting file
			HashMap<String,Integer> hashMapYo = new HashMap(); //making the hashmap
			
			File file = new File(fileName); //opens file and scanner with the delimiters
			Scanner scann = new Scanner(file).useDelimiter(",|\r\n|\n| |'|-|\\.|\\*|\\[|\\]|_|\\!|\\?|\\(|\\)|\"|[0..9]|\\!|;|3|:");
			
			while(scann.hasNext()){ //scanning through
				holdMe = scann.next();
				
				if(hashMapYo.get(holdMe.toUpperCase()) == null){ //if not in
					hashMapYo.put(holdMe.toUpperCase(),1); //put in with value of 1
				} //if
				else{
					holdMeVal = hashMapYo.get(holdMe.toUpperCase()); //it's in there
					hashMapYo.put(holdMe.toUpperCase(),holdMeVal +  1); //increment value
				} //else
			} //while
			
			treeThings map = new treeThings(hashMapYo);
			//System.out.println(hashMapYo);
			
		} //try
		catch(FileNotFoundException e){
			System.err.println("File not found yo");
		} //catch
		catch(IOException e){
			System.err.println("IO probs yo");
		}
	} //method hashThings
} //class

class treeThings{
	public treeThings(HashMap hashMapYo){
		int counterYo = 0;
		String it; 
		int val;
		TreeMap<String, Integer> treeMapYo = new TreeMap<String, Integer>(); //making tree map
		treeMapYo.putAll(hashMapYo); //putting everything in
		
		for(HashMap.Entry<String, Integer> thing : treeMapYo.entrySet()){
			it = thing.getKey();
			val = thing.getValue();
			
			if(counterYo != 0){
				System.out.println(it + "-" + val);
			}//if
			counterYo++;
		}//for
		//System.out.println(treeMapYo);
	}//method
}//class

class Main{
	public static void main(String[] args){
		hashThings obj = new hashThings();
		
	}
}