import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;

public class DuplicateCounter {
	
	//declare variables
	private Integer wordCounter;
	private Map<String, Integer> map;
	
	//constructor
	public DuplicateCounter() {
		this.wordCounter = 0;
		this.map = new HashMap<>();
	}
	
	void count(String dataFile) {
		try {
			Scanner file = new Scanner(new File(dataFile)); //declare scanner
			
			//counts how many times each word is found
			while (file.hasNextLine()) {
				String line = file.nextLine().trim();
				String[] data = line.split("[\n]+");
				for (String word : data) {
					this.wordCounter = map.get(word);
					this.wordCounter = (this.wordCounter == null) ? 1 : ++this.wordCounter;
					map.put(word, this.wordCounter);
				}
			}
			file.close(); //close scanner
		}
		
		catch (FileNotFoundException notFound) {
			System.out.println("Sorry, your file: " + dataFile + ", could not be found.");
			System.exit(1); //terminates program
		}
	}
	
	void write(String outputFile) {
		//declare variables
		FileWriter fWriter;
		File file = new File(outputFile);
		PrintWriter pWriter;
		
		try {
			//writes the contents of wordCounter
			if (file.exists()) {
				fWriter = new FileWriter(file, false);
				pWriter = new PrintWriter(fWriter);
				for (Map.Entry<String, Integer> entry : map.entrySet()) {
					if (entry.getValue() == 1) {
						pWriter.write("The word " + entry.getKey() + " occurs " + entry.getValue() + " time.\n");
					}
					else {
						pWriter.write("The word " + entry.getKey() + " occurs " + entry.getValue() + " times.\n");
					}
				}
				System.out.println("Your data has been written.");
				//close everything
				fWriter.close();
				pWriter.flush();
				pWriter.close();
			}
			
			else {
				file.createNewFile();
				fWriter = new FileWriter(new File(outputFile));
				pWriter = new PrintWriter(fWriter);
				for(Map.Entry<String, Integer> entry : map.entrySet()) {
					if (entry.getValue() == 1) {
						pWriter.write("The word " + entry.getKey() + " occurs " + entry.getValue() + " time.\n");
					}
					else {
						pWriter.write("The word " + entry.getKey() + " occurs " + entry.getValue() + " times.\n");
					}
				}
				System.out.println("Your data has been written.");
				//close everything
				fWriter.close();
				pWriter.flush();
				pWriter.close();
			}
		}
		
		catch (IOException exception){
			System.out.println("Sorry, there was an error while trying to write to: " + outputFile);
			System.exit(1); //terminates program
		}
	}
}
