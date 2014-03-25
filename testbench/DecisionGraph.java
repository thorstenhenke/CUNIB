import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class DecisionGraph {
    private HashMap<String, GraphNode> nodes;
    private LinkedList<Historytupel> history;
    private GraphNode actualState;

    public DecisionGraph() {
        nodes = new HashMap<String, GraphNode>();
        history = new LinkedList<Historytupel>();
    }

    public void addRelation(String predecessor, String transition, String successor) {
        GraphNode pr;
        GraphNode su;
        if (nodes.containsKey(predecessor) && nodes.containsKey(successor)) {
            pr = nodes.get(predecessor);
            su = nodes.get(successor);
        } else if (nodes.containsKey(predecessor)) {
            pr = nodes.get(predecessor);
            su = new GraphNode(successor);
        } else if (nodes.containsKey(successor)){
            pr = new GraphNode(predecessor);
            su = nodes.get(successor);
        } else {
            pr = new GraphNode(predecessor);
            su = new GraphNode(successor);
        }
        pr.addSucc(transition, su);
        nodes.put(predecessor, pr);
        nodes.put(successor, su);
    }

    public void start(String panel) {
        actualState = nodes.get(panel);
    }

    public DecisionGraph next(String answer) {
        history.addLast(new Historytupel(actualState, answer));
        actualState = actualState.next(answer);
        return this;
    }

    public DecisionGraph rollback(){
        history.removeLast();
        return this;
    }

    /**
     * Testing
     */
    public void printState(){
        if (actualState != null) System.out.println(actualState.name);
    }
    public void printHistory() {
        for (Iterator i = history.iterator(); i.hasNext(); ) {
            System.out.print(i.next() + " ");
        }
    }
}

class GraphNode {
    HashMap<String, GraphNode> predecessors;
    HashMap<String, GraphNode> successors;

    String name;
    Boolean isstarred = false;

    GraphNode(String name) {
        this.predecessors = new HashMap<String, GraphNode>();
        this.successors = new HashMap<String, GraphNode>();
        this.name = name;
    }

    void addSucc(String answer, GraphNode succ) {
        if (answer.equals("*")) {
            isstarred = true;
            successors.clear();
        }
        successors.put(answer, succ);
    }


    GraphNode next(String transition) {
        if (isstarred) {
            transition = "*";
        }
        if (successors.isEmpty()) {
            return null;
        }
        return successors.get(transition);
    }
}

class Historytupel {
    final GraphNode node; final String answer;
    Historytupel(GraphNode n , String a) {
        this.node = n; this.answer = a;
    }

    @Override
    public String toString() {
        return "[" + node.name + "," + answer + "]";
    }
}


