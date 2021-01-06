package org.acme.graph.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vividsolutions.jts.geom.Coordinate;

/**
 * 
 * Un sommet dans un graphe
 * 
 * @author MBorne
 *
 */
public class Vertex {

	/**
	 * Identifiant du sommet
	 */
	private String id;

	/**
	 * Position du sommet
	 */
	private Coordinate coordinate;


	
	/**
	 * Liste des arcs entrant dans ce sommet
	 */
	private List<Edge> inEdges = new ArrayList<Edge>();
	
	
	/**
	 * Liste des arcs sortant de ce sommet
	 */
	private List<Edge> outEdges = new ArrayList<Edge>();

	Vertex() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}


	
	@JsonIgnore
	public Collection<Edge> getInEdge(){
		return this.inEdges;
	}
	
	
	@JsonIgnore
	public Collection<Edge> getOutEdges(){
		return this.outEdges;
	}
	
	
	void addInEdge(Edge edge) {
		this.inEdges.add(edge);
	}
	
	
	void addOutEdge(Edge edge) {
		this.outEdges.add(edge);
	}

	@Override
	public String toString() {
		return id;
	}

}
