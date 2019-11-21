package gis.factory;

import gis.model.Graph;

public class GraphFactory {
    public static Graph createGraph(int[][] adjacencyMatrix) {
        Graph graph = new Graph(adjacencyMatrix.length);
        for (int i = 0; i < graph.getNumOfVertices(); ++i) {
            for (int j = i; j < graph.getNumOfVertices(); ++j) {
                if (adjacencyMatrix[i][j] > 0)
                    graph.addEdge(i, j, adjacencyMatrix[i][j]);
            }
        }
        return graph;
    }
}
