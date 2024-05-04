import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MTreeBuilderCP {
    private int minEntries; // Mínima cantidad de entradas permitidas en un nodo
    private int maxEntries; // Máxima cantidad de entradas permitidas en un nodo

    public MTreeBuilderCP(int minEntries, int maxEntries) {
        this.minEntries = minEntries;
        this.maxEntries = maxEntries;
    }

    public MTreeNode buildMTree(List<Point> points) {
        if (points.size() <= maxEntries) {
            MTreeNode leafNode = new MTreeNode();
            for (Point point : points) {
                leafNode.addEntry(new Entry(point));
            }
            return leafNode;
        }

        List<Point> samples = selectSamples(points);
        List<List<Point>> partitions = assignPointsToSamples(points, samples);

        for (List<Point> partition : partitions) {
            if (partition.size() < minEntries) {
                redistributePoints(partition, samples, partitions);
                return buildMTree(points);
            }
        }

        List<MTreeNode> childNodes = new ArrayList<>();
        for (List<Point> partition : partitions) {
            MTreeNode childNode = buildMTree(partition);
            childNodes.add(childNode);
        }

        MTreeNode parentNode = new MTreeNode();
        for (MTreeNode childNode : childNodes) {
            // parentNode.addEntry(new Entry(childNode)); Aquí hay algo rarou
        }

        return parentNode;
    }

    private List<Point> selectSamples(List<Point> points) {
        int k = Math.min(maxEntries, points.size() / maxEntries);
        List<Point> samples = new ArrayList<>();
        Random random = new Random();
        while (samples.size() < k) {
            Point sample = points.get(random.nextInt(points.size()));
            if (!samples.contains(sample)) {
                samples.add(sample);
            }
        }
        return samples;
    }

    private List<List<Point>> assignPointsToSamples(List<Point> points, List<Point> samples) {
        List<List<Point>> partitions = new ArrayList<>();
        for (Point sample : samples) {
            partitions.add(new ArrayList<>());
        }
        for (Point point : points) {
            Point nearestSample = findNearestSample(point, samples);
            partitions.get(samples.indexOf(nearestSample)).add(point);
        }
        return partitions;
    }

    private Point findNearestSample(Point point, List<Point> samples) {
        Point nearestSample = null;
        double minDistance = Double.MAX_VALUE;
        for (Point sample : samples) {
            double distance = calculateDistance(point, sample);
            if (distance < minDistance) {
                minDistance = distance;
                nearestSample = sample;
            }
        }
        return nearestSample;
    }

    private double calculateDistance(Point p1, Point p2) {
        // Implementa aquí el cálculo de la distancia entre dos puntos
        return 0; // Esto es solo un placeholder, debes implementar la función real
    }

    private void redistributePoints(List<Point> partition, List<Point> samples, List<List<Point>> partitions) {
        // Implementa aquí la redistribución de puntos
        // Esto es solo un placeholder, debes implementar la función real
    }
}