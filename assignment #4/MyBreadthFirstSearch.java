//import original.Search;
//
//import java.util.*;
//
//public class MyBreadthFirstSearch<Vertex> extends Search<Vertex> {
//
//    public MyBreadthFirstSearch(MyWeightedGraph<Vertex> graph, Vertex source) {
//        super(source);
//        bfs(graph, source);
//    }
//
//    private void bfs(MyWeightedGraph<Vertex> graph, Vertex current) {
//        marked.add(current);
//        Queue<Vertex> queue = new LinkedList<>();
//        queue.add(current);
//        while (!queue.isEmpty()) {
//            Vertex v = queue.remove();
//            for (Vertex vertex : graph.adjacencyList(v)) {
//                if (!marked.contains(vertex)) {
//                    marked.add(vertex);
//                    edgeTo.put(vertex, v);
//                    queue.add(vertex);
//                }
//            }
//        }
//    }
//}