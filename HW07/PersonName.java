// Nate Graham	A00305171


// http://docs.oracle.com/javase/tutorial/displayCode.html?code=http://docs.oracle.com/javase/tutorial/collections/interfaces/examples/Name.java


public class PersonName extends Object implements Comparable<PersonName> {

	private String firstName, lastName;

	public PersonName(String firstName, String lastName)
	{
		if (firstName == null)
			firstName = "";
		if (lastName == null)
			lastName = "";

		this.firstName = firstName.trim();
		this.lastName = lastName.trim();
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public boolean equals(Object otherObject)
	{
		if (!(otherObject instanceof PersonName))
			return false;

		return true;


		//	PersonName person = (PersonName) otherObject;
		//	return person.firstName.equals(firstName) && person.lastName.equals(lastName);
	}


	public String toString()
	{
		return firstName + " " + lastName;
	}


	public int compareTo(PersonName person)
	{
		int firstCompare = firstName.compareTo(person.firstName);
		int result = (firstCompare != 0 ? firstCompare : lastName.compareTo(person.lastName));

		if (result > 0)
			return 1;
		else if (result < 0)
			return -1;

		return 0;

	}
}
