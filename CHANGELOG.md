# Historique des changements

(TODO correspond à l'identifiant d'un problème à traiter pour la prochaine version)

## TODO 0.2 - Ajout de fabriques pour les sommets et les arcs
En ajoutant un constructeur Edge(source: Vertex, target: Vertex), on remarque que l'on a simplifié la création des arcs et des sommets.

Toutefois, les opérations de création demeurent complexes et il reste la possibilité d'oublier d'ajouter les éléments aux listes de vertices et edges du graphe.

On va donc procéder comme suit :

 *  Ajout d'une fabrique createVertex(coordinate,id): Vertex dans Graph
 *  Ajout d'une fabrique createEdge(source,target,id): Edge dans Graph
 *  Masquage des constructeur Vertex() et Edge(source,target)
 *  Suppression de Graph.setVertices(vertices) et Graph.setEdges(edges)
 
Ainsi, on passera de :

```java
Vertex a = new Vertex();
a.setId("a");
a.setCoordinate(new Coordinate(0.0, 0.0));
graph.getVertices().add(a);

Vertex b = new Vertex();
b.setId("b");
b.setCoordinate(new Coordinate(1.0, 0.0));
graph.getVertices().add(b);

Edge ab = new Edge(a,b);
ab.setId("ab");
graph.getEdges().add(ab);
```
à

```java
Vertex a = graph.createVertex(new Coordinate(0.0, 0.0),"a");
Vertex b = graph.createVertex(new Coordinate(1.0, 0.0),"b");
Edge ab  = graph.createEdge(a,b,"ab");
```

