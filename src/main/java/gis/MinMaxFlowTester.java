package gis;

import gis.algorithm.MaxFlowFinder;
import gis.factory.GraphFactory;
import gis.model.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinMaxFlowTester {
    private int numberOfTests;
    private int maxWeight;
    private int numberOfNodes;
    private double probability;
    private MaxFlowFinder maxFlowFinder;

    public MinMaxFlowTester(int numberOfTests, int numberOfNodes, int maxWeight, double probability) {
        this.numberOfTests = numberOfTests;
        this.maxWeight = maxWeight;
        this.probability = probability;
        this.numberOfNodes = numberOfNodes;
        this.maxFlowFinder = new MaxFlowFinder();
    }

    public void run() throws GisException {
        if(numberOfTests < 0 || numberOfNodes < 1 || maxWeight < 0
                || probability <= 0 || probability > 1) {
            throw new GisException("Incorrect input data!");
        }

        warmUp();
        List<Graph> generatedGraph = getGeneratedGraphs();
        List<Double> exactTimeList = new ArrayList<>();

        for (int i = 0; i < numberOfTests; ++i) {
            long tStart = System.currentTimeMillis();
            System.out.println(maxFlowFinder.find(generatedGraph.get(i)));
            long tEnd = System.currentTimeMillis();
            long tDelta = tEnd - tStart;
            exactTimeList.add(tDelta / 1000.0);
        }
        System.out.println("Avg. time: " + getSumOfTime(exactTimeList) / numberOfTests);

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
            try {
                maxFlowFinder.find(warmUpGraph);
            } catch (GisException e) {
                e.printStackTrace();
            }
        });
    }
}
