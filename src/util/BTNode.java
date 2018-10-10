package util;

public class BTNode {
    private BTNode parent;
    private BTNode leftChild;
    private BTNode rightChild;

    public BTNode(BTNode parent, BTNode leftChild, BTNode rightChild) {
        parent.setChild(this);

        setChild(leftChild);
        setChild(rightChild);
    }

    public BTNode(BTNode parent, BTNode child){
        parent.setChild(this);
        setChild(child);
    }

    public BTNode(BTNode parent){
        parent.setChild(this);
    }

    /**
     * Using this method to add child will make a balanced tree starting from that tree
     * @param child
     */
    public void setChild(BTNode child){
        if(!hasLeftChild()){
            setLeftChild(child);
        }
        else if(!hasRightChild()){
            setRightChild(child);
        }
        else if(getLeftChild().countNodes() > getRightChild().countNodes()){
            getRightChild().setChild(child);
        }
        else
        getLeftChild().setChild(child);

    }

    public BTNode getChild(String code){
        if(code.isEmpty()){
            return this;
        }
        else if (code.startsWith("l")){
            return getLeftChild().getChild(code.replaceFirst("l",""));
        }
        else
            return getRightChild().getChild(code.replaceFirst("r",""));
    }

    public BTNode(){}

    public BTNode getParent() {
        return parent;
    }

    private void setParent(BTNode parent){
        this.parent = parent;
    }

    public BTNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BTNode child) {
        this.leftChild = child;
        child.setParent(this);

    }

    public BTNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BTNode child) {
        this.rightChild = child;
        child.setParent(this);
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
