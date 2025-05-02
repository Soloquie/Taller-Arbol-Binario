package uniquindio.edu.co.binarytree.model;


public class App {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

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
    }


}
