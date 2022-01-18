import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Avoid magic numbers by creating constants
		byte MONTHS_IN_YEAR = 12;
		byte PERCENT = 100;
		
		// Scanner object declared here and passed to all methods that require asking input from the user.
		Scanner scanner = new Scanner(System.in);
		NumberFormat mortgageFormat = NumberFormat.getCurrencyInstance();
		
		// Obtain principal, monthly interest rate, and number of payments
		int principal = getPrincipal(scanner);
		double monthlyInterestRate = (getAnnualInterestRate(scanner) / PERCENT) / MONTHS_IN_YEAR;
		int numOfPayments = getMortgagePeriod(scanner) * MONTHS_IN_YEAR;
		
		// Calculate mortgage and print the result
		double mortgage = principal * (monthlyInterestRate * Math.pow((1 + monthlyInterestRate), (double) numOfPayments)) /
				                      (Math.pow((1 + monthlyInterestRate), (double) numOfPayments) - 1);
		System.out.println("Mortgage: " + mortgageFormat.format(mortgage));
		
		scanner.close();
	}
	
	// Ask for the principal amount
	public static int getPrincipal(Scanner scanner) {
		int userPrincipal;
		
		// Loop while user principal amount does not meet criteria specified
		System.out.print("Principal ($1k - $1M): ");
		while((userPrincipal = scanner.nextInt()) < 1000 || userPrincipal > 1000000) {
			System.out.println("Enter a number between 1,000 and 1,000,000.");
			System.out.print("Principal ($1k - $1M): ");
		}
		return userPrincipal;
	}
	
	// Ask for the annual interest rate
	public static double getAnnualInterestRate(Scanner scanner) {
		double userAnnInterestRate;
		
		// Loop while user annual interest rate does not meet criteria specified
		System.out.print("Annual Interest Rate: ");
		while((userAnnInterestRate = scanner.nextDouble()) < 0.0 && userAnnInterestRate > 30.0); {
			System.out.println("Enter a value greater than 0 and less than or equal to 30");
			System.out.print("Annual Interest Rate: ");
		}
		return userAnnInterestRate;
	}
	
	// Ask for the mortgage period
	public static int getMortgagePeriod(Scanner scanner) {
		int userPeriod;
		
		// Loop while user period amount does not meet criteria specified
		System.out.print("Period (Years): ");
		while((userPeriod = scanner.nextInt()) < 1 || userPeriod > 30) {
			System.out.println("Enter a value between 1 and 30.");
			System.out.print("Period (Years): ");
		}
		
		return userPeriod;
	}

}