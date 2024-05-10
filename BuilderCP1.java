import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BuilderCP1 {
    private int maxEntries; // Máxima cantidad de entradas permitidas en un nodo B
    
    public BuilderCP1(int maxEntries) {
        this.maxEntries = maxEntries;
    }

    public NodePoint buildMTree(List<Point> points) {
        List<Point> listPoints = points; 
        if (points.size() <= maxEntries) {
            NodePoint tree = new NodePoint();
            for (Point point : points) {
                tree.addPoint(point);
            }
            return tree;
        }

        // Caso recursivo
        List<Point> samples = selectSamples(listPoints);
        List<List<Point>> partitions = assignPointsToSamples(points, samples);

        for (List<Point> partition : partitions) {
            int minEntries = (int)Math.ceil((double)maxEntries/2);
            if (partition.size() < minEntries) {
                redistributePoints(partition, samples, partitions);
            }
        }

        // Se vuelve al paso dos
        if (samples.size() == 1){
            System.err.println("Se devuelve al paso 2");
            listPoints.addAll(samples);
            return buildMTree(listPoints);
        }

        // Se obtiene el arbol tj
        NodePoint tree = new NodePoint();
        System.err.println("empieza recursion");
        for (List<Point> partition : partitions) {
            NodePoint childNodePoint = buildMTree(partition);
            tree.addNodePoint(childNodePoint);
        }
        System.err.println("Retorna arbol");
        System.err.println(samples);
        System.err.println(partitions);
        //NodePoint nodePoint1 =  tree.getListNodePoints().get(0);
        //NodePoint nodePoint2 =  tree.getListNodePoints().get(1);
        //System.err.println(tree.getListNodePoints());
        //System.err.println(nodePoint1.getListNodePoints());
        //System.err.println(nodePoint2.getListNodePoints());
        //System.err.println(nodePoint1.getListPoints());
        //System.err.println(nodePoint2.getListPoints());
        return tree;
    }

    // esto está malo pero es lo que había despues del for
    //MTreeNodeInternal parentNode = new MTreeNode();
    //    for (MTreeNode childNode : childNodes) {
            // parentNode.addEntry(new Entry(childNode)); Aquí hay algo rarou
    //    }

    //    return parentNode;

    
    
    // Hace F 
    private List<Point> selectSamples(List<Point> points) {
        System.err.println("empieza función samples");
        System.err.println(points);
        System.err.println(points.size());
        System.err.println(maxEntries);
        System.err.println((double)points.size()/maxEntries);
        int x = (int)Math.ceil((double)points.size()/maxEntries);
        System.err.println(x);
        int k = Math.min(maxEntries, x);
        System.err.println(k);
        List<Point> samples = new ArrayList<>();
        Random random = new Random();
        while (samples.size() < k) {
            int index = random.nextInt(points.size());
            Point sample = points.get(index);
            samples.add(sample); 
            points.remove(index);      
        }
        System.err.println("Termina función samples");
        System.err.println(points);
        System.err.println(samples);
        return samples;
    }
   
    // Asignar puntos al sample
    private List<List<Point>> assignPointsToSamples(List<Point> points, List<Point> samples) {
System.err.println("empieza funcion assignPoints");
        System.err.println(samples);
        System.err.println(points);

        List<List<Point>> partitions = new ArrayList<>();
        for (Point sample : samples) {
            partitions.add(new ArrayList<>());
            partitions.get(partitions.size()-1).add(sample);
        }
        for (Point point : points) {
            Point nearestSample = findNearestSample(point, samples);
            partitions.get(samples.indexOf(nearestSample)).add(point);
        }

        System.err.println("termina funcion assignPoints");
        System.err.println(samples);
        System.err.println(points);
        System.err.println(partitions);
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
        System.err.println("empieza redistribucion");
        System.err.println(samples);
        System.err.println(partition);
        System.err.println(partitions);

        int indice = partitions.indexOf(partition);
        samples.remove(indice);
        partitions.remove(indice);
        for (Point point : partition){
            Point nearestSample = findNearestSample(point, samples);
            partitions.get(samples.indexOf(nearestSample)).add(point);
        }
    }
}

