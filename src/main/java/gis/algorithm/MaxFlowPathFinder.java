package gis.algorithm;

import gis.GisException;
import gis.model.Graph;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MaxFlowPathFinder {

    private Set<Integer> visitedVertices;
    private int startVertex;
    private int endVertex;

    public MaxFlowPathFinder(int startVertex, int endVertex) {
        visitedVertices = new HashSet<>();
        this.startVertex = startVertex;
        this.endVertex = endVertex;
    }

    /**
     * Finding path with maximum flow in directed graph using modified Dijkstra algorithm
     * Base algorithm: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
     *
     * @param graph directed graph
     * @return maximum flow value
     */
    public int[] findMaximumFlowPath(Graph graph) throws GisException {
        if (!isConnected(graph)) {
            throw new GisException("Invalid graph! Required connected graph");
        }

        int numberOfVertices = graph.getNumOfVertices();
        int[] dist = new int[numberOfVertices];             //dist[i] - shortest distance from startVertex to i
        boolean[] sptSet = new boolean[numberOfVertices];   //sptSet[i] == true if vertex i is included in shortest path

        for (int i = 0; i < numberOfVertices; i++) {
            dist[i] = Integer.MIN_VALUE;
            sptSet[i] = false;
        }

        dist[startVertex] = Integer.MAX_VALUE;              //distance of source vertex to itself
        int[] parents = new int[numberOfVertices];          //array for storing paths
        parents[startVertex] = -1;                          //starting vertex doesn't have parent

        for (int count = 0; count < numberOfVertices - 1; count++) {
            int u = chooseMaxDistanceVertex(dist, sptSet);
            sptSet[u] = true;

            if (dist[u] == Integer.MIN_VALUE) {
                break;
            }

            for (int v = 0; v < numberOfVertices; v++) {
                if (!sptSet[v] && graph.getAdjacencyMatrix()[u][v] != 0) {
                    int newDist = Math.max(dist[v], Math.min(dist[u], graph.getAdjacencyMatrix()[u][v]));

                    if (newDist > dist[v]) {
                        dist[v] = newDist;
                        parents[v] = u;
                    }
                }
            }
        }

        //test
        printMaxMinFlowSolution(dist, parents);
        return dist;
    }

    public int[] findMinimumFlowPath(Graph graph) {
        return null;
    }


    /**
     * Chooses vertex with minimum distance value
     *
     * @param dist   array of distances
     * @param sptSet array with information whether vertex in included in path or not
     * @return selected vertex
     */
    private int chooseMinDistanceVertex(int[] dist, boolean[] sptSet) {
        int minDist = Integer.MAX_VALUE;
        int min_index = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!sptSet[v] && dist[v] <= minDist) {
                minDist = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }


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
     * Prints solution
     *
     * @param distances array with distances
     * @param parents   array of parents for path printing
     */
    private void printMaxMinFlowSolution(int[] distances, int[] parents) {
        int nVertices = distances.length;
        System.out.print("Vertex\t Distance\tPath");

        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
            if (vertexIndex != startVertex) {
                System.out.print("\n" + startVertex + " -> ");
                System.out.print(vertexIndex + " \t\t ");
                System.out.print(distances[vertexIndex] + "\t\t");
                printPath(vertexIndex, parents);
            }
        }
        System.out.println("\n");
    }


    /**
     * Prints shortest paths
     *
     * @param currentVertex current vertex
     * @param parents       parents array
     */
    private void printPath(int currentVertex, int[] parents) {
        if (currentVertex == -1) {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
    }


    private boolean isConnected(Graph graph) {
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
