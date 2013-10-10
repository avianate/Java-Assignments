// Nate Graham	A00305171


import java.util.Scanner;


public class MyStackTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Stack testStack = new MyStack();

		Scanner input = new Scanner(System.in);

		// get number of test cases
		int numberOfTestCases = input.nextInt();

		for (int i = 0; i < numberOfTestCases; i++)
		{
			// get number of operations
			int numberOfOperations = input.nextInt();

			for (int j = 0; j < numberOfOperations; j++)
			{
				String pushOrPop = input.next();

				// push or pop
				if (pushOrPop.equalsIgnoreCase("push"))
				{
					testStack.push(input.nextInt());
				}

				else if (pushOrPop.equalsIgnoreCase("pop"))
				{
					testStack.pop();
				}

				else
				{
					System.out.println("Invalid operation");

				}
			}

			// print results
			System.out.println(testStack);

			((MyStack) testStack).clearStack();

		}
		
	}

}
