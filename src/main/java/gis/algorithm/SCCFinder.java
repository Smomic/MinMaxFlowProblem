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

    //https://www.sanfoundry.com/java-program-tarjan-algorithm/
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

    private void updateScc(int v) {
        low[v] = preCount++;
        visited[v] = true;
        sccStack.push(v);
        int min = low[v];

        for (int w : graph.getAdjacencyMatrix()[v]) {
            if (!visited[w])
                updateScc(w);
            if (low[w] < min)
                min = low[w];
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
