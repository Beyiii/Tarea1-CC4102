// hola 
/* wow */


import java.util.ArrayList;
import java.util.List;

class MTreeNode {
    // Implementación básica de un nodo del árbol M
    private List<Object> objects; // Lista de objetos almacenados en el nodo
    private List<MTreeNode> children; // Lista de nodos hijos
    private MTreeNode parent; // Nodo padre

    public MTreeNode() {
        objects = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    // Métodos para añadir y obtener objetos y nodos hijos
    public void addObject(Object obj) {
        objects.add(obj);
    }

    public List<Object> getObjects() {
        return objects;
    }

    public void addChild(MTreeNode child) {
        children.add(child);
        child.setParent(this);
    }

    public List<MTreeNode> getChildren() {
        return children;
    }

    public void setParent(MTreeNode parent) {
        this.parent = parent;
    }

    public MTreeNode getParent() {
        return parent;
    }
}

public class MTreeExample {
    public static void main(String[] args) {
        // Crear un nodo raíz
        MTreeNode rootNode = new MTreeNode();

        // Crear nodos y añadir objetos
        MTreeNode childNode1 = new MTreeNode();
        childNode1.addObject("Objeto1");
        MTreeNode childNode2 = new MTreeNode();
        childNode2.addObject("Objeto2");

        // Añadir nodos hijos al nodo raíz
        rootNode.addChild(childNode1);
        rootNode.addChild(childNode2);

        // Obtener los objetos almacenados en el nodo raíz
        List<Object> objectsInRoot = rootNode.getObjects();
        System.out.println("Objetos en el nodo raíz:");
        for (Object obj : objectsInRoot) {
            System.out.println(obj);
        }

        // Obtener los nodos hijos del nodo raíz
        List<MTreeNode> childrenOfRoot = rootNode.getChildren();
        System.out.println("\nNodos hijos del nodo raíz:");
        for (MTreeNode child : childrenOfRoot) {
            System.out.println(child);
        }
    }
}