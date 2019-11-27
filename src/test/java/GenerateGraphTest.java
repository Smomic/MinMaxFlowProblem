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
        Graph createdGraph = GraphFactory.createGraph(NUM_OF_VERTICES, MAX_WEIGHT, PROBABILITY);

        assertThat(createdGraph.getNumOfVertices()).isEqualTo(NUM_OF_VERTICES);
        System.out.println(createdGraph.toString());
    }
}
