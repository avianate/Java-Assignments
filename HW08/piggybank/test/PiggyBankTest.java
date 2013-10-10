// Nate Graham	A00305171



package cs5060.homework.hw08.piggybank.test;

import static org.junit.Assert.*; 
import org.junit.Test;

import cs5060.homework.hw08.piggybank.*;

public class PiggyBankTest {

	static float PENNY = (float) 0.01;
	static float NICKEL = (float) 0.05;
	static float DIME = (float) 0.10;
	static float QUARTER = (float) 0.25;
	
	PiggyBank myBank = new PiggyBank(4);
	Coin penny = new Coin(PENNY);
	Coin nickel = new Coin(NICKEL);
	Coin dime = new Coin(DIME);
	Coin quarter = new Coin(QUARTER);
	
	
	

	@Test
	public void testPiggyBank() {
		
		// test to make sure contructor sets maximum capacity of piggy bank
		PiggyBank bank = new PiggyBank(2);
		
		assertTrue(bank instanceof PiggyBank);
		assertTrue(bank.getCapacity() == 2);
		assertFalse(bank.getCapacity() == 0);
	}

	@Test
	public void testIsEmpty() {
		
		assertTrue(myBank.isEmpty());

		myBank.addCoin(penny);
		
		assertFalse(myBank.isEmpty());
	}

	@Test
	public void testIsFull() {
		
		assertFalse(myBank.isFull());
		
		myBank.addCoin(penny);
		assertFalse(myBank.isFull());
		
		myBank.addCoin(nickel);
		assertFalse(myBank.isFull());
		
		myBank.addCoin(dime);
		assertFalse(myBank.isFull());
		
		
		// test piggy bank is now full
		myBank.addCoin(quarter);
		assertTrue(myBank.isFull());
		
		
		// test isFull() returns false when piggy bank is broken 
		try {
			myBank.breakBank();
		}
		catch (BrokenPiggyBankException e) {
			fail("PiggyBank should not be broken yet");
		}
		assertFalse(myBank.isFull());
	}

	@Test
	public void testGetCapacity() {
		
		assertTrue(myBank.getCapacity() == 4);
		assertTrue(myBank.getCapacity() != 3);
	}

	@Test
	public void testAddCoin() {
		
		assertTrue(myBank.isEmpty());
		myBank.addCoin(penny);
		assertFalse(myBank.isEmpty());
		
		// test for FullPiggyBankException when trying to add a coin to an already full piggy bank
		myBank.addCoin(nickel);
		myBank.addCoin(dime);
		myBank.addCoin(quarter);
		
		assertTrue(myBank.isFull());
		
		try {
			myBank.addCoin(quarter);
			throw new FullPiggyBankException();
		}
		catch (FullPiggyBankException e) {
			assertTrue(true);
		}
		
		
		
		// test for BrokenPiggyBankException when trying to add a coin to a broken piggy bank
		try {
			myBank.breakBank();
		} 
		catch (BrokenPiggyBankException e) {
			fail("Bank should not already be broken");
		}
		
		assertTrue(myBank.isBroken());
		
		
		try {
			myBank.addCoin(dime);
			throw new BrokenPiggyBankException();
		}
		catch (BrokenPiggyBankException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testGetNumberOfCoins() {
		
		assertTrue(myBank.getNumberOfCoins() == 0);
		myBank.addCoin(penny);
		assertTrue(myBank.getNumberOfCoins() == 1);
		
		myBank.addCoin(nickel);
		assertTrue(myBank.getNumberOfCoins() == 2);
		
		myBank.addCoin(dime);
		assertTrue(myBank.getNumberOfCoins() == 3);
		
		myBank.addCoin(quarter);
		assertTrue(myBank.getNumberOfCoins() == 4);
	}

	@Test
	public void testGetTotalValue() {
		
		assertTrue(myBank.getTotalValue() == 0);
		
		myBank.addCoin(penny);
		myBank.addCoin(nickel);
		myBank.addCoin(dime);
		myBank.addCoin(quarter);
				
		assertTrue(myBank.getTotalValue() == (float) 0.41);
		
	}

	@Test
	public void testIsBroken() {
		
		assertFalse(myBank.isBroken());
		
		try {
			myBank.breakBank();
		} 
		catch (BrokenPiggyBankException e) {
			fail("Piggy bank should not already be broken");
		}
		
		assertTrue(myBank.isBroken());
		
	}

	@Test
	public void testBreakBank() {
		
		assertFalse(myBank.isBroken());
		
		myBank.addCoin(penny);
		myBank.addCoin(nickel);
		myBank.addCoin(dime);
		myBank.addCoin(quarter);
		
		
		try {
			myBank.breakBank();
		} 
		catch (BrokenPiggyBankException e) {
			fail("PiggyBank should not already be broken");
		}
		
		assertTrue(myBank.isBroken());
		assertTrue(myBank.isEmpty());
		
		// bank is already broken, calling breakBank() again will throw BrokenPiggyBankEx
		try {
			myBank.breakBank();
		} 
		catch (BrokenPiggyBankException e) {
			assertTrue(myBank.isBroken());
		}
		
		// test to ensure that numberOfCoins is reset to zero after piggy bank is broken
		assertTrue(myBank.getNumberOfCoins() == 0);
	}

}
