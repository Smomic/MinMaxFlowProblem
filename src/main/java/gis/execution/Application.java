package gis.execution;

import gis.GisException;
import gis.MinMaxFlowTester;
import org.apache.commons.cli.*;

import static gis.model.Parameters.*;

public class Application {

    private static final String HEADER = "\n\nHow to use the application:\n";
    private static final String EXAMPLE = "\nExample: gradle run --args=\"-n 10\"\n";

    public static void main(String[] args) {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
        Options options = generateOptions();
        try {
            cmd = parser.parse(options, args);

            if (cmd.hasOption(NUM_OF_NODES.getValue())) {
                execute(cmd);
            }
        } catch (ParseException e) {
            help(options);
        } catch (GisException e) {
            e.printStackTrace();
        }
    }

    private static void execute(CommandLine cmd) throws GisException {
        MinMaxFlowTester minMaxFlowTester = new MinMaxFlowTester(getNumberOfTests(cmd), Integer.parseInt(cmd.getOptionValue(NUM_OF_NODES.getValue())), getMaxWeight(cmd), getProbability(cmd));
        minMaxFlowTester.run();
        System.out.println("THE END");
    }

    private static int getMaxWeight(CommandLine cmd) {
        return cmd.hasOption(MAX_WEIGHT.getValue()) ? Integer.parseInt(cmd.getOptionValue(NUM_OF_NODES.getValue()))
                : Integer.parseInt(DEFAULT_MAX_WEIGHT.getValue());
    }

    private static double getProbability(CommandLine cmd) {
        return cmd.hasOption(PROBABILITY.getValue()) ? Double.parseDouble(cmd.getOptionValue(PROBABILITY.getValue()))
                : Double.parseDouble(DEFAULT_PROBABILITY.getValue());
    }

    private static int getNumberOfTests(CommandLine cmd) {
        return cmd.hasOption(NUM_OF_TESTS.getValue()) ? Integer.parseInt(cmd.getOptionValue(NUM_OF_TESTS.getValue()))
                : Integer.parseInt(DEFAULT_NUM_OF_TEST.getValue());
    }

    private static void help(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(APP_NAME.getValue(), HEADER, options, EXAMPLE);
    }

    private static Options generateOptions() {
        final Option numberOfNodesOption = Option.builder("n")
                .required(true)
                .hasArg()
                .desc("Number of nodes")
                .build();

        final Option probabilityOption = Option.builder("p")
                .required(false)
                .hasArg()
                .desc("Probability of an edge between nodes, DEFAULT is 1.0")
                .build();

        final Option maxWeightOption = Option.builder("w")
                .required(false)
                .hasArg()
                .desc("Maximum weight, DEFAULT is 100")
                .build();

        final Option numberOfTestsOption = Option.builder("tn")
                .required(false)
                .hasArg()
                .desc("Number of tests, DEFAULT is 1")
                .build();

        final Options options = new Options();
        options.addOption(numberOfNodesOption);
        options.addOption(probabilityOption);
        options.addOption(numberOfTestsOption);
        options.addOption(maxWeightOption);
        return options;
    }
}
