package gis.testing;

import gis.algorithm.ConnectionFinder;
import gis.algorithm.MinMaxFlowPathFinder;
import gis.factory.GraphFactory;
import gis.model.Graph;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinMaxFlowPathTester {
    private int numberOfTests;
    private int maxWeight;
    private int numberOfNodes;
    private double probability;
    private MinMaxFlowPathFinder minMaxFlowPathFinder;

    public MinMaxFlowPathTester(int numberOfTests, int numberOfNodes, int maxWeight, double probability, int startVertex, int endVertex) {
        this.numberOfTests = numberOfTests;
        this.maxWeight = maxWeight;
        this.probability = probability;
        this.numberOfNodes = numberOfNodes;
        this.minMaxFlowPathFinder = new MinMaxFlowPathFinder(startVertex, endVertex);
    }

    public void run() throws GisException {
        if (numberOfTests < 0 || numberOfNodes < 2 || maxWeight < 0
                || probability <= 0 || probability > 1) {
            throw new GisException("Incorrect input data!");
        }

        warmUp();
        List<Graph> generatedGraph = getGeneratedGraphs();
        List<Double> exactTimeList = new ArrayList<>();

        validateGraphs(generatedGraph);

        for (int i = 0; i < numberOfTests; ++i) {
            long tStart = System.currentTimeMillis();
            Pair<Integer, List<Integer>> result = minMaxFlowPathFinder.findMaximumFlowPath(generatedGraph.get(i));
            System.out.println(result.getKey() + ", " + result.getKey());
            long tEnd = System.currentTimeMillis();
            long tDelta = tEnd - tStart;
            exactTimeList.add(tDelta / 1000.0);
        }
        System.out.println("Avg. time: " + getSumOfTime(exactTimeList) / numberOfTests);

    }

    private void validateGraphs(List<Graph> generatedGraph) throws GisException {
        ConnectionFinder connectionFinder = new ConnectionFinder();
        for (Graph graph : generatedGraph) {
            if (!connectionFinder.isConnected(graph)) {
                throw new GisException("Graph is not connected!");
            }
        }
    }

    private double getSumOfTime(List<Double> exactTimeList) {
        return exactTimeList.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    private List<Graph> getGeneratedGraphs() {
        return IntStream.range(0, numberOfTests)
                .mapToObj(i -> GraphFactory.createGraph(numberOfNodes, maxWeight, probability))
                .collect(Collectors.toList());
    }

    private void warmUp() {
        Graph warmUpGraph = GraphFactory.createGraph(100, 100, 0.3);
        IntStream.range(0, 10).forEach(i -> {
            minMaxFlowPathFinder.findMaximumFlowPath(warmUpGraph);
        });
    }
}
