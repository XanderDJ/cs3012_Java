package util;

public class Node {
    private Node parent;
    private Node leftChild;
    private Node rightChild;

    public Node(Node parent, Node leftChild, Node rightChild) {
        parent.setChild(this);

        setChild(leftChild);
        setChild(rightChild);
    }

    public Node(Node parent, Node child){
        parent.setChild(this);
        setChild(child);
    }

    public Node(Node parent){
        parent.setChild(this);
    }

    public void setChild(Node child){
        if(!hasLeftChild()){
            setLeftChild(child);
            child.setParent(this);
        }
        else if(!hasRightChild()){
            setRightChild(child);
            child.setParent(this);
        }

        else if(!getLeftChild().isFull()){
            getLeftChild().setChild(child);
        }
        else
            getRightChild().setChild(child);
    }
    public Node(){}

    public Node getParent() {
        return parent;
    }

    private void setParent(Node parent){
        this.parent = parent;
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
