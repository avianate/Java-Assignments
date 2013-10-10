// Nate Graham	A00305171



import java.util.Scanner;






public class ReverseArray extends DynamicArray {

	public ReverseArray() {};
	

	// override toString() method to print reverse
	public String toString()
	{
		String arrayString = new String();

		for (int i = getSize()-1; i >= 0; i--)
		{
			arrayString += Integer.toString(get(i));
			arrayString += " ";
		}
		return arrayString;
	}







	public static void main(String[] args) {

		int numberOfTestCases = 0;

		ReverseArray myArray = new ReverseArray();

		Scanner input = new Scanner(System.in);

		// get number of test cases
//		System.out.println("Number of test cases: ");
		numberOfTestCases = input.nextInt();

		
		// loop for each test case
		for (; numberOfTestCases > 0; numberOfTestCases--)
		{
			// get size of test case
//			System.out.println("test case");
			int arraySize = input.nextInt();
			myArray.setTestArraySize(arraySize);

			for (int i = 0; i < arraySize; i++)
			{
				myArray.append(input.nextInt());
			}

			System.out.println(myArray);
		}

	}
}
