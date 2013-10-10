// Nate Graham	A00305171


import java.util.Scanner;


public class SumDigits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int numberOfTestCases;
		
		Scanner input = new Scanner(System.in);
		
		// loop for each test case
		numberOfTestCases = input.nextInt();
		input.nextLine();
		
		for (int i = 0; i < numberOfTestCases; i++)
		{
			SumDigits mySum = new SumDigits();
			
			// get line
			String data = new String(input.nextLine());
			
			// add numbers recursively
			System.out.println(mySum.addDigits(Long.parseLong(data)));
			
		}

	}

	private long addDigits(long data) {
				
		
		if (data > 0)
		{
			return (data % 10) + addDigits(data / 10);
		}
		
		return 0;
	}
}
