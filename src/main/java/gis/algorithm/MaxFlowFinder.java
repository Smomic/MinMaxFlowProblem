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
     * Finding maximum flow in directed graph using Ford-Fulkerson algorithm
     *
     * @param graph directed graph
     * @return maximum flow value
     */
    public int findMaximumFlow(Graph graph) {
        //stores vertices for BFS algorithm
        Queue<Integer> bfsQueue = new LinkedList<>();
        int[][] capacityMatrix = Arrays.stream(graph.getAdjacencyMatrix()).map(int[]::clone).toArray(int[][]::new);
        int[][] flowMatrix = Arrays.stream(graph.getAdjacencyMatrix()).map(int[]::clone).toArray(int[][]::new);
        int[] predecessorArray = new int[graph.getNumOfVertices()];
        int[] capacityResidualArray = new int[graph.getNumOfVertices()];
        int source, sink, fmax, cp, x, y, i, j;
        int n = graph.getNumOfVertices();
        boolean esc;

        //filling flowMatrix with 0's
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                flowMatrix[i][j] = 0;

        source = startVertex;
        sink = endVertex;
        fmax = 0;

        //look for residual paths until they exist in residual network; each found path increases flow along edges of
        //residual network which contains them
        while (true) {
            //fill predecessorArray with -1's
            for (i = 0; i < n; i++)
                predecessorArray[i] = -1;

            //sink doesn't have predecessor; to avoid BFS for source, fill it with -2 value
            predecessorArray[source] = -2;
            capacityResidualArray[source] = Integer.MAX_VALUE;

            //push source to queue
            while (!bfsQueue.isEmpty())
                bfsQueue.poll();
            bfsQueue.add(source);

            esc = false;

            //start of BFS
            while (!bfsQueue.isEmpty()) {
                x = bfsQueue.poll();

                //check all neighbors of vertex x from capacityMatrix row
                for (y = 0; y < n; y++) {
                    //for y neighbor compute residual capacity of edge x -> y
                    cp = capacityMatrix[x][y] - flowMatrix[x][y];

                    //check whether edge exists and whether vertex y wasn't previously chose by BFS algorithm
                    if (cp > 0 && (predecessorArray[y] == -1)) {
                        //save info that predecessor of y was x
                        predecessorArray[y] = x;

                        //for vertex y compute residual capacity of path; it's smaller value of two:
                        //capacity of path for predecessor x or current residual capacity of edge x -> y
                        capacityResidualArray[y] = capacityResidualArray[x] > cp ? cp : capacityResidualArray[x];

                        //if we reached sink, the path is complete
                        if (y == sink) {
                            //increase max flow by residual capacity of path
                            fmax += capacityResidualArray[sink];

                            //go backwards increasing flow along path edges in corresponding direction and
                            //decreasing flow in opposed direction
                            i = y;
                            while (i != source) {
                                x = predecessorArray[i];
                                flowMatrix[x][i] += capacityResidualArray[sink];
                                flowMatrix[i][x] -= capacityResidualArray[sink];
                                i = x;
                            }

                            //exit both loops
                            esc = true;
                            break;
                        }
                        //if vertex y isn't sink, continue
                        bfsQueue.add(y);
                    }
                }
                if (esc)
                    break;
            }
            if (!esc)
                break;
        }

        return fmax;
    }

    /**
     * Prints graph edges with computed max flow values
     *
     * @param capacityMatrix capacity matrix
     * @param flowMatrix flow matrix
     */
    private void printMaxFlowEdgesValues(int[][] capacityMatrix, int[][] flowMatrix) {
        for (int x = 0; x < capacityMatrix.length; x++) {
            for (int y = 0; y < capacityMatrix.length; y++) {
                if (capacityMatrix[x][y] > 0)
                    System.out.println(x + " -> " + y + " " + flowMatrix[x][y] + ": " + capacityMatrix[x][y]);
            }
        }
    }
}
