package model;


import java.io.Serializable;
import java.util.LinkedList;

public class History implements Serializable{
    private LinkedList<Historytupel> tplist;

    History() {
        tplist = new LinkedList<Historytupel>();
    }

    public void addLast(GraphNode actualState, String answer) {
        tplist.addLast(new Historytupel(actualState, answer));
    }

    public void removeLast() {
        tplist.removeLast();
    }

    public GraphNode getLastNode() {
        System.out.println(this.toString());
        return tplist.getLast().node;
    }

    public void reset() {
        tplist.clear();
    }

    @Override
    public String toString() {
        String s = "";
        for (Historytupel t: tplist) {
            s += t.toString().replaceAll("panels.", "");
        }
        return s;
//        return String.valueOf(tplist);
    }

    private class Historytupel implements Serializable {
        final GraphNode node; final String answer;
        Historytupel(GraphNode n , String a) {
            this.node = n; this.answer = a;
        }

        @Override
        public String toString() {
            return "[" + node + "," + answer + "]";
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }
    }
}


