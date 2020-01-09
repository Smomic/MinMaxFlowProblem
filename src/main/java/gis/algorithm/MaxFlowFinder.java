package gis.algorithm;

import gis.GisException;
import gis.model.Graph;

import java.util.*;
import java.util.stream.IntStream;

public class MaxFlowFinder {

    private Set<Integer> visitedVertices;
    private Graph graph;
    private int startVertex;
    private int endVertex;

    public MaxFlowFinder(int startVertex, int endVertex) {
        visitedVertices = new HashSet<>();
        this.startVertex = startVertex;
        this.endVertex = endVertex;
    }

    public List<String> find(Graph graph) throws GisException {
        this.graph = graph;
        if (!isConnected()) {
            throw new GisException("Invalid graph! Required connected graph");
        }
        if (startVertex == endVertex) {
            throw new GisException("Start vertex equals end vertex");
        }
        int i = 0;
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

    /**
     * Finding path with maximum flow in directed graph using modified Dijkstra algorithm
     * Base algorithm: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
     *
     * @param graph directed graph
     * @return maximum flow value
     */
    public int[] findMaximumFlow(Graph graph) {
        int numberOfVertices = graph.getNumOfVertices();
        int[] dist = new int[numberOfVertices];             //dist[i] - shortest distance from startVertex to i
        Boolean[] sptSet = new Boolean[numberOfVertices];   //sptSet[i] == true if vertex i is included in shortest path

        for (int i = 0; i < numberOfVertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[startVertex] = 0;

        for (int count = 0; count < numberOfVertices - 1; count++) {
            int u = chooseMinDistanceVertex(dist, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < numberOfVertices; v++) {
                if (!sptSet[v] && graph.getAdjacencyMatrix()[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph.getAdjacencyMatrix()[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph.getAdjacencyMatrix()[u][v];
                }
            }
        }

        return dist;
    }


    /**
     * Chooses vertex with minimum distance value
     *
     * @param dist array of distances
     * @param sptSet array with information whether vertex in included in path or not
     * @return selected vertex
     */
    private int chooseMinDistanceVertex(int[] dist, Boolean[] sptSet)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < dist.length; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }
}
