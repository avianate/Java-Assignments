// Nathan Graham	A00305171


import java.util.*;




public class DynamicArray implements DynamicArrayHw2 {
	
	public int testArray[];
	private static final int EMPTY = -1; 
	

	public DynamicArray() {
		
		// set initial testArray size to 4 and fill with EMPTY
		testArray = new int[4];
		Arrays.fill(testArray, EMPTY);
	}


	public int getSize() {
		
		int numberOfOccupiedCells = 0;
		
		// empty array elements are initialized with -1
		// do not count these as elements of the array, treat them as null
		
		for (int i = 0; i < testArray.length; i++)
		{
			if (testArray[i] != EMPTY)			// if cell is not "null" count it in array size
			{
				numberOfOccupiedCells++;
			}
		}
		return numberOfOccupiedCells;
	}


	public int get(int index) {

		return testArray[index];
	}


	public void append(int value) {
		
		if (getSize() < testArray.length)
		{
			testArray[getSize()] = value;
		}
		
		else  // array needs to be resized
		{
			int originalSize = getSize();
			resizeArray(originalSize*2);			// double the size of the array when it needs to be resized
			testArray[originalSize] = value;		// place new value in first empty cell of new array
		}
	}


	public void remove(int index) {

		// if the element to be removed is not the last element
		if (index < getSize()-1)
		{
			testArray[index] = testArray[getSize()-1];		// copy the last element into the cell to be "deleted"
		}
		
		testArray[getSize()-1] = EMPTY;						// set the last element to empty
			
	}
	
	public String toString()
	{
		String arrayString = new String();
		
		// loop through each int int the array and add to arrayString
		for (int i = 0; i < getSize(); i++)
		{
			arrayString += Integer.toString(get(i));
			arrayString += " ";
		}
		return arrayString;
	}
	
	
	
	public void clearArray()
	{
		// set all elements in the array to empty
		Arrays.fill(testArray, EMPTY);
	}
	
	
	public void setTestArraySize(int size)
	{
		resizeArray(size);
		clearArray();
	}
	
	
	
	
	private void resizeArray(int size)
	{
		int temp[] = new int[size*2];
		
		// copy the array into a temporary array
		System.arraycopy(testArray, 0, temp, 0, getSize());
		
		// double the size of the array and then copy temporary array back into the larger array
		testArray = new int[size*2];
		System.arraycopy(temp, 0, testArray, 0, getSize());
	}
	
	
}
