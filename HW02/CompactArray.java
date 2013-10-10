// Nate Graham	A00305171



import java.util.Arrays;
import java.util.Scanner;


public class CompactArray extends DynamicArray {	

	int compactArray[];
	int compactCount = 0;
	static int EMPTY = -1;
	
	public CompactArray() {};
	
	private void initializeCompactArray(int size)
	{
		compactArray = new int[size];
		Arrays.fill(compactArray, EMPTY);
	}
	
	
	private void compactArray(int binaryDigit, int index)
	{
		// if binaryDigit is 1 place testArray[index] into compactArray;
		if (binaryDigit == 1)
		{
			compactArray[compactCount] = get(index);
			compactCount++;
		}
		
		// copy compacted result back into testArray 
		if (index == getSize()-1)
		{
			clearArray();
			System.arraycopy(compactArray, 0, testArray, 0, compactCount);
			compactCount = 0;
		}
		
	}
	

	
// *********************************************************************************
// *********************************************************************************
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int numberOfTestCases = 0;


		CompactArray myArray = new CompactArray();

		Scanner input = new Scanner(System.in);

		// get number of test cases
//		System.out.println("Number of test cases: ");
		numberOfTestCases = input.nextInt();

		
		// loop for each test case
		for (; numberOfTestCases > 0; numberOfTestCases--)
		{
			// get size of test case
//			System.out.println("enter size of test case: ");
			int arraySize = input.nextInt();
			myArray.setTestArraySize(arraySize);
			myArray.initializeCompactArray(arraySize);
		
			
			
			// get first line of test case
//			System.out.println("enter 1st line of test case: ");
			
			for (int i = 0; i < arraySize; i++)
			{
				myArray.append(input.nextInt());
			}

			
			// get second line of test case and compact the array
//			System.out.println("enter compact case: ");
			
			for (int i = 0; i < myArray.getSize(); i++)
			{
				int nextDigit = input.nextInt();
				
				myArray.compactArray(nextDigit, i);
			}
			
			System.out.println(myArray);
			myArray.clearArray();
		}

	}

}
