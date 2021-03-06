Homework 7 
Testing your code 

CS5060 IntensiveProgramming,Fall2012 
105points 
Due: 3:59pmNovember 12,2012 

Assignment description 
In this assignment we will implement a simple stack-based data structure and write unit tests to make sure that the implementation is correct. The assignment is simple, but you have to use some new concepts: Exceptions, Comparable, Generics, and unit tests with JUnit.1 

Comparable class (20 points) 
Create a PersonName classthatstoresthe �rstnameandlastnameof aperson. Theclassshouldimple�ment the Comparable interface and it should have: 
� 	
aconstructorthat acceptsthe �rst nameandlast name(2points), 

� 	
a getFirstName() method(1point), 

� 	
a getLastName() method(1point), 

� 	
a toString() method(3points), 

� 	
an equals(Object o) method(5points), and 

� 	
a compareTo(PersonName n) method that sortsby�rst nameand thenlast name(8points). 


Notes: 
� 	
Ifthe �rstname(orlastname) is null in the constructor, set the value to an empty string. Also, remove leading and trailing spaces. 

� 	
toString() should return the �rst name, then a single space, and then the last name, and it should remove leading and trailing spaces. 

� 	
equals(Object o) should return false if the object is not of type PersonName. 



Stack with min operation (40 points). 
Implement the MinStack interface available in the Files section on Canvas. The class implementing the interface should be named MyMinStack. 
1http://www.junit.org/ 

1 

Grading: 
� 
constructor(1point), 

� 
isEmpty() method(1point), 

� 
getSize() method(1point), 

� 
push() method(2points), 

� 
pop() method(2points), 

� 
getMin() method(5points), 

� 
toString() method(3points), 

� 
EmptyStackException (5points) 

� 
using Generic data type(10points), 

� 
implementing getMin() to run in constant time(10points). 



Unit tests (45 points) 
Write JUnit tests to test your classes. Create a PersonNameTest class to test your PersonName class and create a MyMinStackTest class to test your MyMinStack class. You should test every method of your classes, and each class method should be tested in a different test method. The tests for the MyMinStack class should use a stack that holds PersonNames. 
Grading for PersonNameTest (20 points): The tests for each method are worth the same as their implementations. 
Grading for MyMinStackTest (25 points): 
� 
constructor(1point), 

� 
getSize() method(1point), 

� 
isEmpty() method(1point), 

� 
push() method(5points), 

� 
pop() method(5points), 

� 
getMin() method(7points), 

� 
toString() method(5points), 


Submission. 
Submit a zip �le with the following �les: 
2 

1. Code �les PersonName.java, EmptyStackException.java, and MyMinStack.java withyourclassimplementations; and code �les PersonNameTest.java and MyMinStackTest with theunittests(donot submittheinterface �les). 
IncludeyournameandA numberatthetop of each source �le.Namethe zip �le hw07 firstName lastName.zip.Forexample,ifyournameisJohnSmith,namethe �le hw07 John Smith.zip. 




3 


