// Nate Graham	A00305171



package cs5060.homework.hw08.circuit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cs5060.homework.hw08.circuit.Capacitor;
import cs5060.homework.hw08.circuit.CapacitorCircuit;
import cs5060.homework.hw08.circuit.ParallelCircuit;
import cs5060.homework.hw08.circuit.SeriesCircuit;

public class CapacitorCircuitTest {

	@Test
	public void testCapacitorCircuit() {
		
		// test that SeriesCircuit and ParallelCircuit can be instantiated as CapacitorCircuit types
		CapacitorCircuit sc = new SeriesCircuit(10.0, 10.0);
		CapacitorCircuit pc = new ParallelCircuit(3.3, 4.7);
		
		assertTrue(sc instanceof CapacitorCircuit);
		assertTrue(sc instanceof SeriesCircuit);
		
		assertTrue(pc instanceof CapacitorCircuit);
		assertTrue(pc instanceof ParallelCircuit);
		
		assertFalse(sc instanceof ParallelCircuit);
		assertFalse(pc instanceof SeriesCircuit);
	}

	@Test
	public void testGetCapacitorCount() {
		
		CapacitorCircuit sc = new SeriesCircuit(0.1, 10.0);
		CapacitorCircuit pc = new ParallelCircuit(6.8, 0.33, 1.0);
		
		assertEquals(2, sc.getCapacitorCount());
		assertEquals(3, pc.getCapacitorCount());
	}

	@Test
	public void testGetCapacitance() {
		
		Capacitor one = new Capacitor(10.0);
		Capacitor two = new Capacitor(10.0);
		Capacitor three = new Capacitor(3.3);
		Capacitor four = new Capacitor(4.7);
		
		CapacitorCircuit sc = new SeriesCircuit(one, two);					// Total capacitance = 5
		CapacitorCircuit pc = new ParallelCircuit(three, four, sc);			// Total capacitance = 8 + 5 = 13
		assertEquals(13.0, pc.getCapacitance(), 0.01);
		
		CapacitorCircuit scpc = new SeriesCircuit(one, two, pc);			// 1/Total = 1/10 + 1/10 + 1/13 = 3.61
		assertEquals(3.61, scpc.getCapacitance(), 0.01);
		
	}

}
