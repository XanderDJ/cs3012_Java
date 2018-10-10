package util;


import java.util.HashSet;

public class Graph {

    private BTNode root;

    public Graph(BTNode root){
            this.root = root;}

    public Graph(){}

    public BTNode getRoot(){
        return this.root;
    }

    public void setRoot(BTNode root) {
        this.root = root;
    }


    public BTNode lca(BTNode leftChild, BTNode rightChild) {
        HashSet<BTNode> foundBTNodes = new HashSet<>();
        if(leftChild == rightChild){
            return leftChild;
        }
        BTNode lastBTNodeFound = leftChild;
        foundBTNodes.add(lastBTNodeFound);
        while(lastBTNodeFound != getRoot()){
            lastBTNodeFound = lastBTNodeFound.getParent();
            foundBTNodes.add(lastBTNodeFound);
        }

        BTNode lowestCommonAncestor = rightChild;
        boolean LCAFound = foundBTNodes.contains(lowestCommonAncestor) ? true: false;
        while (!LCAFound){
            lowestCommonAncestor = lowestCommonAncestor.getParent();
            if(foundBTNodes.contains(lowestCommonAncestor)){
                LCAFound = true;
            }
        }
        return lowestCommonAncestor;
    }
}
