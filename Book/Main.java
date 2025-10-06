import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Book book = new Book(in.next());
		
		processBook(book);

		in.close();

	}

	private static void processBook(Book b) {
		if (b.isValidControlDigit()) {
			System.out.println("OK");
		} else {
			int x = b.getControlDigit();
			System.out.println("ERRO " + x);
		}

	}
	

}
