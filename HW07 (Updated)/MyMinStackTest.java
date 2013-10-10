// Nate Graham	A00305171



import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class MyMinStackTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	MinStack<PersonName> personStack = new MyMinStack<PersonName>();

	PersonName me = new PersonName("  Nate ", "Graham");
	PersonName noFirst = new PersonName(null, "Gar dner");
	PersonName	one = new PersonName("Aaron", "Smith");
	PersonName two = new PersonName("Aaron", "Zimmerman");
	PersonName three = new PersonName("Nate", "Graham");



	@Test
	public void testConstructor() {

		// check constructor by making sure an instance of the stack is created
		assertTrue(personStack instanceof MyMinStack);
		assertTrue(personStack instanceof MinStack);
		assertFalse(personStack instanceof PersonName);
	}

	
	
	@Test
	public void testIsEmpty() throws EmptyStackException {

		// test that stack is empty
		assertTrue(personStack.isEmpty());

		// test that stack is not empty
		personStack.push(one);
		assertFalse(personStack.isEmpty());
		
		try {
			personStack.pop();
			personStack.pop();
			
			throw new EmptyStackException();
		}
		
		catch (EmptyStackException e)
		{
			assertTrue(true);
		}
		
		
		

	}



	@Test
	public void testGetSize() {

		// *note: this test method relies on push() & pop() methods to work therefore no separate test is needed for these two methods

		// test that getSize() is zero when stack is empty
		assertTrue(personStack.isEmpty());
		assertTrue(personStack.getSize() == 0);

		// test that getSize() return correct size when elements are added to stack
		personStack.push(me);
		personStack.push(noFirst);
		personStack.push(one);
		personStack.push(two);
		personStack.push(three);

		assertTrue(personStack.getSize() == 5);
	}


	@Test 
	public void testGetMin() {

		// test that if only one element is on stack it is the minimum
		assertTrue(personStack.isEmpty());

		personStack.push(me);
		assertEquals(personStack.pop().toString(), me.toString());
		
		// test that minimum element is being returned when stack contains multiple elements
		personStack.push(me);
		personStack.push(one);
		personStack.push(two);

		
		assertEquals(personStack.getMin().toString(), one.toString());

	}
	
	
	@Test
	public void testToString() {
		
		// test if toString method works as expected
		personStack.push(me);
		assertEquals(personStack.pop().toString(), me.toString());
	}


}
