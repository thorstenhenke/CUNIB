package model;

public class Historytupel {
    final GraphNode node; final String answer;
    Historytupel(GraphNode n , String a) {
        this.node = n; this.answer = a;
    }

    @Override
    public String toString() {
        return "[" + node + "," + answer + "]";
    }
}
