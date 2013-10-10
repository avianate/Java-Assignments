// Nate Graham	A00305171



package cs5060.homework.hw08.circuit;

public class Capacitor extends CapacitorCircuit {
	
	private double capValue;
	private int count;
	
	public Capacitor(double value) {
		capValue = value;
		count = 1;
	}

	@Override
	public int getCapacitorCount() {
		
		return count;
	}

	@Override
	public double getCapacitance() {
		
		return capValue;
	}

	

}
