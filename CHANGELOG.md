# Historique des changements

(TODO correspond à l'identifiant d'un problème à traiter pour la prochaine version)

## TODO 0.3 - Indexation des arcs entrants et sortant
En lisant attentivement DijsktraPathFinder (ou un utilisant un outil tel VisualVM), on remarque une méthode findOutEdges(vertex: Vertex) appelée très fréquemment dans la méthode visit(vertex: Vertex). Cette approche étant loin d'être optimale, on va indexer les arcs sortants et entrants comme suit :

* Ajout des attributs inEdges: List<Edge> et outEdges: List<Edge> sur Vertex
* Ajout des getters getInEdges(): Collection<Edge> et getOutEdges(): Collection<Edge> sur Vertex
* Remplissage automatique de inEdges et outEdges dans le constructeur Edge(source,target)
* Suppression de setSource et setTarget dans Edge (pas besoin d'une topologie éditable, innutile de gérer la complexité pour inEdges et outEdges)
* Suppression de findOutEdges dans DijkstraPathFinder et utilisation de getOutEdges
* Exclusion de inEdges et outEdges des résultats de l'API (@JsonIgnore)
* Ajout de tests

Remarque : Nous n'avons pas besoin pour l'algorithme actuel des inEdges mais il semble préférable au moins dans un premier temps de conserver une symétrie dans le modèle.
