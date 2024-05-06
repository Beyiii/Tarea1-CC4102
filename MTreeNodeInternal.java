import java.util.ArrayList;
import java.util.List;

/**
 Clase concreta para nodos internos.
 */
public class MTreeNodeInternal implements IMTreeNode {
    //Entradas.
    private List<Entry> entries;

    //Constructor.
    public MTreeNodeInternal() {
        this.entries = new ArrayList<>();
    }

    //Getter.
    public List<Entry> getEntries() {
        return entries;
    }

    @Override
    public void searchRecursive(MtreeCount count, Ball query, List<Point> result) {
        for (Entry entry : this.getEntries()) {
            Point p = entry.getPoint();
            if (entry.isLeaf()){

                if (query.contains(p)) {
                    result.add(p);
                }
            }
            else{
                double cr = entry.getCoveringRadius();
                if (query.intersects(p, cr) ) {
                    IMTreeNode childNode = entry.getChildNode();
                    count.addCount();
                    childNode.searchRecursive(count, query, result);
                }
            }
        }
    }

    public void addEntry(Entry entry) {
            entries.add(entry);
    }
    
}