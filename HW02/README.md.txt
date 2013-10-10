Homework 2 
Arrays CS5060 IntensiveProgramming,Fall2012 
80points 
Due: 3:59pmSeptember 14,2012 
Dynamic array implementation (25 pts). Problem 0: Dynamic array Implement a dynamic array that holds integer values and that grows when necessary to make room for new elements. Make sure your DynamicArray class implements the DynamicArrayHw2 interface, available in the Files section on Canvas. You should have a function to add an element to the end of the array, and a function to remove an element from any position in the array. The order of the elements is not important, so when an element is removed, replace it with the last element in the array (unless it is the last element). Theinitial sizeof thearray shouldbelessthanorequal to 4. Note: All input must be read from the standard input stream, and all output must be written to the standard output stream. For this assignment, assume the input is correct. Input: The input begins with the number t of test casesin a singleline(t ≤ 100). Each of the next t lines starts with a number n (1 ≤ n ≤ 1000000) followed by a list of n operations. There are two types of operations: append, and delete. An append operation is represented a letter ‘a’ followed by a number m (0 ≤ m ≤ 1000000)to append. A delete operation is represented by a letter ‘d’ followed by the index i of the element to remove(0 ≤ i ≤ array size • 1). Output: For each test case output the elements of the array after all the operations have been performed. Consecutive elements should be separated by a single space. Example: Input: 3 
4a5a0a6a0 
6a3a0a6a5d0a0 
8a1a2a3a4d1a5a6d2 
5060 
5060 
1465 
Grading: • 	Code: 5pts • 	Correct results(n ≤ 1000): 10pts(note that for eachtest case the result is unique) • 	Stress test(n ≤ 1000000): 10pts – 	Thegrader willmeasure thetime T required to solve theproblem onhis computer(ittakes about 1 second on the instructor’s computer to solve all the test cases). – 	Ifyour code takes time t ≤ 2T ,youget 10pts; – 	ifyour code takes time t ≤ 3T ,youget 7pts; – 	ifyour code takes time t ≤ 4T ,youget 4pts; – ifyour code takes time t ≤ 5T ,youget 1pt; 
– otherwiseyouget0pts. 
Solve the following problems (55 pts). Eachproblemisworth10points.All of theproblems canbesolved using arrays.Thereis1 extrapointfor eachproblemthatyousolveusing thedynamic arrayimplementedinproblem0. Note: All input must be read from the standard input stream, and all output must be written to the standard output stream. For this assignment, assume the input is correct. Input: Theinput begins with the number t of test cases in a single line(t ≤ 100). Eachof the next t lines starts with a number n (1 ≤ n ≤ 1000)followed by a list of n numbers m (1 ≤ m ≤ 1000000)separated by spaces. Output: For each test case output the numbers in reverse order. Example: Input: 2 
512345 
577878 
Output: 54321 
87877 
Input: Theinput begins with the number t of test cases in a single line(t ≤ 100). Eachof the next t lines starts with a number n (1 ≤ n ≤ 1000)followed by a list of n numbers m (1 ≤ m ≤ 1000000)separated by spaces. Output: For each test case determine if the list can be split into two in such a way that the sum of the numbers on the left is equal to the sum of the numbers on the right. Example: Input: 3 
3123 
41234 
13 1 0 0 1 1 1 1 0 0 0 1 0 0 
Output: YES 
NO 
YES 
Input: Theinput begins with the number t of test cases in a single line(t ≤ 100). Eachof the next t lines starts with a number n (1 ≤ n ≤ 1000)followed by a list of n numbers m (1 ≤ m ≤ 1000000)separated by spaces. Output: A run is a series of one or more consecutive elements with the same value. For each test case output the number of runs in thelist. Example: Input: 3 
512345 
6122333 
13 1 0 0 1 1 1 1 0 0 0 1 0 0 
Output: 5 
3 
6 
Input: The input begins with the number t of test casesin a singleline(t ≤ 100). Each test case has three lines. The ﬁrst line has a number n (1 ≤ n ≤ 1000). The second line has a list of n numbers m (1 ≤ m ≤ 1000000) separated by spaces. The third line contains n numbers, zero or one, where a zero means that the corresponding element of the list in the previous line is invalid, and a one means that the corresponding element is valid. Output: For each test case output the list after removing all the invalid elements. Example: Input: 2 
5 
12345 
10101 
13 
1223334444555 
1001111000100 
Output: 135 
133345 
Input: The input begins with the number t of test casesinasingleline(t ≤ 100). Eachtest case has two lines. The ﬁrst line has a number n1 (1 ≤ n1 ≤ 1000) followed by a list of n1 numbers m (1 ≤ m ≤ 1000000)separated by spaces. The second line has a number n2 (1 ≤ n2 ≤ 1000)followed by a list of n2 numbers m (1 ≤ m ≤ 1000000)separatedby spaces.Bothlistsaresortedinincreasing order. Output: For each test case mergebothlistsinto onelist thatkeeps all the elementsin sorted order. Output the merged list. Do not use sorting to solve this problem. There is a 5 pts deduction if you use sorting. Example: Input: 2 
3135 
3246 
4 2 7 32 45 
5 3 4 5 21 38 
Output: 123456 
2 3 4 5 7 21 32 38 45 
Submission. Submit a zip ﬁle with six ﬁles: 1. A code ﬁle DynamicArray.java withyourdynamicarray implementationand acode ﬁle DynamicArrayTest.java withthe solution toproblem0(do not submitthe DynamicArrayHw2.java ﬁle). 2. Five code ﬁlesReverseArray.java,SplitSum.java,RunCount.java,CompactArray.java and ArrayMerge.java with the solutions toproblems 1,2,3,4 and 5, respectively. IncludeyournameandA numberatthetop of each source ﬁle.Namethe zip ﬁle hw02 firstName lastName.zip.Forexample,ifyournameisJohnSmith,namethe ﬁle hw02 John Smith.zip. 7 