// Nate Graham	A00305171



package cs5060.homework.hw08.piggybank;

import java.util.ArrayList;

public class PiggyBank {
	
	int capacity;
	ArrayList<Coin> coinsInBank;
	int numberOfCoins;
	float totalValue;
	boolean isBroken;
	
	
	public PiggyBank(int max)
	{
		capacity = max;
		coinsInBank = new ArrayList<Coin>();
	}

	public boolean isEmpty()
	{
		// if isBroken return true
		if (isBroken() || numberOfCoins <= 0)
			return true;
		
		return false;
	}
	
	
	public boolean isFull()
	{
		// will return false is piggy bank is broken
		if (getNumberOfCoins() == getCapacity() && !isBroken)
			return true;
		
		return false;
	}
	
	public int getCapacity()
	{
		return capacity;
	}
	
	
	public void addCoin(Coin newCoin)
	{
		if (isFull())
		{
			try {
				throw new FullPiggyBankException();
			}
			catch (FullPiggyBankException e) {
				System.out.println(e);
			}
		}
		else if (isBroken())
		{
			try {
				throw new BrokenPiggyBankException();
			} 
			catch (BrokenPiggyBankException e) {
				System.out.println(e);
			}
		}
		else
		{
			coinsInBank.add(newCoin);
			numberOfCoins += 1;
			totalValue += newCoin.getValue();
		}
	}
	
	public int getNumberOfCoins()
	{
		// return 0 when piggy bank is broken
		if (isBroken())
			return 0;
		
		return numberOfCoins;
	}
	
	public float getTotalValue()
	{
		if (isBroken)
			return 0;
		
		return totalValue;
	}
	
	public boolean isBroken()
	{
		return isBroken;
	}
	
	public void breakBank() throws BrokenPiggyBankException
	{
		if (isBroken())
		{
			throw new BrokenPiggyBankException();
		}
		
		else
		{
			isBroken = true;
		
			// return a list of all the coins
			while (!coinsInBank.isEmpty())
			{
				System.out.println(coinsInBank.get(0).getValue());
				
				coinsInBank.remove(0);
			}
			
			numberOfCoins = 0;
		}
	}
	
}
