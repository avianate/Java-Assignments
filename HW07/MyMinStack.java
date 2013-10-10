// Nate Graham	A00305171


import java.util.ArrayDeque;


public class MyMinStack<T extends Comparable<T>> implements MinStack<T> {

	private T minimum = null;							// used for getMin() method
	ArrayDeque<T> stack = new ArrayDeque<T>();			// MyMinStack is based on an ArrayDeque

	
	
	public MyMinStack() {}
	

	@Override
	public boolean isEmpty() {

		return stack.isEmpty();
	}

	@Override
	public int getSize() {

		return stack.size();
	}

	@Override
	public void push(T element) {

		// if the stack is empty or if this element is the smallest set it as the minimum
		if (isEmpty() || element.compareTo(minimum) < 0)
		{
			minimum = element;
		}

		stack.push(element);

	}

	@Override
	public T pop() {
		
		// if stack is empty, throw EmptyStackException
		try {
			if (isEmpty())
				throw new EmptyStackException();
		} 
		catch (EmptyStackException e) {
			System.out.println(e);
			e.getStackTrace();
			return null;
		}

		// otherwise pop the element from the stack and update the minimum element based on the items left in the stack
		T value = stack.pop();
		
		int comparison = value.compareTo(minimum);

		if (comparison <= 0)
		{
			minimum = findMin();
		}

		return value;
	}

	
	@Override
	public T getMin() {
		
		if (isEmpty())
			return null;

		return minimum;
	}

	

	public String toString()
	{
		try {
			if (isEmpty())
				throw new EmptyStackException();
			}
			catch (EmptyStackException e)
			{
				System.out.println(e);
			//	e.getStackTrace();
				return "";
				
			}
		return this.toString();
	}




	private T findMin()
	{
		if (isEmpty())
			return null;
		
		ArrayDeque<T> temp = stack.clone();

		minimum = temp.pop();

		while (!temp.isEmpty())
		{
			T nextToCompare = temp.pop();
			int comparison = minimum.compareTo(nextToCompare);

			if (comparison > 0)
			{
				temp.push(minimum);
				minimum = nextToCompare;
			}
		}

		return minimum;

	}
	
	public static void main(String[] args)
	{
		MyMinStack<PersonName> stack = new MyMinStack<PersonName>();
		
		PersonName a = new PersonName("Aa", "Aa");
		PersonName b = new PersonName("Bb", "Bb");
		PersonName c = new PersonName("Cc", "Cc");
		PersonName d = new PersonName("Dd", "Dd");
		
		stack.push(c);
		stack.push(a);
		stack.push(d);
		stack.push(b);
	
		
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		
		System.out.println(stack.isEmpty());
		System.out.println(stack.getSize());
		
		stack.pop();
		System.out.println(stack.getMin());
		System.out.println(stack);
		
		
		
	}
	
}
