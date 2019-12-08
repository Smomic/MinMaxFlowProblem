package gis.model;

public enum Parameters {
    APP_NAME("MinMaxFlowProblem"),
    HELP("h"),
    NUM_OF_NODES("n"),
    PROBABILITY("p"),
    MAX_WEIGHT("w"),
    NUM_OF_TESTS("tn"),

    DEFAULT_PROBABILITY("1.0"),
    DEFAULT_MAX_WEIGHT("100"),
    DEFAULT_NUM_OF_TEST("1");

    String value;

    Parameters(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
