// Nate Graham	A00305171


import java.util.Scanner;


public class Count {



	static int numberOfDigitsInTestCase;

	int digitToFind;
	static int index;
	static int count;
	int secondLine[] = null;

	public static void main(String[] args) {

		int numberOfTestCases;

		Scanner input = new Scanner(System.in);

		
		// get number of test cases
		numberOfTestCases = input.nextInt();

		// for each test case
		for (int i = 0; i < numberOfTestCases; i++)
		{
			Count myCount = new Count();

			// get test case
			Count.numberOfDigitsInTestCase = input.nextInt();
			myCount.digitToFind = input.nextInt();

			input.nextLine();

			String stringLine[] = input.nextLine().split(" ");


			// set size of secondLine[] and load it into the array
			myCount.secondLine = new int[numberOfDigitsInTestCase];

			for (int j = 0; j < numberOfDigitsInTestCase; j++)
			{
				myCount.secondLine[j] = Integer.parseInt(stringLine[j]);
			}


			// perform the operation and display result
			System.out.println(myCount.findDigits(index));
		}
	}



	private int findDigits(int index)
	{
		if (index < numberOfDigitsInTestCase)
		{
			if (secondLine[index] == digitToFind)
			{
				return 1 + findDigits(index+1);
			}
			else
			{
				return findDigits(index+1);
			}
		}
		return 0;
	}
}