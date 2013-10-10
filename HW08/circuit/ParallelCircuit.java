// Nate Graham	A00305171



package cs5060.homework.hw08.circuit;

import java.util.ArrayList;

public class ParallelCircuit extends CapacitorCircuit {
	

	private ArrayList<CapacitorCircuit> capCircuit;
	
	
	// constructor will create capacitors if doubles are passed in as arg
	public ParallelCircuit(double... args) {
		
		capCircuit = new ArrayList<CapacitorCircuit>();
		
		for (double arg : args)
		{
			Capacitor cap = new Capacitor(arg);
			capCircuit.add(cap);
		}
	}
	
	// constructor for inserting capacitors into capCircuit array
	public ParallelCircuit(CapacitorCircuit... args)
	{
		capCircuit = new ArrayList<CapacitorCircuit>();
		
		for(CapacitorCircuit arg : args)
		{
			capCircuit.add(arg);
		}
	}


	@Override
	public int getCapacitorCount() {
		
		int count = 0;
		
		for (int i = 0; i < capCircuit.size(); i++)
			count += capCircuit.get(i).getCapacitorCount();
		
		return count;
	}

	@Override
	public double getCapacitance() {
		
		// parallel capacitance: Total C = C1 + C2 ... Cn
		
		double total = 0;
		
		for (int i = 0; i < capCircuit.size(); i++)
		{
			total += capCircuit.get(i).getCapacitance();
		}
		
		return total;
	}

}
