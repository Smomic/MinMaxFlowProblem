package gis.algorithm;

import gis.model.Graph;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class ConnectionFinder {

    private Set<Integer> visitedVertices;

    public ConnectionFinder() {
        this.visitedVertices = new HashSet<>();
    }

    public boolean isConnected(Graph graph) {
        if (graph.getNumOfVertices() > 0) {
            clearVisitedVertices();
            DFS(0, graph);
            return graph.getNumOfVertices() == visitedVertices.size();
        }
        return false;
    }

    private void clearVisitedVertices() {
        if (!visitedVertices.isEmpty())
            visitedVertices.clear();
    }

    private void DFS(int v, Graph graph) {
        visitedVertices.add(v);

        int[] adjacencyMatrix = graph.getAdjacencyMatrix()[v];
        IntStream.range(0, adjacencyMatrix.length)
                .filter(i -> adjacencyMatrix[i] > 0 && !visitedVertices.contains(i))
                .forEach(i -> DFS(i, graph));
    }
}
