Homework 8 
Classes 

CS5060 IntensiveProgramming,Fall2012 
74points 
Due: 3:59pmNovember 19,2012 

Assignment description 
Inthis assignmentyouwillhavetocreate classes, useinheritance and usepolymorphism. 

Computing the capacitance of a circuit (32 points) 
Circuit classes (15 points): Create the following classes, similar to the ones for computing the resistance explained during lecture, to compute the total capacitance of a circuit with multiple capacitors: 
� 
CapacitorCircuit (2points), 

� 
SeriesCCircuit as a subclass of CapacitorCircuit (3points), 

� 
ParallelCCircuit as a subclass of CapacitorCircuit (3points), 


� Capacitor (2points). The CapacitorCircuit mustbeanabstract classwith thefollowing methods: 
� 
getCapacitorCount() which returns the total number of capacitors in the circuit(3points), and 

� 
getCapacitance() which returnsthetotal capacitance of thecircuit(2points).1 


Unit tests (15 points): Create classes: 
� 
CapacitorCircuitTest (4points), 

� 
SeriesCCircuitTest (4points), 

� 
ParallelCCircuitTest (4points), 

� 
CapacitorTest (3points) 


totest each one ofyour classes. You shouldtest allthepublic methods ofyour classes(remembertotest circuitsthathave acombination of series andparallel sub-parts). 
Packages (2 points): 
� 
Putyour classesinapackage named: cs5060.homework.hw08.circuit. 

� 
Putyourtest classesinapackage named: cs5060.homework.hw08.circuit.test. 


1Refer to http://en.wikipedia.org/wiki/Series_and_parallel_circuits 
forformulas. 
1 


Piggy bank (42 points) 
Piggy bank classes (19 points): Create a Coin classwith thefollowing methods(2points): 
� 	constructor with avalueparameter(1point), 
� getValue() method which returnsthevalueof thecoin(1point). Create a PiggyBank classwith thefollowing methods(17points): 
� 	
constructor with capacity(maximumnumberof coinsthepiggy bank canhold)parameter(1point), 

� 	
isEmpty() method(1point), 

� 	
isFull() method(2point), 

� 	
getCapacity() method(1point), 

� 	
addCoin(Coin) method(3points), 

� 	
getNumberOfCoins() method(2points), 

� 	
getTotalValue() method(3points), 

� 	
isBroken() method(1point), 

� 	
breakBank() method(3point). 


Notes (4 points): 
� 	
isEmpty should return true when thepiggy bank is broken. 

� 	
isFull should return false when thepiggy bank is broken. 

� 	
addCoin should throw FullPiggyBankException (2points)whenthepiggy bankisfull. 

� 	
addCoin should throw BrokenPiggyBankException (2 points) when the piggy bank is bro�ken. 

� 	
getNumberOfCoins and getTotalValue should return 0 when thepiggy bank is broken. 

� 	
breakBank should return a list of all the coins, and throw a BrokenPiggyBankException if thepiggy bank is already broken. 

� 	
MakeFullPiggyBankException and BrokenPiggyBankException subclasses of Exception. 


Unit tests (17 points): Create a PiggyBankTest classtotestthe methods ofyour PiggyBank class. Create a test method for each method you have to test. The tests for each method of the PiggyBank class are worth the same as the method. 
Packages (2 points): 
� 	
Putyour classesinapackage named: cs5060.homework.hw08.piggybank. 

� 	
Putyourtest classesinapackage named: cs5060.homework.hw08.piggybank.test. 


2 


Submission. 
Submit a zip �lewithyourcode �les.Makesureyouincludethepackagefolders. 
IncludeyournameandA numberatthetop of each source �le.Namethe zip �le hw08 firstName lastName.zip.Forexample,ifyournameisJohnSmith,namethe �le hw08 John Smith.zip. 




3 


