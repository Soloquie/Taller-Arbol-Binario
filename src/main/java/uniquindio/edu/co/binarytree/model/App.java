package uniquindio.edu.co.binarytree.model;


public class App {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(14);
        tree.insert(15);
        tree.insert(4);
        tree.insert(9);
        tree.insert(7);
        tree.insert(18);
        tree.insert(3);
        tree.insert(5);
        tree.insert(16);
        tree.insert(4);
        tree.insert(20);
        tree.insert(17);

        tree.inorder();
        System.out.println("-------");
        tree.preorder();
        System.out.println("-------");
        tree.postorder();
        System.out.println("-------");

        System.out.println(tree.search(4));
        System.out.println(tree.search(7));

        System.out.println("-------");
        System.out.println(tree.getHeight());

        System.out.println("-------");
        System.out.println(tree.getLevel(1));

        System.out.println("Leaves: "+tree.countLeaves());
        System.out.println("Minor: "+tree.getMinor());
        System.out.println("Mayor: "+tree.getMayor());

    }


}
