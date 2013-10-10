// Nate Graham	A00305171



@SuppressWarnings("serial")
public class EmptyStackException extends Exception {

	public EmptyStackException() 
	{	
		super("Stack is empty");
	}
	
	public EmptyStackException(String message)
	{
		super(message);
	}
	
}
