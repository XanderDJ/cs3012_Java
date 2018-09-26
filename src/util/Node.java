package util;

public class Node {
    private Node parent;
    private Node leftChild;
    private Node rightChild;

    public Node(Node parent, Node leftChild, Node rightChild) {
        if(!parent.isFull()){
        this.parent = parent;
        parent.setChild(this);}

        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node(Node parent, Node leftChild){
        if(!parent.isFull()){
            this.parent = parent;
            parent.setChild(this);}        this.leftChild = leftChild;
    }

    public Node(Node parent){
        if(!parent.isFull()){
            this.parent = parent;
            parent.setChild(this);}    }

    public void setChild(Node child){
        if(!hasLeftChild()){
            setLeftChild(child);
        }
        else if(!hasRightChild()){
            setRightChild(child);
        }
    }
    public Node(){}

    public Node getParent() {
        return parent;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    private void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    private void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public boolean hasRightChild(){
        return getRightChild() != null;
    }

    public boolean hasLeftChild(){
        return  getLeftChild() != null;
    }

    public boolean isRoot(){
        return getParent() == null;
    }

    private boolean isFull() {
        if(hasLeftChild() && hasRightChild()){
            return true;
        }
        return false;
    }


}
