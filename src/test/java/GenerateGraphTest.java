import gis.algorithm.MaxFlowFinder;
import gis.factory.GraphFactory;
import gis.model.Graph;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateGraphTest {

    private static final int NUM_OF_VERTICES = 10;
    private static final double PROBABILITY = 0.2;
    private static final int MAX_WEIGHT = 20;

    @Test
    public void testGeneratingGraph() {
        Graph createdGraph = GraphFactory.createGraph(NUM_OF_VERTICES, MAX_WEIGHT, PROBABILITY);

        assertThat(createdGraph.getNumOfVertices()).isEqualTo(NUM_OF_VERTICES);
        System.out.println(createdGraph.toString());
    }

    /**
     * Test graph from: https://www.youtube.com/watch?v=LdOnanfc5TM
     */
    @Test
    public void findMaximumFlowTest() {
        Graph testGraph = new Graph(11);
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

        MaxFlowFinder maxFlowFinder = new MaxFlowFinder(0, 10);
        int maxFlow = maxFlowFinder.findMaximumFlow(testGraph);
        assertEquals(maxFlow, 7);
    }
}
