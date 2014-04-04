package model;

import panels.AbstractCustomPanel;

import java.io.Serializable;
import java.util.HashMap;

public class GraphNode implements Serializable{
    HashMap<String, GraphNode> predecessors;
    HashMap<String, GraphNode> successors;

    public final AbstractCustomPanel panel;
    Boolean isstarred = false;

    GraphNode(AbstractCustomPanel panel) {
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

    @Override
    public String toString() {
        return panel.toString();
    }
}
