package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Node;


class NodeTest {
    private Node node1;
    private Node node2;
    private Node node3;

    @BeforeEach
    public void treeSetup(){
        node1 = new Node();
        node2 = new Node(node1);
        node3 = new Node(node1);

    }


    @Test
    void getParent() {
        assert node1 == node2.getParent();
        assert node1 == node3.getParent();
    }

    @Test
    void setParent() {
    }

    @org.junit.jupiter.api.Test
    void getLeftChild() {
    }

    @org.junit.jupiter.api.Test
    void setLeftChild() {
    }

    @org.junit.jupiter.api.Test
    void getRightChild() {
    }

    @org.junit.jupiter.api.Test
    void setRightChild() {
    }

    @org.junit.jupiter.api.Test
    void hasRightChild() {
    }

    @org.junit.jupiter.api.Test
    void hasLeftChild() {
    }

    @org.junit.jupiter.api.Test
    void isRoot() {
    }
}