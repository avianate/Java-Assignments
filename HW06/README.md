Homework 6 
Trees and heaps 

CS5060 IntensiveProgramming,Fall2012 
100points 
Due: 3:59pmOctober 31,2012 

Binary search tree and binary heap (40 points). 
Implement a binary search tree and an array based binary heap. Create your own BSTree interface and make sure your MyBSTree class implements it. Also, create your own BHeap interface and make sure yourMyBHeap classimplementsit. Make sureyou reuse the tree andheap codefor otherproblems,instead of copying it. Points will be deducted if you copy the code for each problem. 
Note: All input must be read from the standard input stream, and all output must be written to the standard output stream. For this assignment, assume the input is correct. 

Problem 0a: Binary search tree (20 points) 
Implement abinary search tree. 
Input: The input begins with the number t of test casesin a singleline(t � 100). Each of the next t lines starts with a number n (1 � n � 1000) followed by a list of n operations. There are two types of operations:insert and remove.Aninsert operationisrepresentedby acharacter �i�followedby anumber m (1 � m � 1000000)to add to the tree(ignore repeated numbers). Aremove operation is represented by a character �r� followedby anumber m (1 � m � 1000000)to remove from the tree. 
Output: Foreach test case outputthe contents of thetree,inpre-order, after all the operationshavebeen performed. Consecutive elements should be separated bya single space. 
Example: 
Input: 
4 
4i5i0i6i0 
5i5i4i3i2i1 
6i5i3i7i6i4i2 
7i5i3i7i6i4i2r3 

506 
54321 
532476 
54276 


Problem 0b: Binary heap (20 points) 
Implement an array based binary heap. 
Input: The input begins with the number t of test casesin a singleline(t � 100). Each of the next t lines starts with a number n (1 � n � 1000) followed by a list of n operations. There are two types of operations:insert and removeminimum.Aninsert operationisrepresentedby acharacter �i� followedby a number m (1 � m � 1000000)to add totheheap(allow repeated numbers). Aremove minimum operation is represented by a character �r�. 
Output: For each test case output the contents of the array after all the operations have been performed. Consecutive elements should be separated by a single space. 
Example: 
Input: 
4 
4i5i0i6i0 
5i5i4i3i2i1 
6i5i3i7i6i4i2 
7i5i3i7i6i4i2r 

Output: 
0065 
12453 
243657 
34765 

and the testprogram is worth 5points. 
For eachdata structure, make sureyou usetheinterface name whendeclaringinstances(notthe class name).Forexample,youshould write: 
BSTree tree = new MyBSTree(); 
BHeap heap = new MyBHeap(); 

Thisis worth 2points for eachproblem in the assignment. 
Use the binary tree implemented inproblem 0. Note: All input must be read from the standard input stream, and all output must be written to the standard output stream. For this assignment, assume the input is correct. 

Problem 1: Sum of depths (15 points) 
Input: Same asproblem 0a. 
Output: For each test case output the sum of the depths of all the nodes. 
Example: 
Input: 
4 
4i5i0i6i0 
5i5i4i3i2i1 
6i5i3i7i6i4i2 
7i5i3i7i6i4i2r3 

Output: 
2 
10 
8 
6 

Abinary tree is balanced if the height of the two sub-trees of every node differ by at most 1. An equivalent recursive de�nition is: 
� 
thedifferencebetweentheheights of theleft sub-tree and theright sub-treeisat most 1, 

� 
both sub-trees arebalanced. 


Input: Same asproblem 0a. 
Output: For each test case determine if the tree isbalanced. 
Example: 
Input: 
4 
4i5i0i6i0 
5i5i4i3i2i1 
6i5i3i7i6i4i2 
7i5i3i7i6i4i2r3 

Output: 
YES 
NO 
YES 
YES 


Problem 3: Tree sort (15 points) 
Useabinary search treetosort alist of numbers.Whatistherunning timeofyour algorithm? 

Input: Theinput begins with the number t of test cases in a single line(t � 100). Eachof the next t lines 
starts with a number n (1 � n � 1000)followed byalist of n numbers m (1 � m � 1000000)to sort. 
Output: Foreach test caseoutputthenumbersinincreasing order. 
Example: 
Input: 

2 
45060 
554321 

Output: 
0056 
12345 

Use abinary heap to sort alist of numbers. Whatis the running time ofyour algorithm? 
Input: Theinput begins with the number t of test cases in a single line(t � 100). Eachof the next t lines starts with a number n (1 � n � 1000)followed byalist of n numbers m (1 � m � 1000000)to sort. 
Output: Foreach test caseoutputthenumbersinincreasing order. 
Example: 
Input: 
2 
45060 
554321 

Output: 
0056 
12345 


Submission. 
Submit a zip �le with the following �les: 
1. 
Code �les BSTree.java, MyBSTree.java, BHeap.java, and MyBHeap.java with your interfaces and implementations of the data structures; and code �les MyBSTreeTest.java and MyBHeapTest.java with the solution toproblems 0a and 0b. 

2. 
Four code �les SumOfDepths.java, BalancedTree.java, TreeSort.java 
and HeapSort.java with the solutions toproblems 1,2,3,and 4, respectively. 



IncludeyournameandA numberatthetop of each source �le.Namethe zip �le hw06 firstName lastName.zip.Forexample,ifyournameisJohnSmith,namethe �le hw06 John Smith.zip. 





