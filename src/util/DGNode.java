package util;

import java.util.HashSet;

public class DGNode {

    public HashSet<DGNode> children = new HashSet<>();
    public HashSet<DGNode> parents = new HashSet<>();

    public DGNode(DGNode parent){
        addParent(parent);
        parent.addChild(this);
    }

    public DGNode(){}

    public void addParent(DGNode parent){
        getParents().add(parent);
    }

    public HashSet<DGNode> getParents(){
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
