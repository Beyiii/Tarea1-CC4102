import java.util.ArrayList;
import java.util.List;

//Lista de puntos o lista de NodePoints
public class NodePoint {
    private List<Point> listPoints;
    private List<NodePoint> listNodePoints;

    public NodePoint() {
        this.listPoints = new ArrayList<>();
        this.listNodePoints = new ArrayList<>();
    }

    public List<Point> getListPoints() {
        return listPoints;
    }

    public List<NodePoint> getListNodePoints() {
        return listNodePoints;
    }

    public void addPoint(Point point) {
            listPoints.add(point);
    }
        
    public void addNodePoint(NodePoint nodePoint) {
        listNodePoints.add(nodePoint);
    }
    
    public int getSize(){
        return listNodePoints.size();
    }
    
}
