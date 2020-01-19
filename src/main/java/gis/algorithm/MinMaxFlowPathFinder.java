package gis.algorithm;

import gis.model.Graph;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MinMaxFlowPathFinder {

    private int startVertex;
    private int endVertex;
    private Graph graph;

    private static final int START_VERTEX_PARENT = -1;

    public MinMaxFlowPathFinder(int startVertex, int endVertex) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
    }

    /**
     * Finding path with maximum flow in directed graph using modified Dijkstra algorithm
     * Base algorithms: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
     * https://stackoverflow.com/questions/18552964/finding-path-with-maximum-minimum-capacity-in-graph
     *
     * @return Pair of maximum flow value and found path
     */
    public Pair<Integer, List<Integer>> findMaximumFlowPath() {
        int numberOfVertices = graph.getNumOfVertices();
        int[] dist = new int[numberOfVertices];             //dist[i] - shortest distance from startVertex to i
        boolean[] sptSet = new boolean[numberOfVertices];   //sptSet[i] == true if vertex i is included in shortest path, initialize as false

        initializeDistance(numberOfVertices, dist, Integer.MAX_VALUE, Integer.MIN_VALUE);
        int[] parents = new int[numberOfVertices];          //array for storing paths
        parents[startVertex] = START_VERTEX_PARENT;         //starting vertex doesn't have parent


        for (int count = 0; count < numberOfVertices - 1; count++) {
            int u = chooseMaxDistanceVertex(dist, sptSet);

            if (dist[u] == Integer.MIN_VALUE || u == endVertex)
                break;

            sptSet[u] = true;

            IntStream.range(0, numberOfVertices)
                    .filter(v -> !sptSet[v] && graph.isEgdeExist(u, v))
                    .forEach(v -> findMaxDistance(dist, parents, u, v));
        }

        List<Integer> resultPath = new ArrayList<>();
        collectPath(endVertex, parents, resultPath);
        return new MutablePair<>(dist[endVertex], resultPath);
    }

    private void findMaxDistance(int[] dist, int[] parents, int u, int v) {
        int newDist = Math.max(dist[v], Math.min(dist[u], graph.getAdjacencyMatrix()[u][v]));

        if (newDist > dist[v]) {
            dist[v] = newDist;
            parents[v] = u;
        }
    }

    /**
     * Finding path with minimum flow in directed graph using modified Dijkstra algorithm
     * Base algorithms: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
     * https://stackoverflow.com/questions/18552964/finding-path-with-maximum-minimum-capacity-in-graph
     *
     * @return Pair of minimum flow value and found path
     */
    public Pair<Integer, List<Integer>> findMinimumFlowPath() {
        int numberOfVertices = graph.getNumOfVertices();
        int[] dist = new int[numberOfVertices];             //dist[i] - shortest distance from startVertex to i
        boolean[] sptSet = new boolean[numberOfVertices];   //sptSet[i] == true if vertex i is included in shortest path, initialize as false

        initializeDistance(numberOfVertices, dist, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int[] parents = new int[numberOfVertices];          //array for storing paths
        parents[startVertex] = START_VERTEX_PARENT;         //starting vertex doesn't have parent


        for (int count = 0; count < numberOfVertices - 1; count++) {
            int u = chooseMinDistanceVertex(dist, sptSet);

            if (u == -1 || dist[u] == Integer.MAX_VALUE || u == endVertex) {
                break;
            }

            sptSet[u] = true;

            IntStream.range(0, numberOfVertices)
                    .filter(v -> !sptSet[v] && graph.isEgdeExist(u, v))
                    .forEach(v -> findMinDistance(dist, parents, u, v));
        }

        List<Integer> resultPath = new ArrayList<>();
        collectPath(endVertex, parents, resultPath);
        return new MutablePair<>(dist[endVertex], resultPath);
    }

    private void findMinDistance(int[] dist, int[] parents, int u, int v) {
        int abs = dist[u] == Integer.MIN_VALUE ? Integer.MAX_VALUE : dist[u];   // weights in graph could be only positive
        int newDist = Math.min(abs, Math.min(dist[v], graph.getAdjacencyMatrix()[u][v]));

        if (newDist < dist[v]) {
            dist[v] = newDist;
            parents[v] = u;
        }
    }

    private void initializeDistance(int numberOfVertices, int[] dist, int sourceValue, int othersValue) {
        IntStream.range(0, numberOfVertices)
                .forEach(i -> dist[i] = othersValue);
        dist[startVertex] = sourceValue;              //distance of source vertex to itself
    }

    /**
     * Chooses vertex with maximum distance value
     *
     * @param dist   array of distances
     * @param sptSet array with information whether vertex in included in path or not
     * @return selected vertex
     */
    private int chooseMaxDistanceVertex(int[] dist, boolean[] sptSet) {
        int maxDist = Integer.MIN_VALUE;
        int max_index = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!sptSet[v] && dist[v] >= maxDist) {
                maxDist = dist[v];
                max_index = v;
            }
        }

        return max_index;
    }

    /**
     * Chooses vertex with minimum distance value
     *
     * @param dist   array of distances
     * @param sptSet array with information whether vertex in included in path or not
     * @return selected vertex
     */
    private int chooseMinDistanceVertex(int[] dist, boolean[] sptSet) {
        int minDist = Integer.MAX_VALUE - 1;
        int min_index = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!sptSet[v] && dist[v] <= minDist) {
                minDist = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }

    /**
     * Prints shortest paths
     *
     * @param currentVertex current vertex
     * @param parents       parents array
     */
    private void collectPath(int currentVertex, int[] parents, List<Integer> result) {
        if (currentVertex == -1 || currentVertex == parents[currentVertex]) {
            return;
        }
        collectPath(parents[currentVertex], parents, result);
        result.add(currentVertex);
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}
