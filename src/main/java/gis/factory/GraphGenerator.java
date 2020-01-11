package gis.factory;

import gis.model.Graph;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

class GraphGenerator {

    private static final GraphGenerator generator = new GraphGenerator();
    private Graph graph;
    private int maxWeight;

    private GraphGenerator() {
    }

    static GraphGenerator getInstance() {
        return generator;
    }

    Graph generateNewGraph(int numOfVertices, int maxPossibleWeight, double probability) {
        this.graph = new Graph(numOfVertices);
        this.maxWeight = maxPossibleWeight;
        generateSpanningTree();
        generateRandomEdges(probability);

        return graph;
    }

    private void generateSpanningTree() {
        IntStream.range(1, graph.getNumOfVertices())
                .forEach(i -> addToMatrix(i, getRandomVertex(i), getRandomWeight()));
    }

    private void addToMatrix(int n, int m, int weight) {
        graph.addEdge(n, m, weight);
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
        boolean lastAdded = true;
        for (int i = 0; i < addedEdges; ) {
            int firstVertex = getRandomVertex(graph.getNumOfVertices());
            int secondVertex = getRandomVertex(graph.getNumOfVertices());
            if (firstVertex != secondVertex) {
                if (!graph.isEgdeExist(firstVertex, secondVertex) && !graph.isEgdeExist(secondVertex, firstVertex)) {
                    if (lastAdded) {
                        addToMatrix(firstVertex, secondVertex, getRandomWeight());
                        lastAdded = false;
                    } else {
                        addToMatrix(secondVertex, firstVertex, getRandomWeight());
                        lastAdded = true;
                    }
                    i++;
                } else if (!graph.isEgdeExist(firstVertex, secondVertex)) {
                    addToMatrix(secondVertex, firstVertex, getRandomWeight());
                    i++;
                } else if (!graph.isEgdeExist(secondVertex, firstVertex)) {
                    addToMatrix(secondVertex, firstVertex, getRandomWeight());
                    i++;
                }
            }
        }
    }

    private int calculateMaxPossibleNumberOfEgdes() {
        return (graph.getNumOfVertices() * graph.getNumOfVertices() - graph.getNumOfVertices() - 2 * (graph.getNumOfVertices() - 1)) / 2;
    }
}

