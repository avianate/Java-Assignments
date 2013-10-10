// Nate Graham	A00305171



import java.util.Scanner;


public class RBinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int numberOfTestCases;
		Scanner input = new Scanner(System.in);
		
		numberOfTestCases = input.nextInt();
		input.nextLine();
		
		// loop for each test case
		for (int i = 0; i < numberOfTestCases; i++)
		{
			RBinarySearch mySearch = new RBinarySearch();
			
			// get test case
			int numberOfDigitsInTestCase = input.nextInt();
			int digitToFind = input.nextInt();
			
			int data[] = new int[numberOfDigitsInTestCase];
			
			for (int j = 0; j < data.length; j++)
			{
				data[j] = input.nextInt();
			}
			
			
			boolean found = mySearch.isNumberInList(data, 0, digitToFind);
			
			System.out.println(found ? "Yes" : "No");
		}
	}

	private boolean isNumberInList(int[] data, int index, int digitToFind) {
		
		if (index < data.length)
		{
			if (data[index] == digitToFind)
			{
				return true;
			}
			else
				return isNumberInList(data, index+1, digitToFind);
		}
		
		return false;
	}

}
