package util;

public class Node {
    private Node parent;
    private Node leftChild;
    private Node rightChild;

    public Node(Node parent, Node leftChild, Node rightChild) {
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node(Node parent, Node leftChild){
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = null;
    }

    public Node(Node parent){
        this.parent = parent;
    }
}
