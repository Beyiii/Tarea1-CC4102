import java.util.ArrayList;
import java.util.List;

public class MTreeSearcher {
    private MtreeCount count; 
    
    public List<Point> search(IMTreeNode root, Ball query) {
        List<Point> result = new ArrayList<>();
        count = new MtreeCount();

        root.searchRecursive(count, query, result);
        return result;
    }

    public MtreeCount getCount(){
        return count;
    }

    /* 
    private void searchRecursive(MTreeNode node, Ball query, List<Point> result) {
        if (node.isLeaf()) {
            for (Entry entry : node.getEntries()) {
                Point p = entry.getPoint();
                if (query.contains(p)) {
                    result.add(p);
                }
            }
        } else {
            for (Entry entry : node.getEntries()) {
                Point p = entry.getPoint();
                double cr = entry.getCoveringRadius();
                if (query.intersects(p, cr)) {
                    MTreeNode childNode = entry.getChildNode();
                    searchRecursive(childNode, query, result);
                }
            }
        }
    }
    */
}