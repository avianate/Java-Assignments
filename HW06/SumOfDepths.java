// Nate Graham	A00305171



import java.util.Scanner;


public class SumOfDepths  {

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
				String insertOrRemove = input.next();

				if (insertOrRemove.equalsIgnoreCase("i"))
					testTree.insert(input.nextInt());
				else if (insertOrRemove.equalsIgnoreCase("r"))
					testTree.remove(input.nextInt());
				else
					System.out.println("Invalid Operation");
			}


			System.out.println(testTree.sumDepth());

		}


	}

}
