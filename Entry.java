
/**
 Clase concreta para las entradas de un nodo.
 */

public class Entry{

    //Parámetros de una entrada (p, cr, a).
    private Point point;
    private double coveringRadius;
    private IMTreeNode childNode;

    //Constructor para un nodo hoja.
    public Entry(Point point) {
        this.point = point;
        this.coveringRadius = 0; // Por defecto
        this.childNode = null; // Por defecto
    }

    //Constructor para un nodo interno.
    public Entry(Point point, double coveringRadius, IMTreeNode childNode) {
        this.point = point;
        this.coveringRadius = coveringRadius;
        this.childNode = childNode;
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
}
