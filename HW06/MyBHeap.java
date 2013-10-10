// Nate Graham	A00305171

/*
	Sources: 
	http://www.algolist.net/Data_structures/Binary_heap/Array-based_int_repr
	http://www.algolist.net/Data_structures/Binary_heap/Insertion
	http://www.algolist.net/Data_structures/Binary_heap/Remove_minimum
	http://www.brilliantsheep.com/array-based-min-heap-java-implementation/
*/


public class MyBHeap implements BHeap {

	private int array[];
	private int node = 0;
	
	public MyBHeap() {};

	public MyBHeap(int size)
	{
		array = new int[size];
	}


	public void insert(int value) {

		array[node] = value;
		heapifyUp(node);
		node++;

	}


	public void remove() {

		if (node == 0)
		{
			System.out.println("Heap is empty!");
			return;
		}

		array[0] = array[node-1];

		if (--node > 0)
		{
			heapifyDown(0);
		}

	}


	public void heapifyUp(int index)
	{
		if (node == array.length)
			System.out.println("Heap if full");
		
		if (index > 0)
		{
			int parent = (index - 1) / 2;

			if (array[parent] > array[index])
			{
				swap(parent, index);
				heapifyUp(parent);
			}
		}
	}


	public void heapifyDown(int index) {

		int leftChild = 2 * index + 1;
		int rightChild = 2 * index + 2;

		if (rightChild >= node && leftChild >= node)
			return;

		int min;

		if (array[rightChild] > array[leftChild])
			min = leftChild;
		else
			min = rightChild;

		if (array[index] > array[min])
		{
			swap(min, index);
			heapifyDown(min);
		}

	}


	public void swap(int a, int b)
	{
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public void heapSort()
	{	
		heapSort(0);
	}
	
	private void heapSort(int index)
	{
		if (node == 0)
			return;
		
		int min = array[0];
		
		array[0] = array[node - 1];
		
		if (--node > 0)
			heapifyDown(0);
		
		System.out.print(min + " ");
		
		heapSort(node);
	}


	public void display() {
		
		for (int index = 0; index < node; index++)
		{
			System.out.print(array[index] + " ");
		}

	}

}
