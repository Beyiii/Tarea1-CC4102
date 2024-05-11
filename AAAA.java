public class AAAA {
    /*
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

        for (List<Point> partition : partitions) {    //LINEA 27
            int minEntries = (int)Math.ceil((double)maxEntries/2);
            if (partition.size() < minEntries) {
                redistributePoints(partition, samples, partitions);
            }
        }

        // Se vuelve al paso dos
        if (samples.size() == 1){
            listPoints.addAll(samples);
            return buildMTree(listPoints);
        }

        // Se obtiene el arbol tj
        NodePoint tree = new NodePoint();
        for (List<Point> partition : partitions) {
            NodePoint childNodePoint = buildMTree(partition);   //LINEA 45
            tree.addNodePoint(childNodePoint);
        }
        return tree;
    }

    // Hace F 
    private List<Point> selectSamples(List<Point> points) {
        int x = (int)Math.ceil((double)points.size()/maxEntries);
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

     */
}
