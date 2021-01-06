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
	 * dijkstra - coût pour atteindre le sommet
	 */
	private double cost;
	/**
	 * dijkstra - arc entrant avec le meilleur coût
	 */
	private Edge reachingEdge;
	/**
	 * dijkstra - indique si le sommet est visité
	 */
	private boolean visited;
	
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@JsonIgnore
	public Edge getReachingEdge() {
		return reachingEdge;
	}

	public void setReachingEdge(Edge reachingEdge) {
		this.reachingEdge = reachingEdge;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	@JsonIgnore
	public Collection<Edge> getInEdge(){
		return this.inEdges;
	}
	
	
	@JsonIgnore
	public Collection<Edge> getOutEdge(){
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
