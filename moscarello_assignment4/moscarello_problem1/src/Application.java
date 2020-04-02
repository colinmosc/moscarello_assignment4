
public class Application {

	public static void main(String[] args) {
		DuplicateRemover dupRem = new DuplicateRemover(); //creates instance of duplicate remover
		dupRem.remove("problem1.txt");
		dupRem.write("uniqueWords.txt");
	}

}
