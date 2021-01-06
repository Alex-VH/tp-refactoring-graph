package org.acme.graph.model;

import static org.junit.Assert.*;

import org.acme.graph.TestGraphFactory;
import org.junit.Test;

public class EdgeTest {
	
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testGetGeometry() {
		Graph g = TestGraphFactory.createGraph01();
		
		assertEquals(0.0,g.getEdges().get(0).getGeometry().getPointN(0).getX(),EPSILON);
		assertEquals(0.0,g.getEdges().get(0).getGeometry().getPointN(0).getY(),EPSILON);
		assertEquals(1.0,g.getEdges().get(0).getGeometry().getPointN(1).getX(),EPSILON);
		assertEquals(0.0,g.getEdges().get(0).getGeometry().getPointN(1).getY(),EPSILON);
	}

}
