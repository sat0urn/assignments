import java.util.*;

public class MyWeightedGraph<T> {
    private final boolean undirected;
    private Set<Vertex<T>> set = new HashSet<>();

    public MyWeightedGraph() {
        this.undirected = true;
    }

    public MyWeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex<T> v) {
        set.add(v);
    }

    public void addEdge(T source, T dest, double weight) {
        Vertex<T> obj;
        if (!hasVertex(source))
            addVertex(new Vertex<>(source));

        if (!hasVertex(dest))
            addVertex(new Vertex<>(dest));

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

        for (Vertex<T> vertex : set)
            if (source == vertex.takeValue(vertex))
                vertex.addAdjacentVertex(dest, weight);


        if (undirected)
            for (Vertex<T> vertex : set)
                if (dest == vertex.takeValue(vertex))
                    vertex.addAdjacentVertex(source, weight);

    }

    public int getVerticesCount() {
        return set.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex<T> v : set) {
            count += v.sizeOfAdjVertices();
        }
        if (undirected)
            count /= 2;

        return count;
    }


    public boolean hasVertex(T v) {
        for (Vertex<T> vertex : set)
            if ((vertex.takeValue(vertex) == v))
                return true;
        return false;
    }

    public boolean hasEdge(T source, T dest) {
        for (Vertex<T> vertex : set)
            if (source == vertex.takeValue(vertex))
                return vertex.hasItEdge(dest);
        return false;
    }

    public Set<T> adjacencyList(T v) {
        Set<T> obj = null;
        if (!hasVertex(v)) return null;
        for (Vertex<T> e : set) {
            if (e.takeValue(e) == v) {
                obj = e.findValueOfAdjacentVertex();
            }
        }
        return obj;
    }

    public Set<Vertex<T>> getEdges(T v) {
        if (!hasVertex(v)) return null;
        return set;
    }
}
