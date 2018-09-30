package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Node;
import util.BinaryTree;

class BinaryTreeTest {

    //LCA with the same tree
    @Test
    void LCASameNode(){
        Node root = new Node();
        BinaryTree tree = new BinaryTree(root);
        assert tree.lca(root,root) == root;
    }

    // Simplest case, two nodes with the same parent
    @Test
    void LCATest() {
        Node root = new Node();
        BinaryTree tree = new BinaryTree(root);
        Node leftChild = new Node(root);
        Node rightChild = new Node(root);

        assert tree.lca(leftChild, rightChild) == root;
    }

    //One parent away
    @Test
    void LCA1AwayTest() {
        Node root = new Node();
        BinaryTree tree = new BinaryTree(root);
        Node l1 = new Node(root);
        Node r1 = new Node(root);
        Node l2 = new Node(l1);

        assert tree.lca(l2, r1) == root;
    }


    //Common ancestor is one of the nodes itself
    @Test
    void LCATestNodeAncestor() {
        Node root = new Node();
        BinaryTree tree = new BinaryTree(root);
        Node l1 = new Node(root);
        Node l2 = new Node(l1);
        Node l3 = new Node(l2);
        Node l4 = new Node(l3);
        assert tree.lca(l1, l4) == l1;
        assert tree.lca(l2, l4) == l2;
        assert tree.lca(l3, l4) == l3;
    }

    @Test
    void LCATestBigTree(){
        Node root = new Node();
        BinaryTree tree = new BinaryTree(root);
        double x = 10000.0;
        for(int i = 0;i <x;i++){
            root.setChild(new Node());
        }
        assert tree.lca(root.getChild("llrrlrlr"),root.getChild("lrrllrl"))== root.getChild("l") ;

    }
}