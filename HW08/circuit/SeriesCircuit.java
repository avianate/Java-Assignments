// Nate Graham	A00305171



package cs5060.homework.hw08.circuit;

import java.util.ArrayList;




public class SeriesCircuit extends CapacitorCircuit {

	private ArrayList<CapacitorCircuit> capCircuit;

	// constructor will create capacitors if doubles are passed in as args
	public SeriesCircuit(double... args)
	{
		capCircuit = new ArrayList<CapacitorCircuit>();

		for (double arg : args)
		{
			Capacitor cap = new Capacitor(arg);
			capCircuit.add(cap);
		}
	}

	
	// constructor for inserting capacitors into capCircuit array
	public SeriesCircuit(CapacitorCircuit... args) {

		capCircuit = new ArrayList<CapacitorCircuit>();

		for (CapacitorCircuit arg : args)
			capCircuit.add(arg);
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

		// Series capacitance: 1/Total = 1/C + 1/C ... 1/Cn

		double total = 0;

		for (int i = 0; i < capCircuit.size(); i++)
		{
			total += 1 / (capCircuit.get(i).getCapacitance());
		}
		
		return 1 / total;
	}


}
