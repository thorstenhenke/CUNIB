package model;

import panels.AbstractFragePanel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class DecisionGraph {
    private HashMap<Object, GraphNode> nodes;
    private LinkedList<Historytupel> history;
    private GraphNode startNode;
    private GraphNode actualState;

    public DecisionGraph() {
        nodes = new HashMap<Object, GraphNode>();
        history = new LinkedList<Historytupel>();
    }

    public void addRelation(AbstractFragePanel predecessor, String transition, AbstractFragePanel successor) {
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

    public void setAsStart(AbstractFragePanel predeccessor){
        startNode = nodes.get(predeccessor);
    }

    public void resetGraph() {
        actualState = startNode;
    }

    public DecisionGraph next(String answer) {
        history.addLast(new Historytupel(actualState, answer));
        actualState = actualState.next(answer);
        return this;
    }

    /**
     * FALSCH!!!!
     */
    public DecisionGraph rollback(){
        // besser poplast und actualState updaten
        history.removeLast();
        return this;
    }

    public GraphNode actualState(){
       return actualState;
    }

    public LinkedList<Historytupel> getHistory() {
        return history;
    }

    public void resetHistory() {
        history.clear();
    }
}


