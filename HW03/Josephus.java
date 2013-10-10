// Nate Graham	A00305171


import java.util.Scanner;


public class Josephus extends MyQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int numberOfTestCases = 0;
		int numberToSkip;
        int sizeOfQueue;

		Scanner input = new Scanner(System.in);
		
		numberOfTestCases = input.nextInt();
		
		// loop for each test case
		for (int i = 0; i < numberOfTestCases; i++)
		{
	        Josephus josephusTest = new Josephus();
			
			sizeOfQueue = input.nextInt();
			numberToSkip = input.nextInt();
			
			// load the queue
			for (int j = 1; j <= sizeOfQueue; j++)
	        {
	            josephusTest.enqueue(j);
	        }
		
			
			// the following code is adapted from code found at: http://introcs.cs.princeton.edu/java/43stack/Josephus.java.html
			
			// run test case until only 1 number remains
			while (josephusTest.getSize() > 1) 
			{
				// to skip objects in the cue dequeue the object and then enqueue
				// this will place the skipped number at the opposite end of the queue thus working similar to a circular queue
	            for (int j = 0; j < numberToSkip; j++)
	            {
	                josephusTest.enqueue(josephusTest.dequeue());
	            }
	            
	            josephusTest.dequeue();
	            
	        }
			
			System.out.println(josephusTest);
		
		}

	}

}
