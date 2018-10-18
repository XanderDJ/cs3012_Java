package lca;


import util.BTNode;
import util.Node;

import java.util.HashSet;

public class Graph {

    private Node root;

    public Graph(Node root){
            this.root = root;}

    public Graph(){}

    public Node getRoot(){
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


    public Node lca(Node node1, Node node2) {
        HashSet<Node> foundNodes = new HashSet<>();
        if(node1 == node2){
            return node1;
        }
        Node lastNodeFound = node1;
        foundNodes.add(lastNodeFound);
        while(lastNodeFound != getRoot()){
            lastNodeFound = lastNodeFound.getParent();
            foundNodes.add(lastNodeFound);
        }

        Node lowestCommonAncestor = node2;
        boolean LCAFound = foundNodes.contains(lowestCommonAncestor);
        while (!LCAFound){
            lowestCommonAncestor = lowestCommonAncestor.getParent();
            if(foundNodes.contains(lowestCommonAncestor)){
                LCAFound = true;
            }
        }
        return lowestCommonAncestor;
    }
}
