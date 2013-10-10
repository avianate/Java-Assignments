// Nate Graham	A00305171


import java.util.Scanner;


public class SplitSum extends DynamicArray {
	
	public SplitSum() {};
	
	
	boolean splitArray()
	{
		int leftSide = get(0), rightSide = get(getSize()-1);
		
		
		// this loop will increment two counters, one to increment from the left-hand elements (increment)
		// and one to track from the right-hand elements (decrement)
		
		for (int leftSideCell = 0, rightSideCell = getSize()-1; leftSideCell < rightSideCell-1; )
		{	
			// the right side digit(s) < the left side digit(s); add the next right to compare
			if (leftSide > rightSide)
			{
				rightSide += get(rightSideCell-1);
				rightSideCell--;
			}
			
			// the left side digit(s) are <= to the right side digit(s); add the next left-side digit to compare
			else if (leftSide < rightSide || leftSide == rightSide)
			{
				leftSide += get(leftSideCell+1);
				leftSideCell++;
			}
		}
		
		
		
		if (leftSide == rightSide)
		{
			return true;
		}
		
		return false;
	}
	
	
// **************************************************************************
// **************************************************************************
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int numberOfTestCases = 0;

		SplitSum myArray = new SplitSum();

		Scanner input = new Scanner(System.in);

		// get number of test cases
//		System.out.println("Number of test cases: ");
		numberOfTestCases = input.nextInt();

		// loop for each test case
		for (; numberOfTestCases > 0; numberOfTestCases--)
		{
			// get size of test case
//			System.out.println("test case");
			int arraySize = input.nextInt();
			myArray.setTestArraySize(arraySize);
			
			for (int i = 0; i < arraySize; i++)
			{
				myArray.append(input.nextInt());
			}

			System.out.println(myArray.splitArray());
			
		}

		
	}

}
