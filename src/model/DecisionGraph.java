package model;

import panels.AbstractCustomPanel;

import java.util.HashMap;

public class DecisionGraph
{
    private HashMap<Object, GraphNode> nodes;
    private History history;
    private GraphNode startNode;
    private GraphNode actualState;

    public DecisionGraph()
    {
        nodes = new HashMap<Object, GraphNode>();
        history = new History();
    }

    public void addRelation(AbstractCustomPanel predecessor, String transition, AbstractCustomPanel successor)
    {
        GraphNode pr;
        GraphNode su;
        if (nodes.containsKey(predecessor) && nodes.containsKey(successor)) {
            pr = nodes.get(predecessor);
            su = nodes.get(successor);
        } else if (nodes.containsKey(predecessor)) {
            pr = nodes.get(predecessor);
            su = new GraphNode(successor);
        } else if (nodes.containsKey(successor)) {
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

    public void setAsStart(AbstractCustomPanel predeccessor)
    {
        startNode = nodes.get(predeccessor);
        actualState = startNode;
    }

    public void reset()
    {
        actualState = startNode;
        history.reset();
    }

    public DecisionGraph next(String answer)
    {
        history.addLast(actualState, answer);
        actualState = actualState.next(answer);
        return this;
    }

    public DecisionGraph rollback()
    {
        actualState = history.getLastNode();
        history.removeLast();
        return this;
    }

    public boolean reachedEnd()
    {
        return actualState.panel == null;
    }

    public GraphNode actualState()
    {
        return actualState;
    }

    public History getHistory()
    {
        return history;
    }

}


