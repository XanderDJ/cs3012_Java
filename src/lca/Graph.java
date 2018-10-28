package lca;


import util.Node;

import java.util.ArrayList;
import java.util.HashSet;

public class Graph {

    private Node root;

    public Graph(Node root){
            this.root = root;}

    public Graph(){}

    public Node getRoot(){
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


    /**
     *      HashSet<HashSet<Node>> foundPaths = new HashSet<>();
     *         if(node1 == node2){
     *             return node1;
     *         }
     *         Node lastNodeFound = node1;
     *         foundNodes.add(lastNodeFound);
     *         while(lastNodeFound != getRoot()){
     *             lastNodeFound = lastNodeFound.getParent();
     *             foundNodes.add(lastNodeFound);
     *         }
     *
     *         Node lowestCommonAncestor = node2;
     *         boolean LCAFound = foundNodes.contains(lowestCommonAncestor);
     *         while (!LCAFound){
     *             lowestCommonAncestor = lowestCommonAncestor.getParent();
     *             if(foundNodes.contains(lowestCommonAncestor)){
     *                 LCAFound = true;
     *             }
     *         }
     *         return lowestCommonAncestor;
     * @param node1
     * @param node2
     * @return
     */
    public Node lca(Node node1, Node node2) {
        if(node1 ==node2){
            return node1;
        }
        HashSet<Node> nodesToExplore = new HashSet<>();
        nodesToExplore.add(node1);
        HashSet<Node> allParents = new HashSet<>();
        while(!nodesToExplore.isEmpty()){
            allParents.addAll(nodesToExplore);
            HashSet<Node> parents = new HashSet<>();
            for(Node child:nodesToExplore){
                parents.addAll(child.getParent());
            }
            nodesToExplore = parents;
        }

        HashSet<Node> possibleLCAS = new HashSet<>();
        possibleLCAS.add(node2);
        while(!possibleLCAS.isEmpty()) {
            for (Node possibleLCA : possibleLCAS) {
                if (allParents.contains(possibleLCA)) {
                    return possibleLCA;
                }
            }
            HashSet<Node> parents = new HashSet<>();
            for(Node node:possibleLCAS){
                parents.addAll(node.getParent());
            }
            possibleLCAS = parents;
        }
        return null;

    }


}
