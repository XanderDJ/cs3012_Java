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
        else if(getLeftChild().countNodes() > getRightChild().countNodes()){
            getRightChild().setChild(child);
        }
        else
        getLeftChild().setChild(child);

    }

    public Node getChild(String code){
        if(code.isEmpty()){
            return this;
        }
        else if (code.startsWith("l")){
            return getLeftChild().getChild(code.replaceFirst("l",""));
        }
        else
            return getRightChild().getChild(code.replaceFirst("r",""));
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

    public int depth(){
        int depth = 1;
        int depthLeft = 0;
        int depthRight = 0;
        if(hasLeftChild()){
            depthLeft = getLeftChild().depth();
        }
        if(hasRightChild()){
            depthRight = getRightChild().depth();
        }
        depth += depthLeft >= depthRight ? depthLeft:depthRight;
        return depth;
    }
    public int countNodes(){
        int count = 1;
        count += hasLeftChild() ? getLeftChild().countNodes() : 0;
        count += hasRightChild() ? getRightChild().countNodes() : 0;
        return count;
    }


}
