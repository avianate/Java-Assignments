// Nate Graham	A00305171


public class MyLinkedList implements LinkedList {

	private class MyListNode {
		public MyListNode next;
		public int intValue;
		
		MyListNode(Integer value)
		{
			intValue = value;
			next = null;
		}
	}
	
	private MyListNode head = null;


	MyLinkedList()
	{
		head = null;
	}

	public boolean isEmpty() {

		if (head == null)
		{
			return true;
		}

		return false;

	}

	public int getSize() {

		int count = 0;
		MyListNode here = head;

		while (here != null)
		{
			here = here.next;
			count++;
		}

		return count;

	}

	public Integer getFirst() {
		
		if (this.isEmpty())
		{
			return null;
		}

		return head.intValue;

	}

	private MyListNode getLastNode() {
		
		if (this.isEmpty())
		{
			return null;
		}

		MyListNode here = head;

		while (here.next != null)
		{
			here = here.next;
		}

		return here;
		
	}

	public Integer getLast() {
		MyListNode node = getLastNode();
		
		if (node == null)
		{
			return null;
		}
		else
		{
			return node.intValue;
		}
		
	}

	
	public void insertFirst(Integer value) {

		MyListNode newNode = new MyListNode(value);
		newNode.next = head;
		head = newNode;

	}

	
	public void insertLast(Integer value) {

		MyListNode newNode = new MyListNode(value);
		MyListNode here = getLastNode();
		
		if (here == null)
		{
			head = newNode;
		}
		else
			here.next = newNode;
	}

	
	public void removeFirst() {

		if (head != null)
		{
			head = head.next;
		}

	}

	
	public void removeLast() {

		MyListNode here = head;
		MyListNode previous = null;

		if (head == null)
			return;
		
		while (here.next != null)
		{
			previous = here;
			here = here.next;
		}

		if (previous == null)
			head = null;
		else
			previous.next = null;
	}

	@Override
	public String toString()
	{
		MyListNode here = head;
		String listString = "";

		while (here != null)
		{
			listString += Integer.toString(here.intValue);
			listString += " ";
			here = here.next;

		}

		return listString;

	}

	
	public String toReverseString()
	{
		MyListNode here = head;
		String listString = "";

		while (here != null)
		{
			listString = Integer.toString(here.intValue) + " " + listString;
			here = here.next;

		}

		return listString;

	}
}
