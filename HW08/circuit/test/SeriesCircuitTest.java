// Nate Graham	A00305171



package cs5060.homework.hw08.circuit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cs5060.homework.hw08.circuit.Capacitor;
import cs5060.homework.hw08.circuit.CapacitorCircuit;
import cs5060.homework.hw08.circuit.SeriesCircuit;

public class SeriesCircuitTest {

	
	@Test
	public void testSeriesCircuit() {
		
		// test that constructor of doubles constructs capacitors and inserts them into capCircuit ArrayList
		SeriesCircuit sc = new SeriesCircuit(1.0, 2.7, 4.7);
		
		assertTrue(sc instanceof CapacitorCircuit);
		assertTrue(sc instanceof SeriesCircuit);
		
		assertEquals(3, sc.getCapacitorCount());
		
		
		
		// test constructor of capacitors gets added to capCircuit ArrayList
		Capacitor one = new Capacitor(.5);
		Capacitor two = new Capacitor(6.8);
		Capacitor three = new Capacitor(1.0);
		
		SeriesCircuit sc2 = new SeriesCircuit(one, two, three);
		
		assertTrue(sc2 instanceof CapacitorCircuit);
		assertTrue(sc2 instanceof SeriesCircuit);
		
		assertEquals(3, sc2.getCapacitorCount());
		
	}
	
	@Test
	public void testGetCapacitance() {
		
		SeriesCircuit sc = new SeriesCircuit(10, 10, 10);
		assertEquals(3.33, sc.getCapacitance(), .01);
		
		
		Capacitor one = new Capacitor(12);
		Capacitor two = new Capacitor(12);
		Capacitor three = new Capacitor(12);
		
		SeriesCircuit sc2 = new SeriesCircuit(one, two, three);
		assertEquals(4.0, sc2.getCapacitance(), 0.1);
		
	}
	
	@Test
	public void testGetCapacitorCount() {
		
		SeriesCircuit sc = new SeriesCircuit(10, 10, 10);
		
		assertEquals(3, sc.getCapacitorCount());
		
	}
}
