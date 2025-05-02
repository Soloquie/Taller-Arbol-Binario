package uniquindio.edu.co.binarytree.model;

import ch.qos.logback.core.net.SyslogOutputStream;

/*
 Clase Arbol Binario
 */
public class BinaryTree {
    private Node root = null;
    private int weight = 0;

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(int data) {
        root = insertRecursive(root, data);
        weight++;
    }

    private Node insertRecursive(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.getData()) {
            root.setChildLeft(insertRecursive(root.getChildLeft(), data));
        }
        else if (data > root.getData()) {
            root.setChildRight(insertRecursive(root.getChildRight(), data));
        }
        return root;
    }

    //metodo para recorrer arbol binario izquierda - raiz - derecha
    public void inorder(){
        inorder(root);
    }

    //metodo recursivo para recorrer arbol binario izquierda - raiz - derecha
    private void inorder(Node aux){
        if (aux == null)
            return;
        inorder(aux.getChildLeft());
        System.out.println(aux.getData());
        inorder(aux.getChildRight());
    }

    //metodo para recorrer arbol binario raiz - izquierda - derecha
    public void preorder(){
        preorder(root);
    }

    //metodo recursivo para recorrer arbol binario raiz - izquierda - derecha
    private void preorder(Node aux){
        if (aux == null)
            return;
        System.out.println(aux.getData());
        preorder(aux.getChildLeft());
        preorder(aux.getChildRight());
    }

    //metodo para recorrer arbol binario izquierda-derecha.raiz
    public void postorder(){
        postorder(root);
    }

    //metodo recursivo para recorrer arbol binario izquierda-derecha.raiz
    private void postorder(Node aux){
        if (aux == null)
            return;
        postorder(aux.getChildLeft());
        postorder(aux.getChildRight());
        System.out.println(aux.getData());
    }

    //metodo para buscar si en el arbol existe un nodo con el valor @param data
    public boolean search(int data) {
        return search(root, data);
    }

    private boolean search(Node aux, int data) {
        // Si el nodo actual es nulo, significa que no se encontró el valor
        if (aux == null) {
            return false;
        }

        // Si el dato del nodo actual es igual al valor que buscamos, lo hemos encontrado
        if (aux.getData() == data) {
            return true;
        }

        // Continuamos buscando en los subárboles izquierdo y derecho
        boolean foundInLeft = search(aux.getChildLeft(), data);
        boolean foundInRight = search(aux.getChildRight(), data);

        // Si se encontró el dato en cualquiera de los subárboles, retornamos true
        return foundInLeft || foundInRight;
    }

    public int getWeight(){
        return weight;
    }

    public int getHeight(){
        return getHeight(root, 0);
    }

    private int getHeight(Node aux, int height){
        if (aux == null) {
            return height;
        }
        int leftHeight = getHeight(aux.getChildLeft(), height++);
        int rightHeight = getHeight(aux.getChildRight(), height++);
        return Math.max(leftHeight, rightHeight) ;
    }

    public int getLevel(int data){
        return getLevel(data, root, 0);
    }

    private int getLevel(int data, Node aux, int level){
        if (!search(data)) {
            System.out.println("No existe el elemento");
            return -1;
        }
        if(aux.getData() == data){
            return level;
        }
        int leftHeight = getHeight(aux.getChildLeft(), level++);
        int rightHeight = getHeight(aux.getChildRight(), level++);
        return Math.max(leftHeight, rightHeight) ;
    }


}
