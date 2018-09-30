package util;

import java.util.HashSet;

public class BinaryTree {

    private Node root;

    public BinaryTree(Node root){
            this.root = root;}

    public BinaryTree(){}

    public Node getRoot(){
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node lca(Node leftChild, Node rightChild) {
        HashSet<Node> foundNodes = new HashSet<>();
        if(leftChild == rightChild){
            return leftChild;
        }
        Node lastNodeFound = leftChild;
        foundNodes.add(lastNodeFound);
        while(lastNodeFound != getRoot()){
            lastNodeFound = leftChild.getParent();
            foundNodes.add(lastNodeFound);
        }

        Node lowestCommonAncestor = null;
        boolean LCAFound = false;
        while (!LCAFound){
            lowestCommonAncestor = rightChild.getParent();
            if(foundNodes.contains(lowestCommonAncestor)){
                LCAFound = true;
            }
        }
        return lowestCommonAncestor;
    }
}