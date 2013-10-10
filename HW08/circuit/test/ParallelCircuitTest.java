// Nate Graham	A00305171



package cs5060.homework.hw08.circuit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cs5060.homework.hw08.circuit.Capacitor;
import cs5060.homework.hw08.circuit.CapacitorCircuit;
import cs5060.homework.hw08.circuit.ParallelCircuit;

public class ParallelCircuitTest {

	@Test
	public void testParellelCircuit() {
		
		// test that constructor of doubles constructs capacitors and inserts them into capCircuit ArrayList
		ParallelCircuit pc = new ParallelCircuit(1.0, 2.7, 4.7);
		
		assertTrue(pc instanceof CapacitorCircuit);
		assertTrue(pc instanceof ParallelCircuit);
		
		assertEquals(3, pc.getCapacitorCount());
		
		
		// test constructor of capacitors gets added to capCircuit ArrayList
		Capacitor one = new Capacitor(.5);
		Capacitor two = new Capacitor(6.8);
		Capacitor three = new Capacitor(1.0);
		
		ParallelCircuit pc2 = new ParallelCircuit(one, two, three);
		
		assertTrue(pc2 instanceof CapacitorCircuit);
		assertTrue(pc2 instanceof ParallelCircuit);
		
		assertEquals(3, pc2.getCapacitorCount());
		
	}


	@Test
	public void testGetCapacitance() {
		
		ParallelCircuit pc = new ParallelCircuit(3.3, 0.1, 4.4);
		assertEquals(7.8, pc.getCapacitance(), .01);
		
	}

	@Test
	public void testGetCapacitorCount() {
		
		ParallelCircuit pc = new ParallelCircuit(3.3, 0.1, 4.4);
		assertEquals(3, pc.getCapacitorCount());
	}

}
