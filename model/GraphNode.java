package model;

import panels.AbstractFragePanel;
import java.util.HashMap;

public class GraphNode {
    HashMap<String, GraphNode> predecessors;
    HashMap<String, GraphNode> successors;

    public final AbstractFragePanel panel;
    Boolean isstarred = false;

    GraphNode(AbstractFragePanel panel) {
        this.predecessors = new HashMap<String, GraphNode>();
        this.successors = new HashMap<String, GraphNode>();
        this.panel = panel;
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

    public Boolean isLeaf(){
        return successors.isEmpty();
    }

    @Override
    public String toString() {
        return panel.toString();
    }
}
