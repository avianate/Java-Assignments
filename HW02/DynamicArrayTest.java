// Nate Graham	A00305171


import java.util.Scanner;


public class DynamicArrayTest extends DynamicArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

int numberOfTestCases = 0;
		
		DynamicArrayTest myArray = new DynamicArrayTest();
		
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
			
			// run test case
			for (int i = 0; i < arraySize; i++)
			{
				String appendOrDelete = input.next();
				
				if (appendOrDelete.equalsIgnoreCase("a"))
				{
					myArray.append(input.nextInt());
				}
				
				else if (appendOrDelete.equalsIgnoreCase("d"))
				{
					myArray.remove(input.nextInt());
				}
			}	// end of this test case
			
			System.out.println(myArray);
			
		}  // end of all test cases
		
	}	// end main()

}
