package gis.model;

public class Graph {

    private int[][] adjacencyMatrix;

    private int numOfVertices;

    private int numOfEdges;

    public Graph(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        this.numOfEdges = 0;
        adjacencyMatrix = new int[numOfVertices][numOfVertices];
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyMatrix[source][destination] = weight;
//        adjacencyMatrix[destination][source] = weight;
        numOfEdges++;
    }

    public boolean isEgdeExist(int source, int destination) {
        return adjacencyMatrix[source][destination] != 0;
    }

    public int getNumOfVertices() {
        return numOfVertices;
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Graph:\n");
        for (int i = 0; i < numOfVertices; ++i) {
            for (int j = 0; j < numOfVertices; ++j) {
                if (isEgdeExist(i, j)) {
                    builder.append(i)
                            .append(" - ")
                            .append(j)
                            .append(", cost: ")
                            .append(adjacencyMatrix[i][j])
                            .append("\n");
                }
            }
        }
        return builder.toString();
    }
}
