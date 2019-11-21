package gis.model;

public class Edge {
    private int cost;

    private int destNode;

    Edge(int cost, int destNode) {
        this.cost = cost;
        this.destNode = destNode;
    }

    public int getCost() {
        return cost;
    }

    public int getDestNode() {
        return destNode;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "destNode=" + destNode +
                ", cost=" + cost +
                '}';
    }
}
