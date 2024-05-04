import java.util.ArrayList;
import java.util.List;

public class MTreeSearcher {
    
    public List<Point> search(MTreeNode root, Ball query) {
        List<Point> result = new ArrayList<>();
        searchRecursive(root, query, result);
        return result;
    }

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
}