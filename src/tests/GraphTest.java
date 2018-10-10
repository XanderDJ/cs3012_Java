package tests;

import org.junit.jupiter.api.Test;
import util.BTNode;
import lca.Graph;

class GraphTest {

    //LCA with the same node
    @Test
    void LCASameNode(){
        BTNode root = new BTNode();
        Graph tree = new Graph(root);
        assert tree.lca(root,root) == root;
    }

    // Simplest case, two nodes with the same parent
    @Test
    void LCATest() {
        BTNode root = new BTNode();
        Graph tree = new Graph(root);
        BTNode leftChild = new BTNode(root);
        BTNode rightChild = new BTNode(root);
        assert tree.lca(leftChild, rightChild) == root;
    }

    //One parent away
    @Test
    void LCA1AwayTest() {
        BTNode root = new BTNode();
        Graph tree = new Graph(root);
        BTNode l1 = new BTNode(root);
        BTNode r1 = new BTNode(root);
        BTNode l2 = new BTNode(l1);
        assert tree.lca(l2, r1) == root;
    }


    //Common ancestor is one of the nodes itself
    @Test
    void LCATestNodeAncestor() {
        BTNode root = new BTNode();
        Graph tree = new Graph(root);
        BTNode l1 = new BTNode(root);
        BTNode l2 = new BTNode(l1);
        BTNode l3 = new BTNode(l2);
        BTNode l4 = new BTNode(l3);
        assert tree.lca(l1, l4) == l1;
        assert tree.lca(l2, l4) == l2;
        assert tree.lca(l3, l4) == l3;
    }

    @Test
    void LCATestBigTree(){
        BTNode root = new BTNode();
        Graph tree = new Graph(root);
        double x = 10000.0;
        for(int i = 0;i <x;i++){
            root.setChild(new BTNode());
        }
        assert tree.lca(root.getChild("llrrlrlr"),root.getChild("lrrllrl"))== root.getChild("l") ;
        assert tree.lca(root.getChild("rrllrlrllrrl"),root.getChild("rrllrlrlrllr")) == root.getChild("rrllrlrl");

    }
}