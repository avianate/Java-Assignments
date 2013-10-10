// Nate Graham	A00305171


import java.util.Scanner;


public class ArrayMerge extends DynamicArray {



	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int numberOfTestCases;
		int sizeOfFirstLine, sizeOfSecondLine;
		int firstLine[], secondLine[];

		ArrayMerge myArray = new ArrayMerge();
		
		Scanner input = new Scanner(System.in);

		// get number of test cases
//		System.out.println("enter number of test cases: ");
		numberOfTestCases = input.nextInt();
		
		
		
		// loop for each test case
		
		for (int i = 0; i < numberOfTestCases; i++)
		{
			
			// get size of first line

//			System.out.println("enter first line: ");
			sizeOfFirstLine = input.nextInt();
			firstLine = new int[sizeOfFirstLine];


			// get first line of digits

			for (int j = 0; j < sizeOfFirstLine; j++)
			{
				firstLine[j] = input.nextInt();
			}



			// get size of second line

//			System.out.println("enter second line: ");
			sizeOfSecondLine = input.nextInt();
			secondLine = new int[sizeOfSecondLine];




			// get second line of digits

			for (int j = 0; j < sizeOfSecondLine; j++)
			{
				secondLine[j] = input.nextInt();
			}



			// merge the arrays:
			// based on example code at: http://stackoverflow.com/questions/5958169/how-to-merge-two-sorted-arrays-into-a-sorted-array
			
			// set testArray size to size of first line + second line
			myArray.setTestArraySize(firstLine.length + secondLine.length);
			
			// set up three counters, one for each array
			int firstLineElement = 0, secondLineElement = 0, mergedElement = 0;
			
			// merge the two arrays into testArray
			while (firstLineElement < firstLine.length && secondLineElement < secondLine.length)
			{
				if (firstLine[firstLineElement] < secondLine[secondLineElement])
				{
					myArray.testArray[mergedElement] = firstLine[firstLineElement];
					firstLineElement++;
				}
				
				else
				{
					myArray.testArray[mergedElement] = secondLine[secondLineElement];
					secondLineElement++;
				}
				
				mergedElement++;
			}
			
			while (firstLineElement < firstLine.length)
			{
				myArray.testArray[mergedElement] = firstLine[firstLineElement];
				firstLineElement++;
				mergedElement++;
			}
			
			while (secondLineElement < secondLine.length)
			{
				myArray.testArray[mergedElement] = secondLine[secondLineElement];
				secondLineElement++;
				mergedElement++;
			}
			
			System.out.println(myArray);
			myArray.clearArray();
		}

	}

}

