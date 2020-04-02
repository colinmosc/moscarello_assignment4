
public class Application {

	public static void main(String[] args) {
		DuplicateCounter dupC = new DuplicateCounter();
		dupC.count("problem2.txt");
		dupC.write("unique_word_counts.txt");
	}

}
