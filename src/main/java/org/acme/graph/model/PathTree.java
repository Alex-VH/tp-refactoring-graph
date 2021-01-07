package org.acme.graph.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PathTree {
	
	private static final Logger log = LogManager.getLogger(PathTree.class);
	
	
	private Map<Vertex,PathNode> nodes = new HashMap<Vertex,PathNode>();
	
	
	public PathTree(Graph graph, Vertex origin){
		log.trace("initGraph({})", origin);
		for (Vertex vertex : graph.getVertices()) {
			PathNode pn = new PathNode();
			pn.setCost(origin == vertex ? 0.0 : Double.POSITIVE_INFINITY);
			pn.setReachingEdge(null);
			pn.setVisited(false);
			this.nodes.put(vertex, pn);
		}
	}
	
	
	public List<Edge> getPath(Vertex target) {
		List<Edge> result = new ArrayList<Edge>();

		Edge current = this.getNode(target).getReachingEdge();
		do {
			result.add(current);
			current = this.getNode(current.getSource()).getReachingEdge();
		} while (current != null);

		Collections.reverse(result);
		return result;
	}
	
	
	public PathNode getNode(Vertex vertex) {
		return this.nodes.get(vertex);
		
	}
	
	
	
}
