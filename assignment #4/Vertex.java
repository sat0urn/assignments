import java.util.*;

public class Vertex<T> {
    private T data;
    private final Map<T, Double> adjacentVertices = new HashMap<>();

    public void addAdjacentVertex(T destination, double weight) {
       adjacentVertices.put(destination, weight);
    }

    public Vertex() {}
    public Vertex(T data) {
        this.data = data;
    }

    public T takeValue(Vertex<T> vertexData) {
        return vertexData.data;
    }

    public int sizeOfAdjVertices() {
        return adjacentVertices.size();
    }

    public boolean contains(Vertex<T> vertex) {
        return adjacentVertices.containsValue(vertex);
    }

    public boolean hasItEdge(T vertexData) {
        return adjacentVertices.containsKey(vertexData);
    }

    public Set<T> findValueOfAdjacentVertex() {
        return adjacentVertices.keySet();
    }
}
