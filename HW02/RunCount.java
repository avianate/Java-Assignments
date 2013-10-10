// Nate Graham	A00305171



import java.util.Scanner;


public class RunCount extends DynamicArray {

	
	
	public RunCount () {}
	
	
	public int countRuns()
	{
		int runCounter = 1, currentNumber = 0;
		
		
		// loop through the array and increase count each time a non-repeat number is encountered
		for (int i = 0; i < getSize()-1; i++)
		{
			currentNumber = get(i);
			
			if (currentNumber != get(i+1))
			{
				runCounter++;
			}
		}
		
		return runCounter;
	}
	
	
// *************************************************************************
// *************************************************************************
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int numberOfTestCases = 0;

		RunCount myArray = new RunCount();

		Scanner input = new Scanner(System.in);

		// get number of test cases
//		System.out.println("Number of test cases: ");
		numberOfTestCases = input.nextInt();

		
		
		// loop for each test case
		for (; numberOfTestCases > 0; numberOfTestCases--)
		{
			// get size of test case and size the array
//			System.out.println("test case");
			int arraySize = input.nextInt();
			myArray.setTestArraySize(arraySize);
			
			for (int i = 0; i < arraySize; i++)
			{
				myArray.append(input.nextInt());
			}

			System.out.println(myArray.countRuns());
		}
		
	}

}
