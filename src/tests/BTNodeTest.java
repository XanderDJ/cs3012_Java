package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.BTNode;


class BTNodeTest {
    private BTNode BTNode1;
    private BTNode BTNode2;
    private BTNode BTNode3;

    @BeforeEach
    private void treeSetup(){
        BTNode1 = new BTNode();
        BTNode2 = new BTNode(BTNode1);
        BTNode3 = new BTNode(BTNode1);

    }


    @Test
    void getParent() {
        //assert BTNode1 ==(BTNode) BTNode2.getParent().;
        //assert BTNode1 == BTNode3.getParent();
    }

    @org.junit.jupiter.api.Test
    void getLeftChild() {
        assert BTNode1.getLeftChild() == BTNode2;
    }

    @org.junit.jupiter.api.Test
    void getRightChild() {
        assert BTNode1.getRightChild() == BTNode3;
    }

    @org.junit.jupiter.api.Test
    void hasRightChild() {
        assert BTNode1.hasRightChild();
        if (BTNode2.hasRightChild()) throw new AssertionError();
    }

    @org.junit.jupiter.api.Test
    void hasLeftChild() {
        assert BTNode1.hasLeftChild();
        if (BTNode3.hasLeftChild()) throw new AssertionError();
    }

    @org.junit.jupiter.api.Test
    void isRoot() {
        assert BTNode1.isRoot();
        if(BTNode3.isRoot()) throw new AssertionError();
    }

    @Test
     void balancedTreeTest(){
        BTNode rootBTNode = new BTNode();
        for(int i = 0 ; i < 2; i++){
            rootBTNode.setChild(new BTNode());
        }

        assert rootBTNode.depth() == 2;

        for(int i = 0; i < 4;i++){
            rootBTNode.setChild(new BTNode());
        }
        assert rootBTNode.depth() == 3;

        for(int i = 0; i < 8; i++){
            rootBTNode.setChild(new BTNode());
        }
        assert rootBTNode.depth() == 4;

        for(int i = 0 ; i<112;i++){
            rootBTNode.setChild(new BTNode());
        }

        assert rootBTNode.depth() == 7;
    }

    @Test
    void GetChildTest(){
        BTNode root = new BTNode();
        BTNode l1 = new BTNode(root);
        BTNode l2 = new BTNode(l1);
        BTNode l3 = new BTNode(l2);
        BTNode r3 = new BTNode(l2);
        BTNode r4 = new BTNode();
        r3.setRightChild(r4);

        assert root.getChild("llrr") == r4;

    }
}