// Nate Graham	A00305171


public class MyQueue implements Queue {

	private MyLinkedList internalList = new MyLinkedList();
	
	
	public boolean isEmpty() {
		
		return internalList.isEmpty();
		
	}

	
	public int getSize() {
		
		return internalList.getSize();
		
	}

	
	public void enqueue(Integer value) {
		
		internalList.insertLast(value);

	}

	
	public Integer dequeue() {
		
		if (isEmpty())
		{
			return null;
		}

		// store last object on the stack in a variable, then remove the object
		int firstInQueue = internalList.getFirst();
		internalList.removeFirst();

		return firstInQueue;
	}
	
	
	public String toString()
	{
		return internalList.toString();
	}
	
	
	
	void clearQueue()
	{
		while (!this.isEmpty())
		{
			this.dequeue();
		}
	}
}
