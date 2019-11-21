package gis.factory;

import gis.GisException;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class GraphGenerator {

    private int[][] adjacencyMatrix;
    private int numOfVertices;
    private int maxWeight;

    public GraphGenerator(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        this.adjacencyMatrix = new int[numOfVertices][numOfVertices];
    }

    public int[][] generateAdjacencyMatrix(double probability, int maxWeight) throws GisException {
        if (numOfVertices <= 1 || probability < 0 || probability > 1) {
            throw new GisException("Incorrect input data");
        }
        this.maxWeight = maxWeight;

        generateSpanningTree();
        generateRandomEdges(probability);

        return adjacencyMatrix;
    }

    private void generateSpanningTree() {
        IntStream.range(1, numOfVertices).forEach(i -> addToMatrix(i, getRandomVertex(i), getRandomWeight()));
    }

    private void addToMatrix(int n, int m, int weight) {
        adjacencyMatrix[n][m] = weight;
        adjacencyMatrix[m][n] = weight;
    }

    private int getRandomVertex(int maxValue) {
        return ThreadLocalRandom.current().nextInt(0, maxValue);
    }

    private int getRandomWeight() {
        return ThreadLocalRandom.current().nextInt(1, maxWeight);
    }

    private void generateRandomEdges(double probability) {
        int possibleEdges = calculateMaxPossibleNumberOfEgdes();
        int addedEdges = (int) (possibleEdges * probability);
        for (int i = 0; i < addedEdges; ) {
            int firstVertex = getRandomVertex(numOfVertices);
            int secondVertex = getRandomVertex(numOfVertices);
            if (firstVertex != secondVertex && !checkEdge(firstVertex, secondVertex)) {
                int randomWeight = ThreadLocalRandom.current().nextInt(1, maxWeight);
                addToMatrix(firstVertex, secondVertex, randomWeight);
                i++;
            }
        }
    }

    private int calculateMaxPossibleNumberOfEgdes() {
        return (numOfVertices * numOfVertices - numOfVertices - 2 * (numOfVertices - 1)) / 2;

    }

    private boolean checkEdge(int n, int m) {
        return adjacencyMatrix[n][m] == 0;
    }
}

