package gis.algorithm;

import gis.GisException;
import gis.model.Graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class MaxFlowFinder {

    private Set<Integer> visitedVertices;
    private Graph graph;

    public MaxFlowFinder() {
        visitedVertices = new HashSet<>();
    }

    public List<String> find(Graph graph) throws GisException {
        this.graph = graph;
        if(!isConnected()) {
            throw new GisException("Invalid graph! Required connected graph");
        }
        int i= 0;
        while (i < 1_000_000_000) {

            ++i;
        }
        return null;
    }

    private boolean isConnected() {
        if (graph.getNumOfVertices() > 0) {
            clearVisitedVertices();
            DFS(0);
            return graph.getNumOfVertices() == visitedVertices.size();
        }
        return false;
    }

    private void clearVisitedVertices() {
        if (!visitedVertices.isEmpty())
            visitedVertices.clear();
    }

    private void DFS(int v) {
        visitedVertices.add(v);

        int[] adjacencyMatrix = graph.getAdjacencyMatrix()[v];
        IntStream.range(0, adjacencyMatrix.length)
                .filter(i -> adjacencyMatrix[i] > 0 && !visitedVertices.contains(i))
                .forEach(this::DFS);
    }
}
