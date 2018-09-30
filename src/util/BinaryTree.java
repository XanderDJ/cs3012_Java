package util;

public class BinaryTree {

    private Node root;

    public BinaryTree(Node root){
            this.root = root;}

    public BinaryTree(){}


    public void setRoot(Node root) {
        this.root = root;
    }

    public Node lca(Node leftChild, Node rightChild) {
        if(leftChild == rightChild){
            return leftChild;
        }
        return null;
    }
}
