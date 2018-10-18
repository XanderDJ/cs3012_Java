package util;

import java.util.HashSet;

public class DGNode implements Node {

    public HashSet<DGNode> children = new HashSet<>();
    public HashSet<Node> parents = new HashSet<>();

    public DGNode(DGNode parent){
        addParent(parent);
        parent.addChild(this);
    }

    public DGNode(){}

    public DGNode(DGNode... parents) {
        for(DGNode parent:parents){
            addParent(parent);
        }
    }

    public void addParent(DGNode parent){
        getParent().add(parent);
    }

    public HashSet<Node> getParent(){
        return this.parents;
    }

    public void addChild(DGNode child){
        getChildren().add(child);
        child.addParent(this);
    }

    public boolean hasChild(DGNode child){
        return getChildren().contains(child);
    }

    public HashSet<DGNode> getChildren(){
        return this.children;
    }
}
