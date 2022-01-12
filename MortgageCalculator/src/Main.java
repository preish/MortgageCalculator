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
		System.out.print("Principal: ");
		int userPrincipal = scanner.nextInt();
		
		return userPrincipal;
	}
	
	// Ask for the annual interest rate
	public static double getAnnualInterestRate(Scanner scanner) {
		System.out.print("Annual Interest Rate: ");
		double userAnnInterestRate = scanner.nextDouble();
		
		return userAnnInterestRate;
	}
	
	// Ask for the mortgage period
	public static int getMortgagePeriod(Scanner scanner) {
		System.out.print("Period (Years): ");
		int userPeriod = scanner.nextInt();
		
		return userPeriod;
	}

}
