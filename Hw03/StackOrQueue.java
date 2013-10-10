// Nate Graham	A00305171


import java.util.Scanner;



public class StackOrQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int numberOfTestCases = input.nextInt();

		
		// loop for each test case
		for (int i = 0; i < numberOfTestCases; i++)
		{
			Stack testStack = new MyStack();
			Queue testQueue = new MyQueue();
			
			boolean isStack = true;
			boolean isQueue = true;
			
			int numberOfOperations = input.nextInt();

			// loop for each operation
			for (int j = 0; j < numberOfOperations; j++)
			{
				String nextOperation = input.next();

				if (nextOperation.equalsIgnoreCase("add"))
				{
					int numberToAdd = input.nextInt();
					
					testStack.push(numberToAdd);
					testQueue.enqueue(numberToAdd);
				}
				else if (nextOperation.equalsIgnoreCase("rem"))
				{
					int numberToCompare = input.nextInt();

					if (testStack.pop() != numberToCompare)
					{
						isStack = false;
					}
					
					if (testQueue.dequeue() != numberToCompare)
					{
						isQueue = false;
					}
				}
				else
				{
					System.out.println("Invalid operation");
				}
			}	// end this test case
			
			// print results
			if (isStack && !isQueue)
			{
				System.out.println("STACK");
			}
			else if (!isStack && isQueue)
			{
				System.out.println("QUEUE");
			}
			else
			{
				System.out.println("UNKNOWN");
			}


		} // end of all test cases

	}

}
