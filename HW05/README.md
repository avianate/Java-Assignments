Homework 5 
Recursion 

CS5060 IntensiveProgramming,Fall2012 
100points 
Due: 3:59pmOctober 15,2011 

Solve the following problems (100 points). 
There are easier and harder problems. Harder problems are worth more points. You must use recursion to solve all the problems. You will get a zero score for any problem that you solve without recursion (even if the result is correct). 
Note: All input must be read from the standard input stream, and all output must be written to the standard output stream. For this assignment, assume the input is correct. 
Hint: Start with the easy problems and start early. 

Submission. 
Submit a zip �le with the following �les: 
1. Eight code �les Count.java, SumDigits.java, RBinarySearch.java, ArithmeticExpression.java, SubgroupSum.java, SubgroupSplitSum.java, ConnectedComponents.java, MapReachability.java with the solutionstoproblems1, 2,3, ...,8,respectively. 
IncludeyournameandA numberatthetop of each source �le.Namethe zip �le hw05 firstName lastName.zip.Forexample,ifyournameisJohnSmith,namethe �le hw05 John Smith.zip. 




Input: The input begins with the number t of test casesinasingleline(t � 100). Eachtest case has two lines. The �rst line has two numbers: n (1 � n � 1000)and x (1 � x � 1000000). The second line has a list of n numbers m (1 � m � 1000000)separated by spaces. 
Output: For each test case output the number of occurrences of x in the list. 
Example: 
Input: 
3 
40 
5060 
43 
5060 
7 17 
2 3 5 7 11 13 17 

Output: 
2 
0 
1 

Input: Theinput begins with the number t of test cases in a single line(t � 100). Eachof the next t lines contains a number n (0 � n � 1 � 1018 ). 
Output: Foreach test case? outputthesumof thedigits of n. 
Example: 
Input: 
3 
123 
5060 
72057594037927936 

Output: 
6 
11 
85 

Hint: Use division and modulo. 
Input: The input begins with the number t of test casesinasingleline(t � 100). Eachtest case has two lines. The �rst line has two numbers: n (1 � n � 1000)and x (1 � x � 1000000). The second line has a list of n numbers m (1 � m � 1000000)sorted in increasing order and separated by spaces. 
Output: For each test case determine if the number x isin the list. 
Example: 
Input: 
3 
40 
0056 
43 
0056 
7 17 
2 3 5 7 11 13 17 

Output: 
YES 
NO 
YES 

Implement a recursive function to multiply twointegers and a recursive function todivide twointegers. You can usethe addition(+)and subtraction(-)operators,butyou cannot usethe multiplication(*)or division (/)operators of thelanguageinyourprogram. Usethesefunctionsto evaluate arithmetic expressions(you are not required to use recursion for the evaluation part of thisproblem). Remember that multiplication and division have preference over addition and subtraction. 
Input: Theinput begins with the number t of test cases in a single line(t � 100). Eachof the next t lines contains anarithmetic expression.Theexpression onlyhasinteger numbersandit canhaveparenthesis and any of the following binary operators: +, -, *, /. Thedivisionisintegerdivision(thereis nodivisionby zero). 
Output: Foreach test caseoutputtheresult of evaluating theexpression(theresult couldbenegative). 
Example: 
Input: 
4 
(7 -2) * 3 
7 2-3

* 
(3 -8) / 2 
3-8/2 

Output: 
15 
11 
-2 
-1 

Hint: The implementations explained in class using only the increment (++) and decrement (--) operators will be two slow. 
Input: The input begins with the number t of test casesinasingleline(t � 100). Eachtest case has two lines. The �rst line has two numbers: n (1 � n � 20)and x (1 � x � 1000000). The second line has a list of n numbers m (1 � m � 1000000)separated by spaces. 
Output: For each test case determine if there is a subgroup S of the numbers in the list, such that the numbers in S add up to x. 
Example: 
Input: 
3 
43 
5060 
46 
3214 
7 23 
2 3 5 7 11 13 17 

Output: 
NO 
YES 
YES 

Hint: Note that numbers in the subgroup do not have to be consecutive. 
Input: The input begins with the number t of test casesinasingleline(t � 100). Eachtest case has two lines. The �rst line a number: n (1 � n � 20). The second line has a list of n numbers m (1 � m � 1000000)separated by spaces. 
Output: For each test case determine if list can be divided into two non-empty subgroups such that the sum of each subgroup is the same. 
Example: 
Input: 
3 
4 
5060 
4 
3214 
7 
2 3 5 7 11 13 17 

Output: 
NO 
YES 
YES 

Hint: Note that numbers in the subgroups do not have to be consecutive, so this is not the same as the array split sum problem we saw before. 
Read aboutpixel connectivity at http://en.wikipedia.org/wiki/Pixel_connectivity 

Input: The input begins with the number t of test casesin a singleline(t � 100). Each test case has multiple lines. The �rst line has two numbers: a number of rows r (1 � r � 1000) and a number of columns c (1 � c � 1000). The nextr linesdescribe abinary image. 
Output: For each test case output the number of 4-connected componentsintheimage. 
Example: 
Input: 
2 
45 
11100 
01100 
01111 
00001 
45 
11100 
01100 
01111 
10001 

Output: 
3 
5 

Input: The input begins with the number t of test casesin a singleline(t � 100). Each test case has multiple lines. The �rst line has two numbers: a number of rows r (1 � r � 1000) and a number of columns c (1 � c � 1000). The next r lines describe a map where �.� are empty spaces, �X� are walls, �S� isyourstarting location, and �G� isyourgoal destination. 
Output: For each test casedetermineifitispossible to reach thegoalfromyour startinglocation(use 4-connectivity). 
Example: 
Input: 
2 
45 

XXX.G 

.XX.. 
.XXXX 
S...X 
45 

XXX.G 

.XX.. 
.XX.X 
S...X 


Output: 
NO 
YES 


