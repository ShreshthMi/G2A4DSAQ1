package Q1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// TODO Auto-generated method stub
		new MainActivity(s);
		boolean exit = false;
		do {
			s = new Scanner(System.in);
			System.out.println("Enter Y or Yes to do again, any other input to exit");
			String input = s.next();

			if (input.equalsIgnoreCase("y") || (input.equalsIgnoreCase("Yes"))) {
				new MainActivity(s);
			} else
				exit = true;

		} while (exit == false);
		s.close();
	}
}