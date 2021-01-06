package org.acme.graph.model;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.PrecisionModel;

/**
 * 
 * Un arc matérialisé par un sommet source et un sommet cible
 * 
 * @author MBorne
 *
 */
public class Edge {
	
	@JsonIdentityInfo(
			generator = ObjectIdGenerators.PropertyGenerator.class,
			property = "id"
	)
	
	
	/**
	 * Identifiant de l'arc
	 */
	private String id;

	/**
	 * Sommet initial
	 */
	private Vertex source;

	/**
	 * Sommet final
	 */
	private Vertex target;
	
	
	private LineString geometry;
	
	
	private static GeometryFactory gf = new GeometryFactory();
	
	
	Edge(Vertex source, Vertex target) {
		this.source = source;
		this.target = target;
		this.source.addOutEdge(this);
		this.target.addInEdge(this);
		this.geometry = gf.createLineString(new Coordinate[] {
	            getSource().getCoordinate(),
	            getTarget().getCoordinate()
	        });
	}
	

	public String getId() {
		return id;
	}

	
	public void setId(String id) {
		this.id = id;
	}

	@JsonIdentityReference(alwaysAsId=true)
	public Vertex getSource() {
		return source;
	}

	@JsonIdentityReference(alwaysAsId=true)
	public Vertex getTarget() {
		return target;
	}


	/**
	 * dijkstra - coût de parcours de l'arc (distance géométrique)
	 * 
	 * @return
	 */
	public double getCost() {
		return this.geometry.getLength();
	}

	
	@Override
	public String toString() {
		return id + " (" + source + "->" + target + ")";
	}

	
	@JsonSerialize(using = GeometrySerializer.class)
    public LineString getGeometry() {
        return this.geometry;
    }
	
	
	public void setGeometry(LineString geometry) {
		this.geometry = geometry;
	}
	
}
