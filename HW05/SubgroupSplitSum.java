// Nate Graham	A00305171



import java.util.ArrayList;
import java.util.Scanner;


public class SubgroupSplitSum {

	
	
	public static void main(String[] args) {

		int numberOfTestCases;

		Scanner input = new Scanner(System.in);

		numberOfTestCases = input.nextInt();

		// loop for each test case
		for (int testCase = 0; testCase < numberOfTestCases; testCase++)
		{
			SubgroupSplitSum mySplitSum = new SubgroupSplitSum();

			int sizeOfTestCase = input.nextInt();

			ArrayList<Integer> testArray = new ArrayList<Integer>(sizeOfTestCase);
			int sum = 0;

			for (int i = 0; i < sizeOfTestCase; i++)
			{
				testArray.add(input.nextInt());
				sum += testArray.get(i);
			}

			boolean found = false;
			boolean secondCheck = false;
			
			// if number is odd there is no partition
			if (sum % 2 == 0)
				found = mySplitSum.checkForSum(testArray, 0, sum/2, secondCheck);
			
			System.out.println(found ? "YES" : "NO");
		}

	}


	private boolean checkForSum(ArrayList<Integer> testArray, int index, int sum, boolean secondCheck)
	{

			// if end of array and sum is not found
			if (index == testArray.size())
			{
				return false;
			}


			int currentNumber = testArray.get(index);
//			System.out.println("Sum: " + sum + "\tcurrentNumber: " + currentNumber);

			if (currentNumber == sum)
			{
				testArray.remove(index);
				return true;
			}

			// if current number is greater than sum check next number *OR* if current number is less than sum,
			// subtract current number from sum and check next number
			else if (currentNumber > sum || !checkForSum(testArray, index+1, sum-currentNumber, secondCheck))
			{
				return checkForSum(testArray, index+1, sum, secondCheck);
			}
			
			testArray.remove(index);
			
			if (!secondCheck)
			{
//				System.out.println("\ntestArray: " + testArray);
				secondCheck = true;
				checkForSum(testArray, 0, sum, secondCheck);
			}

			return true;

	}

}
