package gis.testing;

import gis.algorithm.ConnectionFinder;
import gis.algorithm.MinMaxFlowPathFinder;
import gis.factory.GraphFactory;
import gis.model.Graph;
import javafx.util.Pair;

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

    public void run(boolean isMax, boolean isMin) throws GisException {
        validateInputData();

        List<Graph> generatedGraphs = getGeneratedGraphs();
        validateGraphs(generatedGraphs);

        warmUp();

        if (isMax) {
            testMaxFlowPath(generatedGraphs);
        }
        if (isMin) {
            testMinFlowPath(generatedGraphs);
        }

    }

    private void testMaxFlowPath(List<Graph> generatedGraphs) {
        List<Double> exactTimeList = new ArrayList<>();
        Pair<Integer, List<Integer>> result;
        for (int i = 0; i < numberOfTests; ++i) {
            long tStart = System.currentTimeMillis();
            result = minMaxFlowPathFinder.findMaximumFlowPath(generatedGraphs.get(i));
            long tEnd = System.currentTimeMillis();
            long tDelta = tEnd - tStart;
            exactTimeList.add(tDelta / 1000.0);
            if (result.getKey() == Integer.MIN_VALUE) {
                System.out.println("Path does not exist");
            } else {
                System.out.println("Max flow: " + result.getKey() + ", Path: " + result.getValue());
            }
        }

        System.out.println("Avg. time: " + getSumOfTime(exactTimeList) / numberOfTests);
    }

    private void testMinFlowPath(List<Graph> generatedGraphs) {
        List<Double> exactTimeList = new ArrayList<>();
        Pair<Integer, List<Integer>> result;
        for (int i = 0; i < numberOfTests; ++i) {
            long tStart = System.currentTimeMillis();
            result = minMaxFlowPathFinder.findMinimumFlowPath(generatedGraphs.get(i));
            long tEnd = System.currentTimeMillis();
            long tDelta = tEnd - tStart;
            exactTimeList.add(tDelta / 1000.0);
            if (result.getKey() == Integer.MAX_VALUE) {
                System.out.println("Path does not exist");
            } else {
                System.out.println("Min flow: " + result.getKey() + ", Path: " + result.getValue());
            }
        }

        System.out.println("Avg. time: " + getSumOfTime(exactTimeList) / numberOfTests);
    }

    private void validateInputData() throws GisException {
        if (numberOfTests < 0 || numberOfNodes < 2 || maxWeight < 0
                || probability <= 0 || probability > 1) {
            throw new GisException("Incorrect input data!");
        }
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
        MinMaxFlowPathFinder finder = new MinMaxFlowPathFinder(0, 99);
        IntStream.range(0, 10).forEach(i -> {
            finder.findMaximumFlowPath(warmUpGraph);
            finder.findMinimumFlowPath(warmUpGraph);
        });
    }
}
