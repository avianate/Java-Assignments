// Nate Graham	A00305171


import static org.junit.Assert.*;
import org.junit.Test;

public class PersonNameTest {
	
	PersonName me = new PersonName("  Nate ", "Graham");
	PersonName noFirst = new PersonName(null, "Gar dner");
	PersonName	one = new PersonName("Aaron", "Smith");
	PersonName two = new PersonName("Aaron", "Zimmerman");
	PersonName three = new PersonName("Nate", "Graham");

	@Test
	public void testConstructor() {
		
		// relies on getFirstName() and getLastName() methods to work so there is no need to write a separate test for these methods.
		
		// test that a constructed object is instance of PersonName
		assertTrue(me instanceof PersonName);
		
		// test that names are not null
		assertNotNull(me.getFirstName());
		assertNotNull(me.getLastName());
		
		assertNotNull(noFirst.getFirstName());
		assertNotNull(noFirst.getLastName());
		
		
		// leading and trailing spaces only are being removed from names
		assertEquals(noFirst.getLastName(), "Gar dner");
		assertEquals(me.getFirstName(), "Nate");
		assertEquals(me.getLastName(), "Graham");
	}
	
	
	@Test
	public void testEqualsMethod()
	{
		int testInt = 1;
		
		// test that int is not a PersonName object
		assertFalse(me.equals(testInt));
		
		// check that two objects are both PersonNames
		assertTrue(one.equals(two));
		assertTrue(me.equals(three));
		
	}
	
	
	@Test
	public void testCompareTo()
	{	
		// test that names are not equal
		assertTrue(me.compareTo(noFirst) != 0);
		assertTrue(one.compareTo(two) != 0);

		// test that names are equal
		assertTrue(me.compareTo(three) == 0);
		
		// test that one is less than two
		assertTrue(one.compareTo(two) == -1);
		
		// test that two is greater than one
		assertTrue(two.compareTo(one) == 1);	
	}
	
	
	@Test
	public void testToString() {
		
		// test that toString method works as expected
		assertEquals(me.toString(), "Nate Graham");
	}

}
