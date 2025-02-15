package gis;

import gis.algorithm.MinMaxFlowPathFinder;
import gis.algorithm.SCCFinder;
import gis.model.Graph;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class MinMaxFlowFinderTest {

    private static final int NUM_OF_VERTICES = 11;

    /**
     * Test graph from: https://www.youtube.com/watch?v=LdOnanfc5TM
     */
    @Test
    void findMaximumFlowTest() {
        Graph testGraph = getTestGraph();

        MinMaxFlowPathFinder minMaxFlowPathFinder = new MinMaxFlowPathFinder(0, 10);
        minMaxFlowPathFinder.setGraph(testGraph);

        Pair<Integer, List<Integer>> resultMaxPath = minMaxFlowPathFinder.findMaximumFlowPath();
        System.out.println("Max Flow: " + resultMaxPath.getKey() + ", " + resultMaxPath.getValue());

        Pair<Integer, List<Integer>> resultMinPath = minMaxFlowPathFinder.findMinimumFlowPath();
        System.out.println("Min Flow: " + resultMinPath.getKey() + ", " + resultMinPath.getValue());

        assertThat(resultMaxPath.getKey()).isEqualTo(3);
        assertThat(resultMinPath.getKey()).isEqualTo(1);
    }


    @Test
    void findStronglyConnectedComponents() {
        Graph testGraph = getSecondGraph();

        SCCFinder sccFinder = new SCCFinder();
        List<List<Integer>> scComponents = sccFinder.getSCComponents(testGraph);
        assertEquals(3, scComponents.size());
    }

    private Graph getSecondGraph() {
        Graph testGraph = new Graph(8);
        testGraph.addEdge(0, 1, 2);
        testGraph.addEdge(1, 2, 1);
        testGraph.addEdge(2, 3, 7);
        testGraph.addEdge(3, 2, 2);
        testGraph.addEdge(3, 7, 4);
        testGraph.addEdge(7, 3, 5);
        testGraph.addEdge(2, 6, 6);
        testGraph.addEdge(7, 6, 4);
        testGraph.addEdge(5, 6, 8);
        testGraph.addEdge(6, 5, 7);
        testGraph.addEdge(1, 5, 1);
        testGraph.addEdge(4, 5, 8);
        testGraph.addEdge(4, 0, 3);
        testGraph.addEdge(1, 4, 3);
        return testGraph;
    }

    private Graph getTestGraph() {
        Graph testGraph = new Graph(NUM_OF_VERTICES);
        testGraph.addEdge(0, 2, 2);
        testGraph.addEdge(0, 3, 1);
        testGraph.addEdge(0, 1, 7);
        testGraph.addEdge(1, 4, 2);
        testGraph.addEdge(1, 5, 4);
        testGraph.addEdge(2, 5, 5);
        testGraph.addEdge(2, 6, 6);
        testGraph.addEdge(3, 4, 4);
        testGraph.addEdge(3, 8, 8);
        testGraph.addEdge(4, 7, 7);
        testGraph.addEdge(4, 8, 1);
        testGraph.addEdge(5, 6, 8);
        testGraph.addEdge(5, 9, 3);
        testGraph.addEdge(6, 9, 3);
        testGraph.addEdge(7, 10, 1);
        testGraph.addEdge(8, 10, 3);
        testGraph.addEdge(9, 10, 4);
        return testGraph;
    }
}
