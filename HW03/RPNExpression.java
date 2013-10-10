// Nate Graham	A00305171


import java.util.Scanner;


public class RPNExpression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int numberOfTestCases = input.nextInt(); 
		input.nextLine();									// clear the scanner
		
//		String rpnString = input.nextLine();
//		Scanner stringScan = new Scanner(rpnString);
		
		// loop for each test case
		for (int i = 0; i < numberOfTestCases; i++)
		{
			String rpnString = input.nextLine();
			Scanner stringScan = new Scanner(rpnString);
			
			Stack rpnStack = new MyStack();
			
			while (stringScan.hasNext())
			{
				if (stringScan.hasNextInt())
				{
					rpnStack.push(stringScan.nextInt());
				}

				if (!stringScan.hasNextInt())
				{
					String rpnOperation = stringScan.next();
					char operator = rpnOperation.charAt(0);

					int result;

					switch(operator) {

					case '+':
						result = rpnStack.pop() + rpnStack.pop();
						rpnStack.push(result);
						break;
					case '-':
						int subtrahend = rpnStack.pop();
						result = rpnStack.pop() - subtrahend;
						rpnStack.push(result);
						break;
					case '*':
						result = rpnStack.pop() * rpnStack.pop();
						rpnStack.push(result);
						break;
					case '/':
						int denominator = rpnStack.pop();
						result = rpnStack.pop() / denominator;
						rpnStack.push(result);
					default:
						break;

					}
				}
			}

			System.out.println(rpnStack);
			

		}	// end of test cases		
	}
}
