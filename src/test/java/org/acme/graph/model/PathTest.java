package org.acme.graph.model;

import static org.junit.Assert.*;

import org.acme.graph.TestGraphFactory;
import org.junit.Test;

import com.vividsolutions.jts.geom.Coordinate;

public class PathTest {

	@Test
	public void testPath() {
		Path p = new Path();
		assertNotEquals(null, p);
		assertEquals(0, p.getEdges().size());
	}

	@Test
	public void testPathListOfEdge() {
		Graph graph = TestGraphFactory.createGraph01();
		Path p = new Path(graph.getEdges());
		assertNotEquals(null, p.getEdges());
		assertEquals(3, p.getEdges().size());
	}
}
