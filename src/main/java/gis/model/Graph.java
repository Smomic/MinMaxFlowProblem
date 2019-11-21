package gis.model;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class Graph {

    private LinkedList<LinkedList<Edge>> adjMatrix;

    private int numOfVertices;

    private int numOfEdges;

    public Graph(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        this.numOfEdges = 0;
        adjMatrix = new LinkedList<>();

        IntStream.range(0, numOfVertices).forEach(i -> adjMatrix.add(new LinkedList<>()));
    }

    public void addEdge(int source, int destination, int weight) {
        adjMatrix.get(source).add(new Edge(weight, destination));
        numOfEdges++;
    }

    public int getNumOfVertices() {
        return numOfVertices;
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    @Override
    public String toString() {
        int index = 0;
        StringBuilder builder = new StringBuilder("Graph:\n");
        for (LinkedList<Edge> list : adjMatrix) {
            for (Edge edge : list) {
                builder.append(adjMatrix.indexOf(list))
                        .append(" - ")
                        .append(edge.getDestNode())
                        .append(", cost: ")
                        .append(edge.getCost())
                        .append("\n");
            }
        }
        return builder.toString();
    }
}
