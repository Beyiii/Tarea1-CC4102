
/**
 Clase concreta para las entradas de un nodo.
 */

public class Entry{

    //Parámetros de una entrada (p, cr, a).
    private Point point;
    private double coveringRadius;
    private IMTreeNode childNode;
    private boolean isLeaf;

    //Constructor para un nodo hoja.
    public Entry(Point point) {
        this.point = point;
        this.coveringRadius = 0; // Por defecto
        this.childNode = null; // Por defecto
        this.isLeaf = true;
    }

    //Constructor para un nodo interno.
    public Entry(Point point, double coveringRadius, IMTreeNode childNode) {
        this.point = point;
        this.coveringRadius = coveringRadius;
        this.childNode = childNode;
        this.isLeaf = false;
    }

    //getter.
    public Point getPoint() {
        return point;
    }

    //getter.
    public double getCoveringRadius() {
        return coveringRadius;
    }

    //getter.
    public IMTreeNode getChildNode() {
        return childNode;
    }

    //getter.
    public boolean isLeaf(){
        return isLeaf;
    }
}
