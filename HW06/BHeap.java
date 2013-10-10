// Nate Graham	A00305171



public interface BHeap {

	public void insert(int value);

	public void remove();
	
	public void heapifyUp(int index);

	public void heapifyDown(int index);
	
	public void swap(int smaller, int larger);
	
	public void heapSort();

	public void display();


}
