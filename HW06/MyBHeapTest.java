// Nate Graham	A00305171



import java.util.Scanner;


public class MyBHeapTest extends MyBHeap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int numberOfTestCases = input.nextInt();

		// loop for each test case
		for (int testCase = 0; testCase < numberOfTestCases; testCase++)
		{
			int numberOfOperations = input.nextInt();

			BHeap testHeap = new MyBHeap(numberOfOperations);

			for (int test = 0; test < numberOfOperations; test++)
			{
				String insertOrRemove = input.next();
				
				if (insertOrRemove.equalsIgnoreCase("i"))
					testHeap.insert(input.nextInt());
				else if (insertOrRemove.equalsIgnoreCase("r"))
					testHeap.remove();
				else
					System.out.println("Invalid Operation");
			}

			testHeap.display();
			System.out.println();

		}

	}

}
