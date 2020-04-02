import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.io.IOException;

public class DuplicateRemover {
	
	private Set<String> uniqueWords; //creates set of strings
	
	void remove(String dataFile) {
		try {
			//declare variables
			Scanner file = new Scanner(new File(dataFile));
			uniqueWords = new HashSet<String>();
			String word;
			
			//eliminates duplicate words
			while (file.hasNext()) {
				word = file.next();
				uniqueWords.add(word);
			}
			file.close(); //close scanner
		}
		
		catch(FileNotFoundException notFound) {
			System.out.println("Sorry, your file: " + dataFile + ", could not be found.");
			System.exit(1); //terminates program
		}
	}
	
	void write(String outputFile) {
		//declare variables
		FileWriter fWriter = null;
		File file = new File(outputFile);
		
		try {
			//write words from set
			if(file.exists()) {
				fWriter = new FileWriter(file, false);
				Iterator<String> it = uniqueWords.iterator();
				while (it.hasNext()) {
					String string = (String) it.next();
					fWriter.write(string + "\n");
				}
				fWriter.close();
				System.out.println("Your data has been written.");
			}
			else {
				file.createNewFile();
				fWriter = new FileWriter(file);
				Iterator<String> it = uniqueWords.iterator();
				while(it.hasNext()) {
					String string = (String) it.next();
					fWriter.write(string + "\n");
				}
				fWriter.close(); //close file writer
				System.out.println("Your data has been written.");
			}
		}
		catch(IOException exception) {
			System.out.println("Sorry, there was an error while trying to write to: " + outputFile);
			System.exit(1); //terminates program
		}
	}
}
