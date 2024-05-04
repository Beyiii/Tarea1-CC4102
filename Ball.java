public class Ball {
    private Point center;
    private double radius;

    public Ball(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public boolean contains(Point point) {
        double dx = point.getX() - center.getX();
        double dy = point.getY() - center.getY();
        return dx * dx + dy * dy <= radius * radius;
    }

    public boolean intersects(Point point, double cr) {
        double dx = point.getX() - center.getX();
        double dy = point.getY() - center.getY();
        double distanceSquared = dx * dx + dy * dy;
        double radiusSum = radius + cr;
        return distanceSquared <= radiusSum * radiusSum;
    }
}

