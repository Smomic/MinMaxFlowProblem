package gis.testing;

import gis.algorithm.ConnectionFinder;
import gis.algorithm.MinMaxFlowPathFinder;
import gis.algorithm.SCCFinder;
import gis.factory.GraphFactory;
import gis.model.Graph;
import org.apache.commons.lang3.tuple.Pair;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MinMaxFlowPathTester {
    private final int startVertex;
    private final int endVertex;
    private int numberOfTests;
    private int maxWeight;
    private int numberOfNodes;
    private double probability;
    private MinMaxFlowPathFinder minMaxFlowPathFinder;
    private ConnectionFinder connectionFinder;
    private SCCFinder sccFinder;

    public MinMaxFlowPathTester(int numberOfTests, int numberOfNodes, int maxWeight, double probability, int startVertex, int endVertex) {
        this.numberOfTests = numberOfTests;
        this.maxWeight = maxWeight;
        this.probability = probability;
        this.numberOfNodes = numberOfNodes;
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.minMaxFlowPathFinder = new MinMaxFlowPathFinder(startVertex, endVertex);
        this.sccFinder = new SCCFinder();
        this.connectionFinder = new ConnectionFinder();
    }

    public void run(boolean isMax, boolean isMin, boolean isScc) throws GisException {
        validateInputData();
        List<Double> exactMaxPathTimeList = new ArrayList<>();
        List<Double> exactMinPathTimeList = new ArrayList<>();
        List<Pair<Integer, List<Integer>>> maxResultList = new ArrayList<>();
        List<Pair<Integer, List<Integer>>> minResultList = new ArrayList<>();

        warmUp();

        for (int i = 0; i < numberOfTests; ++i) {
            Graph generatedGraph = GraphFactory.createGraph(numberOfNodes, maxWeight, probability);
            validateGraph(generatedGraph);
            if (isScc) {
                long tStart = System.currentTimeMillis();
                convertGraphToSCCompomentIfAvailable(generatedGraph);
                long tEnd = System.currentTimeMillis();
                long tDelta = tEnd - tStart;
                exactMinPathTimeList.add(toSecond(tDelta));
                exactMaxPathTimeList.add(toSecond(tDelta));
            }
            minMaxFlowPathFinder.setGraph(generatedGraph);

            if (isMax)
                maxResultList.add(testMaxFlowPath(exactMaxPathTimeList));
            if (isMin)
                minResultList.add(testMinFlowPath(exactMinPathTimeList));
        }

        if (isMax)
            showMaxResult(exactMaxPathTimeList, maxResultList);

        if (isMin)
            showMinResult(exactMinPathTimeList, minResultList);
    }

    private void convertGraphToSCCompomentIfAvailable(Graph generatedGraph) {
        List<List<Integer>> scComponents = sccFinder.getSCComponents(generatedGraph);
        for (List<Integer> component : scComponents) {
            if (scComponents.size() > 1 && component.contains(startVertex) && component.contains(endVertex)) {
                convertToNewGraph(component, generatedGraph);
                System.out.println("GRAPH CONVERTED");
                return;
            }
        }
    }

    private void convertToNewGraph(List<Integer> component, Graph generatedGraph) {
        int[][] adjMatrix = generatedGraph.getAdjacencyMatrix();

        for (int i = 0; i < numberOfNodes; ++i) {
            for (int j = 0; j < numberOfNodes; ++j) {
                if (!component.contains(i) && !component.contains(j)) {
                    adjMatrix[i][j] = 0;
                }
            }
        }
    }

    private void showMaxResult(List<Double> exactMaxPathTimeList, List<Pair<Integer, List<Integer>>> maxResultList) {
        System.out.println("\nMAX FLOW RESULTS");
        int index = 1;
        for (Pair<Integer, List<Integer>> result : maxResultList) {
            if (result.getKey() == Integer.MIN_VALUE) {
                System.out.println("[" + index + "] Path does not exist");
            } else {
                System.out.println("[" + index + "] Flow value: " + result.getKey() + ", Path: " + result.getValue());
            }
            index++;
        }
        System.out.println("Average of time: " + new DecimalFormat("#0.000").format(getSumOfTime(exactMaxPathTimeList) / numberOfTests));
    }

    private void showMinResult(List<Double> exactMinPathTimeList, List<Pair<Integer, List<Integer>>> minResultList) {
        System.out.println("\nMIN FLOW RESULTS");
        int index = 1;
        for (Pair<Integer, List<Integer>> result : minResultList) {
            if (result.getKey() == Integer.MAX_VALUE) {
                System.out.println("[" + index + "] Path does not exist");
            } else {
                System.out.println("[" + index + "] Flow value: " + result.getKey() + ", Path: " + result.getValue());
            }
            index++;
        }
        System.out.println("Average of time: " + new DecimalFormat("#0.000").format(getSumOfTime(exactMinPathTimeList) / numberOfTests));
    }

    private Pair<Integer, List<Integer>> testMaxFlowPath(List<Double> exactTimeList) {
        long tStart = System.currentTimeMillis();
        Pair<Integer, List<Integer>> result = minMaxFlowPathFinder.findMaximumFlowPath();
        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        exactTimeList.add(toSecond(tDelta));
        return result;
    }

    private Pair<Integer, List<Integer>> testMinFlowPath(List<Double> exactTimeList) {
        long tStart = System.currentTimeMillis();
        Pair<Integer, List<Integer>> result = minMaxFlowPathFinder.findMinimumFlowPath();
        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        exactTimeList.add(toSecond(tDelta));

        return result;
    }

    private void validateInputData() throws GisException {
        if (numberOfTests < 0 || numberOfNodes < 2 || maxWeight < 0
                || probability <= 0 || probability > 1
                || startVertex < 0 || startVertex >= numberOfNodes
                || endVertex < 0 || endVertex >= numberOfNodes || startVertex == endVertex) {
            throw new GisException("Incorrect input data!");
        }
    }

    private void validateGraph(Graph generatedGraph) throws GisException {
        if (!connectionFinder.isConnected(generatedGraph)) {
            throw new GisException("Graph is not connected!");
        }
    }

    private double getSumOfTime(List<Double> exactTimeList) {
        return exactTimeList.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    private void warmUp() {
        Graph warmUpGraph = GraphFactory.createGraph(100, 100, 0.3);
        MinMaxFlowPathFinder finder = new MinMaxFlowPathFinder(0, 99);
        finder.setGraph(warmUpGraph);
        IntStream.range(0, 10).forEach(i -> {
            finder.findMaximumFlowPath();
            finder.findMinimumFlowPath();
        });
    }

    private double toSecond(long tDelta) {
        return tDelta / 1000.0;
    }
}
