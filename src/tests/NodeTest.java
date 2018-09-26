package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Node;


class NodeTest {
    private Node node1;
    private Node node2;
    private Node node3;

    @BeforeEach
    private void treeSetup(){
        node1 = new Node();
        node2 = new Node(node1);
        node3 = new Node(node1);

    }


    @Test
    void getParent() {
        assert node1 == node2.getParent();
        assert node1 == node3.getParent();
    }

    @org.junit.jupiter.api.Test
    void getLeftChild() {
        assert node1.getLeftChild() == node2;
    }

    @org.junit.jupiter.api.Test
    void getRightChild() {
        assert node1.getRightChild() == node3;
    }

    @org.junit.jupiter.api.Test
    void hasRightChild() {
        assert node1.hasRightChild();
        if (node2.hasRightChild()) throw new AssertionError();
    }

    @org.junit.jupiter.api.Test
    void hasLeftChild() {
        assert node1.hasLeftChild();
        if (node3.hasLeftChild()) throw new AssertionError();
    }

    @org.junit.jupiter.api.Test
    void isRoot() {
        assert node1.isRoot();
        if(node3.isRoot()) throw new AssertionError();
    }

    @Test
     void balancedTreeTest(){
        Node rootNode = new Node();
        for(int i = 0 ; i < 2; i++){
            rootNode.setChild(new Node());
        }

        assert rootNode.depth() == 2;

        for(int i = 0; i < 4;i++){
            rootNode.setChild(new Node());
        }
        assert rootNode.depth() == 3;

        for(int i = 0; i < 8; i++){
            rootNode.setChild(new Node());
        }
        assert rootNode.depth() == 4;

        for(int i = 0 ; i<112;i++){
            rootNode.setChild(new Node());
        }

        assert rootNode.depth() == 7;
    }
}