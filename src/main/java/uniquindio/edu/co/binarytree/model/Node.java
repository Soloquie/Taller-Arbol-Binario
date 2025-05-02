package uniquindio.edu.co.binarytree.model;
/*
Clase Nodo
 */
public class Node {
    private int data;
    private Node childLeft = null;
    private Node childRight = null;

    /**
     * Constructor de la clase Node.
     * @param data El valor del nodo
     */
    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getChildLeft() {
        return childLeft;
    }

    public void setChildLeft(Node childLeft) {
        this.childLeft = childLeft;
    }

    public Node getChildRight() {
        return childRight;
    }

    public void setChildRight(Node childRight) {
        this.childRight = childRight;
    }
}
