package gis;

import gis.testing.GisException;
import gis.testing.MinMaxFlowPathTester;
import org.junit.jupiter.api.Test;

class MinMaxFlowPathTesterTest {

    private static final int NUM_OF_VERTICES = 200;
    private static final double PROBABILITY = 0.2;
    private static final int START_VERTEX = 0;
    private static final int END_VERTEX = 199;
    private static final int MAX_WEIGHT = 170;
    private static final int NUM_OF_TESTS = 10;

    @Test
    void testPathTester() throws GisException {
        MinMaxFlowPathTester tester = new MinMaxFlowPathTester(NUM_OF_TESTS, NUM_OF_VERTICES, MAX_WEIGHT, PROBABILITY, START_VERTEX, END_VERTEX);
        tester.run(true, true);
    }
}
