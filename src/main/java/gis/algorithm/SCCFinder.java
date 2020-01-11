package gis.algorithm;

import gis.model.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SCCFinder {
    private List<List<Integer>> sccComp;
    private Stack<Integer> sccStack;
    private int[] low; //low number of vertex
    private boolean[] visited; //info about visited vertices
    private int preCount;
    private Graph graph;

    /**
     * Tarjan algorithm for finding strongly connected components
     * //https://www.sanfoundry.com/java-program-tarjan-algorithm/
     *
     * @param graph graph instance
     * @return list with strongly connected components
     */
    public List<List<Integer>> getSCComponents(Graph graph) {
        int noOfVertices = graph.getNumOfVertices();
        low = new int[noOfVertices];
        visited = new boolean[noOfVertices];
        sccStack = new Stack<>();
        sccComp = new ArrayList<>();
        this.graph = graph;

        for (int v = 0; v < noOfVertices; v++) {
            if (!visited[v]) {
                updateScc(v);
            }
        }

        return sccComp;
    }

    /**
     * Updates strongly connected components using modified version of DFS algorithm
     * NOTE! Algorithm assumes that arc wages are different from 0
     *
     * @param v vertex
     */
    private void updateScc(int v) {
        low[v] = preCount++;
        visited[v] = true;
        sccStack.push(v);
        int min = low[v];

        int[] row = graph.getAdjacencyMatrix()[v];
        for (int w = 0; w < row.length; w++) {
            if (row[w] != 0) {
                if (!visited[w])
                    updateScc(w);
                if (low[w] < min)
                    min = low[w];
            }
        }

        if (min < low[v]) {
            low[v] = min;
            return;
        }

        List<Integer> component = new ArrayList<Integer>();
        int w;
        do {
            w = sccStack.pop();
            component.add(w);
            low[w] = graph.getNumOfVertices();
        } while (w != v);
        sccComp.add(component);
    }
}
