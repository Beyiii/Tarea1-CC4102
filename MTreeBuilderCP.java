import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MTreeBuilderCP {
    private int maxEntries; // Máxima cantidad de entradas permitidas en un nodo B

    public MTreeBuilderCP(int maxEntries) {
        this.maxEntries = maxEntries;
    }

    public MTreeNodeInternal buildMTree(List<Point> points) {
        List<Point> listPoints = points; 
        if (points.size() <= maxEntries) {
            MTreeNodeInternal tree = new MTreeNodeInternal();
            for (Point point : points) {
                MTreeNodeLeaf leaf = new MTreeNodeLeaf(point);
                tree.addEntry(leaf.getEntry());
            }
            return tree;
        }

        // Caso recursivo
        List<Point> samples = selectSamples(listPoints);
        List<List<Point>> partitions = assignPointsToSamples(points, samples);

        for (List<Point> partition : partitions) {
            int minEntries = (int)Math.round(maxEntries/2);
            if (partition.size() < minEntries) {
                redistributePoints(partition, samples, partitions);
            }
        }

        //System.err.println(partitions);

        // Se vuelve al paso dos
        if (samples.size() == 1){
            return buildMTree(points);
        }

        // Se obtiene el arbol tj
        List<MTreeNodeInternal> childNodes = new ArrayList<>();
        //System.err.println(childNodes);
        for (List<Point> partition : partitions) {
            MTreeNodeInternal childNode = buildMTree(partition);
            //System.err.println(childNode);
            childNodes.add(childNode);
        }
        

        MTreeNodeInternal parentNode = new MTreeNodeInternal();
        return parentNode;
    }

    // esto está malo pero es lo que había despues del for
    //MTreeNodeInternal parentNode = new MTreeNode();
    //    for (MTreeNode childNode : childNodes) {
            // parentNode.addEntry(new Entry(childNode)); Aquí hay algo rarou
    //    }

    //    return parentNode;

    
    
    // Hace F 
    private List<Point> selectSamples(List<Point> points) {
        int x = (int)Math.round(points.size() / maxEntries);
        int k = Math.min(maxEntries, x);
        List<Point> samples = new ArrayList<>();
        Random random = new Random();
        while (samples.size() < k) {
            int index = random.nextInt(points.size());
            Point sample = points.get(index);
            samples.add(sample); 
            points.remove(index);      
        }
        return samples;
    }
   
    // Asignar puntos al sample
    private List<List<Point>> assignPointsToSamples(List<Point> points, List<Point> samples) {
        List<List<Point>> partitions = new ArrayList<>();
        for (Point sample : samples) {
            partitions.add(new ArrayList<>());
            partitions.get(partitions.size()-1).add(sample);
        }
        for (Point point : points) {
            Point nearestSample = findNearestSample(point, samples);
            partitions.get(samples.indexOf(nearestSample)).add(point);
        }
        return partitions;
    }

    // Ve cual sample es el más cercano al punto point
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
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

/*
F = {s1, s2, s3}
partition={{1},{2},{3}}
partitions{{2,a,b,c},{3}}
*/  
    // Implementa aquí la redistribución de puntos
    private void redistributePoints(List<Point> partition, List<Point> samples, List<List<Point>> partitions) {
        int indice = partitions.indexOf(partition);
        samples.remove(indice);
        partitions.remove(indice);
        for (Point point : partition){
            Point nearestSample = findNearestSample(point, samples);
            partitions.get(samples.indexOf(nearestSample)).add(point);
        }
    }
}