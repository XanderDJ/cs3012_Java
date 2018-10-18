package tests;

import org.junit.jupiter.api.Test;
import util.BTNode;
import lca.Graph;
import util.DGNode;

class GraphTest {

    @Test
    void interfaceNodeTest(){
        BTNode bRoot = new BTNode();
        DGNode dRoot = new DGNode();
        Graph Btree = new Graph(bRoot);
        Graph Dtree = new Graph(dRoot);

    }

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

    @Test
    /*
    This tests the most simple of a directed acyclic graph that tests the new property of having multiple parents:

                         R
                        /|\
                      C  C C
                       \ /  \
                        L     L
     */
    void LCADAGSimple(){
        Graph graph = new Graph();
        DGNode root = new DGNode();
        graph.setRoot(root);
        DGNode child1 = new DGNode(root);
        DGNode child2 = new DGNode(root);
        DGNode child3 = new DGNode(root);
        DGNode leafNode1 = new DGNode(child1,child2);
        DGNode leafNode2 =  new DGNode(child3);
        assert  graph.lca(leafNode1,leafNode2) == root;
    }


    @Test
    /*
    This tests a dag where there the lca is on a branching path

                             R
                            /  \
                           LCA  C
                          /      \
                          C      C
                          \     /
                              L
     */
    void LCAParentIsonBranchingPath(){
        Graph graph = new Graph();
        DGNode root = new DGNode();
        graph.setRoot(root);
        DGNode child1 = new DGNode(root);
        DGNode child2 = new DGNode(root);
        DGNode CC1 = new DGNode(child1);
        DGNode CC2 = new DGNode(child2);

        DGNode leafNode1 = new DGNode(CC1,CC2);

        assert graph.lca(leafNode1,child1) == child1;
    }


    @Test
    /*

     */
    void bigGraphtest(){

    }

}