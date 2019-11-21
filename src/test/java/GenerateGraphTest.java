import gis.GisException;
import gis.factory.GraphFactory;
import gis.factory.GraphGenerator;
import gis.model.Graph;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GenerateGraphTest {

    private static final int NUM_OF_VERTICES = 10;
    private static final double PROBABILITY = 0.2;
    private static final int MAX_WEIGHT = 20;

    @Test
    public void testGeneratingGraph() throws GisException {
        GraphGenerator graphGenerator = new GraphGenerator(NUM_OF_VERTICES);
        int[][] matrix = graphGenerator.generateAdjacencyMatrix(PROBABILITY, MAX_WEIGHT);
        Graph createdGraph = GraphFactory.createGraph(graphGenerator.generateAdjacencyMatrix(PROBABILITY, MAX_WEIGHT));

        assertThat(createdGraph.getNumOfVertices()).isEqualTo(NUM_OF_VERTICES);
        System.out.println(createdGraph.toString());
    }
}
