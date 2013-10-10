// Nate Graham	A00305171	Running time: O(log n)



import java.util.Scanner;


public class TreeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		int numberOfTestCases = input.nextInt();

		// loop for each test case
		for (int testCase = 0; testCase < numberOfTestCases; testCase++)
		{
			BSTree testTree = new MyBSTree(false);
			
			int numberOfOperations = input.nextInt();

			for (int test = 0; test < numberOfOperations; test++)
			{
				testTree.insert(input.nextInt());
			}
			
			testTree.inorderTraversal();
			System.out.println();

		}


	}

}
