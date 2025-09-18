package IT_Calculator;
import java.util.Scanner;

public class IT_Calculator {

	private double TaxableIncome;
	private double TaxPaidPerYear;
	private double TaxPayablePerMonth;

	
	public void calculateTax() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your Taxable Income: $");
		TaxableIncome = scanner.nextDouble();

		if (TaxableIncome <= 25000) {
			TaxPaidPerYear = 0;
		} else if (TaxableIncome <= 50000) {
			TaxPaidPerYear = TaxableIncome * 0.10;
		} else if (TaxableIncome <= 75000) {
			TaxPaidPerYear = TaxableIncome * 0.20;
		} else {
			TaxPaidPerYear = TaxableIncome * 0.30;
		}

		
		TaxPayablePerMonth = TaxPaidPerYear / 12;

		System.out.printf("Tax Paid Per Year: $%.2f\n", TaxPaidPerYear);
		System.out.printf("Tax Payable Per Month: $%.2f\n", TaxPayablePerMonth);
		scanner.close();
	}


	public static void main(String[] args) {

		IT_Calculator calculator = new IT_Calculator();
		calculator.calculateTax(); 
	}
}
