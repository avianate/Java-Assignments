// Nate Graham	A00305171



import java.util.Scanner;


public class SubgroupSum {


	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int numberOfTestCases = input.nextInt();

		for (int i = 0; i < numberOfTestCases; i++)
		{
			SubgroupSum mySubSum = new SubgroupSum();

			int sizeOfTestCase = input.nextInt();
			int sumToFind = input.nextInt();

			int testArray[] = new int[sizeOfTestCase];

			for (int index = 0; index < testArray.length; index++)
			{
				testArray[index] = input.nextInt();
			}
			
			int startIndex = 0;

			boolean found = mySubSum.checkForSum(testArray, startIndex, sumToFind);
			
			System.out.println(found ? "Yes" : "No");

		}
	}
	
	// recursive function based on code examples from http://stackoverflow.com/questions/7774769/how-do-i-solve-the-classic-knapsack-algorithm-recursively 
	private boolean checkForSum(int[] testArray, int index, int sumToFind)
	{
		// if end of array and sum is not found
		if (index == testArray.length){
			return false;
		}
		
		
		int currentNumber = testArray[index];
		
		if (currentNumber == sumToFind)
		{
			return true;
		}
		
		// if current number is greater than sum check next number *OR* if current number is less than sum,
		// subtract current number from sum and check next number
		else if (currentNumber > sumToFind || !checkForSum(testArray,index+1,sumToFind-currentNumber))
		{
			return checkForSum(testArray,index+1,sumToFind);
		}
		
		return true;
	}
}
