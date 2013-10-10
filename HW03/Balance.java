// Nate Graham	A00305171


import java.util.Scanner;



public class Balance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String testCase = null;
		
		
		Scanner input = new Scanner(System.in);
		int numberOfTestCases = input.nextInt();
		
		// loop for each test case
		for (int i = 0; i < numberOfTestCases; i++)
		{
			Stack balanceTest = new MyStack();
			boolean good = true;

			// push each character on the stack
			testCase = input.next();
			
			int stringLength = testCase.length();
			for (int j = 0; j < stringLength; j++)
			{
				int testCharacter = testCase.charAt(j);
				
				if (testCharacter == '(' || testCharacter == '[')
				{
					balanceTest.push(testCharacter);
				}
				else 
				{
					int previousCharacter = balanceTest.pop();
					if ((previousCharacter == '(' && testCharacter != ')') ||
						(previousCharacter == '[' && testCharacter != ']'))
					{
						good = false;
						break;
					}
				}
			}
			
			if (good)
			{
				System.out.println("YES");
			}
			else
				System.out.println("NO");
		}
		
		
	}

}
