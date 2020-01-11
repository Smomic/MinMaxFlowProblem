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
        Graph nonDirectedGraph = convertToNonDirectedGraph(graph);
        if (nonDirectedGraph.getNumOfVertices() > 0) {
            clearVisitedVertices();
            DFS(0, nonDirectedGraph);
            return nonDirectedGraph.getNumOfVertices() == visitedVertices.size();
        }
        return false;
    }

    private Graph convertToNonDirectedGraph(Graph directedGraph) {
        int numOfVertices = directedGraph.getNumOfVertices();
        int[][] newAdjacencyMatrix = new int[numOfVertices][numOfVertices];

        for(int i = 0; i < numOfVertices; ++i) {
            for(int j = 0; j < numOfVertices; ++j) {
                if (directedGraph.isEgdeExist(i, j) || directedGraph.isEgdeExist(j, i)) {
                    newAdjacencyMatrix[i][j] = newAdjacencyMatrix[j][i] = 1;
                }
            }
        }

        return new Graph(newAdjacencyMatrix, numOfVertices, directedGraph.getNumOfEdges() * 2);
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
