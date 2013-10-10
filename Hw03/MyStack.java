// Nate Graham	A00305171


public class MyStack implements Stack {

	private MyLinkedList internalList = new MyLinkedList();
	
	
	public boolean isEmpty() {

		return internalList.isEmpty();

	}

	
	public int getSize() {

		return internalList.getSize();
	}

	
	public void push(Integer value) {

		internalList.insertFirst(value);

	}

	
	public Integer pop() {

	

		// store last object on the stack in a variable, then remove the object
		int lastOnStack = internalList.getFirst();
		internalList.removeFirst();

		return lastOnStack;

	}

	@Override
	public String toString()
	{
		
		return internalList.toReverseString();
	}
	
	

	void clearStack()
	{
		while (!isEmpty())
		{
			internalList.removeFirst();
		}
	}

}
