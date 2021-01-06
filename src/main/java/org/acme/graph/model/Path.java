package org.acme.graph.model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Path {
	
	private List<Edge> edges = new ArrayList<Edge>();
	
	
	public Path() {
		
	}
	
	
	public Path(List<Edge> edges){
		this.edges = edges;
	}
		
	
	public Collection<Edge> getEdges(){
		return this.edges;
	}
}
