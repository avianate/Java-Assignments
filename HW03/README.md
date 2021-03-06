Homework 3 
Linked list, stack, queue 

CS5060 IntensiveProgramming,Fall2012 
85points 
Due: 3:59pmSeptember 26,2012 

Linked list, stack, queue (40 pts). 
Implement a singly-linked list and use it to solve the following problems. Your MyLinkedList class should implement the LinkedList interface availableintheFilessection onCanvas. 
Note: All input must be read from the standard input stream, and all output must be written to the standard output stream. For this assignment, assume the input is correct. 

Problem 0a: Stack 
Implement a linked list based stack using your singly-linked list implementation. Your MyStack class should implement the Stack interface availableintheFilessection onCanvas. 
Input: The input begins with the number t of test casesin a singleline(t � 100). Each of the next t lines starts with a number n (1 � n � 1000) followed by a list of n operations. There are two types of operations: push and pop. A push operation is represented by a string �push� followed by a number m (1 � m � 1000000)topushintothestack.Apop operationisrepresentedby astring �pop�. 
Output: For each test case output the elements in the stack after all the operations have been performed. Consecutive elements should be separated by a single space. 
Example: 
Input: 
2 
4 push 5 push 0 push 6 push 0 
7 push 1 push 2 pop push 3 push 4 pop push 5 

Output: 
5060 
135 

Implement a linked list based queue using your singly-linked list implementation. Your MyQueue class should implement the Queue interface availableintheFilessection onCanvas. 
Input: The input begins with the number t of test casesin a singleline(t � 100). Each of the next t lines starts with a number n (1 � n � 1000) followed by a list of n operations. There are two types of operations: enqueue and dequeue. An enqueue operation is represented by a string �enq� followed by a number m (1 � m � 1000000)toputintothequeue.Adequeueoperationisrepresentedby astring �deq�. 
Output: Foreach test caseoutputthe elementsinthequeue after all theoperationshavebeenperformed. Consecutive elements should be separated by a single space. 
Example: 
Input: 
2 
4 enq 5 enq 0 enq 6 enq 0 
7 enq 1 enq 2 deq enq 3 enq 4 deq enq 5 

Output: 
5060 
345 

Grading: Thelinkedlistisworth10pts.Thestack and thequeue areworth15pts each(ifyoudon�t use the linked listyouget 5pts only). 
For eachdata structure, make sureyou usetheinterface name whendeclaringinstances(notthe class name).Forexample,youshould write: 
LinkedList myList = new MyLinkedList(); 
Stack myStack = new MyStack(); 
Queue myQueue = new MyQueue(); 

Thisisworth2pointsineach case. 
For each data structure you should use the toString() method to output the result. This is worth 2 pts in each case. 
Each problem is worth 10 points. All of the problems can be solved by using a linked list, a stack, or a queue. There are5extrapointsfor solving theproblems using thedata structures implementedinproblem0 (1point for eachproblemplus 1extrapoint ifyou use the data structures for all theproblems). 
Note: All input must be read from the standard input stream, and all output must be written to the standard output stream. For this assignment, assume the input is correct. 
There are n people, numbered 1, 2, ..., n,in a circle. At each step, m people are skipped and the nextperson is executed, until thereis only oneperson remaining. HelpJosephus determine theposition wherehe should beintosavehislife.Youcanread moreaboutthisproblem at http://en.wikipedia.org/wiki/Josephus_problem. 
Input: Theinput begins with the number t of test cases in a single line(t � 100). Eachof the next t lines hastwo numbers: the number ofpeople n (1 � n � 1000)and the number ofpeople k (1 � k � 1000)to skip at each step. 
Output: Foreach test caseoutputtheposition whereJosephus shouldbeintosavehislife. 
Example: 
Input: 
2 
51 
52 

Output: 
3 
4 

A string S consisting ofparenthesis () and square brackets [] isbalanced if: 
� 
S is the empty string, 

� 
S = AB and both A and B are balanced, 


� S =(A) or S =[A]. 
Input: Theinput begins with the number t of test cases in a single line(t � 100). Eachof the next t lines 
contains astring oflength � (1 � � � 1000)formed withparenthesis and squarebrackets. 
Output: For each test case determine if the string is balanced. 
Example: 
Input: 

([]) 
()[] 
([)] 

Output: 
YES 
YES 
NO 

Input: Theinput begins with the number t of test cases in a single line(t � 100). Eachof the next t lines starts with a number n (1 � n � 1000)followedbyalist of n operations. There are two types of operations that canbeperformed onanunknowndatastructure(stack orqueue): add and remove.Anadd operationis represented by a string �add�followed by a number m (1 � m � 1000000)to add to the data structure. A remove operation is represented by a string �rem�followedby the number m (1 � m � 1000000)removed from the data structure. 
Output: For each test casedetermine whether thedata structureis a stack or aqueue. Ifitis a stack output �STACK�,ifitisaqueueoutput �QUEUE�,andifitisnotpossibletoknowoutput �UNKNOWN�. 
Example: 
Input: 
4 
4 add 5 add 0 add 6 add 0 
6 add 1 add 2 add 3 rem 3 rem 2 rem 1 
6 add 1 add 2 add 3 rem 1 rem 2 rem 3 
4 add 2 add 2 rem 2 rem 2 

Output: 
UNKNOWN 
STACK 
QUEUE 
UNKNOWN 

Read about Reverse Polish Notation (RPN)at http://en.wikipedia.org/wiki/Reverse_Polish_notation. 
Input: Theinput begins with the number t of test cases in a single line(t � 100). Eachof the next t lines contains an RPE expression. The expression only has integer numbers and it can have any of the following binary operators: +, -, *, /. Thedivision isinteger division(there is no division by zero). 
Output: Foreach test caseoutputtheresult of evaluating theexpression(theresult couldbenegative). 
Example: 
Input: 
3 
72-3 

* 
72 3�
* 
38-2/ 

Output: 
15 
11 
-2 


Submission. 
Submit a zip �le with the following �les: 
1. 
Code �les MyLinkedList.java, MyStack, and MyQueue with your implementations of the data structures; and code �les MyStackTest.java and MyQueueTest with the solution toprob�lems0aand0b.(donot submittheinterface �les). 

2. 
Four code �les Josephus.java, Balance.java, StackOrQueue.java 
and RPNExpression.java with the solutions toproblems 1,2,3,and 4, respectively. 



IncludeyournameandA numberatthetop of each source �le.Namethe zip �le hw03 
firstName 
lastName.zip.Forexample,ifyournameisJohnSmith,namethe �le hw03 
John 
Smith.zip. 

