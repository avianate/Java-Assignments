// Nate Graham	A00305171



package cs5060.homework.hw08.circuit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cs5060.homework.hw08.circuit.Capacitor;
import cs5060.homework.hw08.circuit.CapacitorCircuit;

public class CapacitorTest {
	
	Capacitor cap1 = new Capacitor(1);
	Capacitor cap2 = new Capacitor(4.7);

	@Test
	public void testCapacitor() {
		
		Capacitor cap = new Capacitor(2.7);
		
		assertTrue(cap instanceof CapacitorCircuit);
		assertTrue(cap instanceof Capacitor);
	}

	@Test
	public void testGetCapacitance() {
	
		assertEquals(cap1.getCapacitance(), 1, .1);
		assertEquals(cap2.getCapacitance(), 4.7, .1);
		
	}
	
	@Test
	public void testGetCapacitorCount() {
		
		assertTrue(cap1.getCapacitorCount() == 1);
		
	}

}
