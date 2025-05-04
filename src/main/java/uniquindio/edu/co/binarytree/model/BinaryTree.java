package uniquindio.edu.co.binarytree.model;

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
        if(weight == 0)
            System.out.println("El arbol esta vacio");
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
        if(weight == 0)
            System.out.println("El arbol esta vacio");
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
        if(weight == 0)
            System.out.println("El arbol esta vacio");
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

    //metodo para obtener la altura del arbol
    public int getHeight(){
        return getHeight(root, 0);
    }

    //metodo recursivo para obtener la altura del arbol
    private int getHeight(Node aux, int height){
        if (aux == null) {
            return height;
        }
        int leftHeight = getHeight(aux.getChildLeft(), height++);
        int rightHeight = getHeight(aux.getChildRight(), height++);
        return Math.max(leftHeight, rightHeight) ;
    }

    //metodo para obtener el nivel de un nodo
    public int getLevel(int data){
        return getLevel(data, root, 0);
    }

    //metodo recursivo para obtener el nivel de un nodo
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

    //metodo para obtener el menor dado un nodo
    private int getMin(Node node){
        int min = node.getData();
        while(node.getChildLeft() != null){
            min = node.getChildLeft().getData();
            node = node.getChildLeft();
        }

        return min;
    }

    //metodo para eliminar un nodo
    public void deleteNode(int data){
        root = deleteNode(root, data);
        weight--;
    }

    //metodo recursivo para eliminar un nodo
    private Node deleteNode(Node aux, int data) {
        if(aux == null)
            return null;
        if(aux.getData() > data)
            return deleteNode(aux.getChildLeft(), data);
        else if (aux.getData() < data)
            return deleteNode(aux.getChildRight(), data);
        else{
            if(aux.getChildLeft() == null)
                return aux.getChildRight();
            if(aux.getChildRight() == null)
                return aux.getChildLeft();
            aux.setData(getMin(aux.getChildRight()));
            aux.setChildRight(deleteNode(aux.getChildRight(), aux.getData()));
        }
        return aux;
    }

    //metodo para contar hojas
    public int countLeaves(){
        return countLeaves(root);
    }

    //metodo recursivo para contar hojas
    private int countLeaves(Node aux){
        if(aux == null){
            return 0;
        }
        if(aux.getChildLeft() == null && aux.getChildRight() == null)
            return 1;
        int l = countLeaves(aux.getChildLeft());
        int r = countLeaves(aux.getChildRight());
        return l+r;
    }

    //metodo para obtener el nodo minimo en el arbol
    public int getMinor(){
        Node aux = root;
        while(aux.getChildLeft() != null){
            aux = aux.getChildLeft();
        }
        return aux.getData();
    }

    //metodo para obtener el nodo mayor en el arbol
    public int getMayor(){
        Node aux = root;
        while(aux.getChildRight() != null){
            aux = aux.getChildRight();
        }
        return aux.getData();
    }

    //metodo para eliminar el arbol
    public void deleteTree(){
        root = null;
        weight = 0;
    }

    public void printAmplitude(){
        
    }

}
