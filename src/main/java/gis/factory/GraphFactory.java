package gis.factory;

import gis.model.Graph;

public class GraphFactory {
    public static Graph createGraph(int numOfVercites, int maxPossibleWeight, double probability) {
        GraphGenerator graphGenerator = GraphGenerator.getInstance();
        return graphGenerator.generateNewGraph(numOfVercites, maxPossibleWeight, probability);
    }
}
