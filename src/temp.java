import util.BTNode;


public class temp {
    public static void main(String[] args) {
        BTNode root = new BTNode();
        double x = 10000.0;
        for(int i = 0;i <x;i++){
            root.setChild(new BTNode());
            System.out.println(i / x);
        }
        System.out.println(root.depth());
        System.out.println(root.getChild("llrrllrr"));
    }
}
