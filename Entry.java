public class Entry {
    private Point point;
    private double coveringRadius;
    private MTreeNode childNode;

    public Entry(Point point) {
        this.point = point;
        this.coveringRadius = 0; // Por defecto
        this.childNode = null; // Por defecto
    }

    public Entry(Point point, double coveringRadius, MTreeNode childNode) {
        this.point = point;
        this.coveringRadius = coveringRadius;
        this.childNode = childNode;
    }

    public Point getPoint() {
        return point;
    }

    public double getCoveringRadius() {
        return coveringRadius;
    }

    public MTreeNode getChildNode() {
        return childNode;
    }
}
