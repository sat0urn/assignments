package original;

public interface IGraph<Vertex> {
    void addVertex(Vertex v);
    void addEdge(Vertex source, Vertex dest);
    int getVerticesCount();
    int getEdgesCount();
    boolean hasVertex(Vertex v);
    boolean hasEdge(Vertex source, Vertex dest);
    Iterable<Vertex> adjacencyList(Vertex v);
}
