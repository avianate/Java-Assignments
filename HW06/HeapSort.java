// Nate Graham	A00305171	Running time is: O(n log n)



import java.util.Scanner;


public class HeapSort {

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
				testHeap.insert(input.nextInt());
			}

			testHeap.heapSort();
			System.out.println();

		}

	}
}
