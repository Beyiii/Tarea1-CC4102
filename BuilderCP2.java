import java.util.List;

public class BuilderCP2 {
    int maxEntries;
    int minEntries;

    public BuilderCP2(int maxEntries) {
        this.maxEntries = maxEntries;
        this.minEntries = (int)Math.ceil((double)maxEntries/2);
    }
    
    public NodePoint buildMTree(NodePoint nodePoint, List<Point> samples) {
        //punto 7

        NodePoint punto7 = tjTrees(nodePoint);

        NodePoint nulo = new NodePoint();
        return nulo;

    }

    private NodePoint tjTrees(NodePoint nodePoint){
        if (nodePoint.getSize() < minEntries){

        }
        return nodePoint;
    }


}
