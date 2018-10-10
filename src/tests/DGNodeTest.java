package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.DGNode;

public class DGNodeTest {

    @Test
    void DGNodeTest(){
        DGNode root = new DGNode();
        DGNode child = new DGNode(root);
        assert root.hasChild(child);
    }

}
