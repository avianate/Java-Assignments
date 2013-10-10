// Nate Graham	A00305171


import java.util.Scanner;


public class MyQueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Queue testQueue = new MyQueue();

		Scanner input = new Scanner(System.in);

		// get number of test cases
		int numberOfTestCases = input.nextInt();

		for (int i = 0; i < numberOfTestCases; i++)
		{
			// get number of operations
			int numberOfOperations = input.nextInt();

			for (int j = 0; j < numberOfOperations; j++)
			{
				String enqueueOrDequeue = input.next();

				// enqueue or dequeue
				if (enqueueOrDequeue.equalsIgnoreCase("enq"))
				{
					testQueue.enqueue(input.nextInt());
				}

				else if (enqueueOrDequeue.equalsIgnoreCase("deq"))
				{
					testQueue.dequeue();
				}

				else
				{
					System.out.println("Invalid operation");

				}
			}

			// print results
			System.out.println(testQueue);

			((MyQueue) testQueue).clearQueue();
		
		}
	}

}

